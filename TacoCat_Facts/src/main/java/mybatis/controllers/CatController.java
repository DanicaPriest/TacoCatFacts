package mybatis.controllers;


import mybatis.Exceptions.ApiKeyException;
import mybatis.Exceptions.UserNullException;
import mybatis.model.CatFacts.CatRoot;
import mybatis.model.CatFacts.OnlyFacts;
import mybatis.services.CatService;
import mybatis.services.TacoCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/catfacts")
public class CatController {

    @Autowired
    CatService catService;

    @Autowired
    TacoCatService tacoCatService;

    //Get
    @RequestMapping("/facts")
    public CatRoot getFacts(@RequestParam (value="user")String user,
                            @RequestParam(value="api-key")String key) throws ApiKeyException, UserNullException {
        if(tacoCatService.verify(user, key)){
        return catService.getFacts();} throw new ApiKeyException();
    }

    //Put
    @RequestMapping("/load")
    public ArrayList<OnlyFacts> insertCatSummary(@RequestParam (value="user")String user,
                                                 @RequestParam(value="api-key")String key) throws ApiKeyException, UserNullException {
        ArrayList<OnlyFacts> text = catService.onlyFacts();
        if (tacoCatService.verify(user, key)){
        catService.insertCatSummary(text);
        return text;} throw new ApiKeyException();
    }

    //Create
    @RequestMapping(method = RequestMethod.POST, value = "/")
    public OnlyFacts addCF(@RequestParam (value="user")String user,
                           @RequestParam(value="api-key")String key,
                           @RequestBody OnlyFacts fact) throws ApiKeyException, UserNullException {
        if (tacoCatService.verify(user, key)){
        return catService.addCF(fact);} throw new ApiKeyException();
    }

    //Read
    @RequestMapping("/onlyfacts")
    public ArrayList<OnlyFacts> onlyFacts(@RequestParam (value="user")String user,
                                          @RequestParam(value="api-key")String key) throws ApiKeyException, UserNullException {
        if (tacoCatService.verify(user, key)){
        return catService.onlyFacts();} throw new ApiKeyException();
    }

    //Update
    @RequestMapping(method = RequestMethod.PATCH, value = "/")
    public OnlyFacts updateCF(@RequestParam (value="user")String user, @RequestParam(value="api-key")String key,
                              @RequestBody OnlyFacts fact) throws ApiKeyException, UserNullException {
        if (tacoCatService.verify(user, key)){
        return catService.updateCF(fact);} throw new ApiKeyException();
    }

    //Delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/")
    public OnlyFacts deleteCF(@RequestParam (value="user")String user, @RequestParam(value="api-key")String key,
                              @RequestBody OnlyFacts fact) throws ApiKeyException, UserNullException {
        if (tacoCatService.verify(user, key)){
        return catService.deleteCF(fact);} throw  new ApiKeyException();
    }

}
