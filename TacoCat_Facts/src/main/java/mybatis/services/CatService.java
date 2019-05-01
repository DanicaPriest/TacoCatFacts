package mybatis.services;

import mybatis.mappers.CatMapper;
import mybatis.model.CatFacts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CatService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CatMapper catMapper;


    //gets a random cat fact from the api and maps it to an object
    public CatRoot getCatFactObj() {
        String url = "https://catfact.ninja/fact";

        CatRoot all = restTemplate.getForObject(url, CatRoot.class);

        return all;
    }

    //gets a random cat fact from the api and returns the fact as a String
    public String getCatFact() {
        String url = "https://catfact.ninja/fact";

        CatRoot all = restTemplate.getForObject(url, CatRoot.class);
        String catFact = all.getFact();

        return catFact;
    }




    //gets a url from a random cat gif from the Giphy api
    public String catPic(){

        String url = "http://api.giphy.com/v1/gifs/random?tag=cats&rating=g&api_key=HmobnYApZpsQRklgB8mnR19J2mkgcS0R";
        GiphyRoot newpic = restTemplate.getForObject(url, GiphyRoot.class);

        return newpic.getData().getBitly_url();
    }

    //inserts cat facts into a database
    public void insertCatSummary(CatRoot fact) {

            catMapper.insertCatFacts(fact);
    }

    public CatRoot addCF(CatRoot fact) {
        catMapper.insertCatFacts(fact);
        return catMapper.getCF(fact.getFact());
    }

    public CatRoot updateCF(CatRoot fact) {
        catMapper.updateCF(fact);
        return catMapper.getCF(fact.getFact());
    }

    public CatRoot deleteCF(CatRoot fact) {
        catMapper.deleteCF(fact);
        return catMapper.getCFById(fact.getId());
    }
}
