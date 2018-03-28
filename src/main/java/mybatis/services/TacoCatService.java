package mybatis.services;

import mybatis.mappers.CatMapper;
import mybatis.mappers.TacoCatMapper;
import mybatis.model.CatFacts.OnlyFacts;
import mybatis.model.TacoCat.TacoRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TacoCatService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    TacoCatMapper tacoCatMapper;

    @Autowired
    CatService catService;

    public TacoRoot getTC() {

        String webUrl = "http://taco-randomizer.herokuapp.com/random/?full-taco=true";

        TacoRoot tacocat = restTemplate.getForObject(webUrl, TacoRoot.class);
        tacocat.setCat_fact(catService.oneFact());

        return tacocat;
    }
}
