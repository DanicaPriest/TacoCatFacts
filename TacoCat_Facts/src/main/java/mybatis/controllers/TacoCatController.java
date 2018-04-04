package mybatis.controllers;


import mybatis.model.ApiKeyException;
import mybatis.model.TacoCat.TacoRoot;
import mybatis.model.User;
import mybatis.services.TacoCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tacocatfacts")
public class TacoCatController {

    @Autowired
    TacoCatService tacoCatService;


    @RequestMapping("/")
    public TacoRoot getTC(@RequestParam (value="user")String user,
                          @RequestParam(value="api-key")String key) throws ApiKeyException {
        if (tacoCatService.verify(user, key)){
        return tacoCatService.getTC();} throw new ApiKeyException();
    }

    @RequestMapping(value="/tweet")
    public String createTweet(@RequestParam (value="user")String user,
                              @RequestParam(value="api-key")String key) throws ApiKeyException {
        if(tacoCatService.verify(user, key)){
        return tacoCatService.createTweet(tacoCatService.getTweet());} throw new
                ApiKeyException();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public User addUser(@RequestBody User user) {
        return tacoCatService.addUser(user);
    }


}
