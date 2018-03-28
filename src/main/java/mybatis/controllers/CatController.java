package mybatis.controllers;


import mybatis.model.CatFacts.All;
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

    //Get
    @RequestMapping("/facts")
    public CatRoot getFacts() {
        return catService.getFacts();
    }

    //Put
    @RequestMapping("/load")
    public ArrayList<OnlyFacts> insertCatSummary() {
        ArrayList<OnlyFacts> text = catService.onlyFacts();
        catService.insertCatSummary(text);
        return text;
    }

    //Create
    @RequestMapping(method = RequestMethod.POST, value = "/")
    public OnlyFacts addCF(@RequestBody OnlyFacts fact) {
        return catService.addCF(fact);
    }

    //Read
    @RequestMapping("/onlyfacts")
    public ArrayList<OnlyFacts> onlyFacts() {
        return catService.onlyFacts();
    }

    //Update
    @RequestMapping(method = RequestMethod.PATCH, value = "/")
    public OnlyFacts updateCF(@RequestBody OnlyFacts fact) {
        return catService.updateCF(fact);
    }

    //Delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/")
    public OnlyFacts deleteCF(@RequestBody OnlyFacts fact) {
        return catService.deleteCF(fact);
    }

}
