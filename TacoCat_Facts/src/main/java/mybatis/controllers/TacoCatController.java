package mybatis.controllers;


import mybatis.Exceptions.APIUnavailableException;
import mybatis.Exceptions.ApiKeyException;
import mybatis.Exceptions.CustomException;
import mybatis.Exceptions.UserNullException;
import mybatis.model.TacoCat.TacoRoot;
import mybatis.model.User;
import mybatis.services.TacoCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twitter4j.TwitterException;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


@RestController
@RequestMapping("/tacocatfacts")
public class TacoCatController {

    @Autowired
    TacoCatService tacoCatService;


    @RequestMapping("/")
    public TacoRoot getTC(@RequestParam (value="user")String user,
                          @RequestParam(value="api-key")String key) throws ApiKeyException, UserNullException {
        if (tacoCatService.verify(user, key)){
        return tacoCatService.getTC();} throw new ApiKeyException();
    }

    @RequestMapping(value="/tweet")
    public String createTweet(@RequestParam (value="user", required = true)String user,
                              @RequestParam(value="api-key")String key) throws ApiKeyException, TwitterException, UserNullException {
        if (tacoCatService.verify(user, key)) {
            return tacoCatService.createTweet(tacoCatService.getTweet());
        } else {
            throw new ApiKeyException();
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public String addUser(@RequestParam (value="user")String username) throws NoSuchAlgorithmException {
        return tacoCatService.addUser(username);
    }

    @RequestMapping("/generror1")
    public ArrayList<User> generror1() throws APIUnavailableException {
        throw new APIUnavailableException();
    }

}
