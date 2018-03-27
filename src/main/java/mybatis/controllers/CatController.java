package mybatis.controllers;



import mybatis.model.CatFacts.CatRoot;
import mybatis.model.CatFacts.OnlyFacts;
import mybatis.services.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/catfacts")
public class CatController {

    @Autowired
    CatService catService;

    @RequestMapping("/facts")
    public CatRoot getFacts(){
        return catService.getFacts();
    }

    @RequestMapping("/onlyfacts")
    public ArrayList<OnlyFacts> onlyFacts() {
        return catService.onlyFacts();
    }

@RequestMapping(method = RequestMethod.POST, value = "/")
    public OnlyFacts insertCatSummary(@RequestBody OnlyFacts cat_fact) {
        return catService.insertCatSummary(cat_fact);
    }

}
