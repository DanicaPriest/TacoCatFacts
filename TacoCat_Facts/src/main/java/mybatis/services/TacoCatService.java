package mybatis.services;


import mybatis.mappers.TacoCatMapper;
import mybatis.model.TacoCat.TacoRoot;
import mybatis.model.TacoCat.TacoTwitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

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

    public String createTweet(String tweet) {
        Twitter twitter = new TwitterFactory().getInstance();
        Status status = null;
        try {
            status = twitter.updateStatus(tweet);
        } catch (TwitterException te) {
            System.out.println("Failed to post tweet: " + te.getMessage());
        }
        return status.getText();
    }

    public String getTweet() {

        TacoRoot taco = getTC();
        StringBuilder tweet = new StringBuilder();
        tweet.append(taco.getName());
        tweet.append("  " + taco.getUrl());
        tweet.append(" CAT FACT: " + taco.getCat_fact());
        tweet.append(catService.catPic());

        String result = tweet.toString();
        return result;
    }



}
