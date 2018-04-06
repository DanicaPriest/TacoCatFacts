package mybatis.services;


import mybatis.Exceptions.UserNullException;
import mybatis.mappers.TacoCatMapper;
import mybatis.model.TacoCat.TacoRoot;
import mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;

@Service
public class TacoCatService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    TacoCatMapper tacoCatMapper;

    @Autowired
    CatService catService;

    //maps name, recipe and url to TacoRoot object then adds a random catfact from the catsfacts service
    public TacoRoot getTC() {

        String webUrl = "http://taco-randomizer.herokuapp.com/random/?full-taco=true";

        TacoRoot tacocat = restTemplate.getForObject(webUrl, TacoRoot.class);
        tacocat.setCat_fact(catService.oneFact());
        //load the object to the database
        tacoCatMapper.insertTacocatFacts(tacocat);

        return tacocat;
    }

    public String createTweet(String tweet) throws TwitterException {
        Twitter twitter = new TwitterFactory().getInstance();
        Status status = null;

        try {
            status = twitter.updateStatus(tweet);
        } catch (TwitterException te) {
            throw te;
        }
        return status.getText();
    }

    public String getTweet() {

        TacoRoot taco = getTC();
        StringBuilder tweet = new StringBuilder();
        tweet.append(taco.getName());
        tweet.append("  " + taco.getUrl());
        tweet.append(" CAT FACT: " + taco.getCat_fact());
        if (tweet.toString().length() < 280) {
            tweet.append(catService.catPic());
        }

        String result = tweet.toString();

        return result;
    }

    public String addUser(String user) throws NoSuchAlgorithmException {

        String apikey = generateKey();

        //assign key to user and put in database
        User newuser = new User();
        newuser.setApi_key(apikey);
        newuser.setUser(user);
        tacoCatMapper.insertUser(newuser);
        return newuser.getApi_key();

    }
    //generate api-key
    public String generateKey() throws NoSuchAlgorithmException {

        KeyGenerator newkey = KeyGenerator.getInstance("AES");
        newkey.init(128);
        SecretKey secretKey = newkey.generateKey();
        byte[] encoded = secretKey.getEncoded();
        return DatatypeConverter.printHexBinary(encoded);
    }

    public User getUser(String username) {
        return tacoCatMapper.getUser(username);
    }

    public boolean verify(String username, String apikey) throws UserNullException {
        User newUser = tacoCatMapper.getUser(username);
        try {
            newUser.getUser();
        } catch (Exception e) {
            throw new UserNullException();
        }
        String userapi = newUser.getApi_key();
        if (userapi.contentEquals(apikey)) {
            return true;
        }
        return false;
    }

}