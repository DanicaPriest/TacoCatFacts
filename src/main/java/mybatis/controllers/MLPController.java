package mybatis.controllers;

import mybatis.model.MLP.MLPOverview;
import mybatis.model.MLP.MLPRoot;
import mybatis.services.MLPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/mlp")
public class MLPController {

    @Autowired
    MLPService mlpService;



    //GET
    //returns one random image
    @RequestMapping("/random")
    public MLPOverview getRandom() {
        return mlpService.getRandom();
    }

    //PUT
    @RequestMapping("/")
    public String loadMLP(@RequestParam(value="ldb", defaultValue="10") String resultNum) {
        mlpService.loadMLP(resultNum);
        return "your database has loaded with " + resultNum + " new Ponies";
    }

    //Create
    @RequestMapping(method = RequestMethod.POST, value = "/")
    public MLPOverview insertNewMLP(@RequestBody MLPOverview results) {
        mlpService.insertMLP(results);
        return results;
    }

    //Read
    //searches for a query then returns the results
    @RequestMapping("/search")
    public MLPRoot searchMLP(@RequestParam(value="q", defaultValue="pony") String query) {
        return mlpService.searchMLP(query);
    }

    //Update
    @RequestMapping(method = RequestMethod.PATCH, value = "/")
    public MLPOverview updateMLP(@RequestBody MLPOverview results){
     return mlpService.updateMLP(results);
    }
    //Delete

    @RequestMapping(method = RequestMethod.DELETE, value = "/")
    public MLPOverview deleteMLP(@RequestBody MLPOverview results){
        return mlpService.deleteMLP(results);
    }
}
