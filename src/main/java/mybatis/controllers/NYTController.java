package mybatis.controllers;


import mybatis.model.nyt.NYTRoot;
import mybatis.model.nyt.challenges.ResponseComparison;
import mybatis.services.NYTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nyt")

public class NYTController {
   @Autowired
    NYTService nytService;

    @RequestMapping("/search")
    public NYTRoot searchNYT(@RequestParam(value="query", defaultValue="cats") String query,
                             @RequestParam(value="p", defaultValue= "true") boolean persist) {
        return nytService.searchNYT(query);
    }

    @RequestMapping("/compare")
    public ResponseComparison compareNYTResults(@RequestParam(value="t1", required = true) String t1,
                                                @RequestParam(value="t2", required = true) String t2) {
        return nytService.compareNYTResults(t1, t2);
    }

}
