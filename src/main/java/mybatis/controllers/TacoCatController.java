package mybatis.controllers;


import mybatis.model.TacoCat.TacoRoot;
import mybatis.services.TacoCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/tacocatfacts")
public class TacoCatController {

    @Autowired
    TacoCatService tacoCatService;


    @RequestMapping("/")
    public TacoRoot getTC(){
        return tacoCatService.getTC();
    }

    @RequestMapping(value="/tweet")
    public String createTweet()  {
        return tacoCatService.createTweet(tacoCatService.getTweet());
    }


}
