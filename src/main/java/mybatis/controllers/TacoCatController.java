package mybatis.controllers;

import mybatis.model.TacoCat.TacoRoot;
import mybatis.services.CatService;
import mybatis.services.TacoCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tacocat")
public class TacoCatController {

    @Autowired
    TacoCatService tacoCatService;

    @Autowired
    CatService catService;

    @RequestMapping("/")
    public TacoRoot getTacoCat(){
        return tacoCatService.getTC();
    }
}
