package mybatis.controllers;


import mybatis.model.nyt.NYTRoot;
import mybatis.services.NYTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class NYTController {
   @Autowired
    NYTService nytService;

    @RequestMapping("/search")
    public NYTRoot searchNYT(@RequestParam(value="query", defaultValue="cats") String query) {
        return nytService.searchNYT(query);
    }

}
