package mybatis.services;

import mybatis.mappers.CatMapper;
import mybatis.model.CatFacts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class CatService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CatMapper catMapper;


    //gets cat facts from the api and maps them to an object
    public CatRoot getFact() {
        String url = "https://catfact.ninja/fact";

        CatRoot all = restTemplate.getForObject(url, CatRoot.class);

        return all;
    }

//creates an arrayList of the facts from the getFacts method
    public ArrayList<OnlyFacts> onlyFacts() {
        All[] text = getFacts().getAll();
        ArrayList<OnlyFacts> objArray = new ArrayList();

        for (All a : text) {
            OnlyFacts obj = new OnlyFacts();
            obj.setCat_fact(a.getText());
            objArray.add(obj);
        }
        return objArray;
    }

    //generates one random fact from the cat fact api
    public String oneFact() {

        String url = "https://catfact.ninja/fact";

        CatRoot all = restTemplate.getForObject(url, CatRoot.class);

        return all;
    }

    //gets a url from a random cat gif from the Giphy api
    public String catPic(){

        String url = "http://api.giphy.com/v1/gifs/random?tag=cats&rating=g&api_key=HmobnYApZpsQRklgB8mnR19J2mkgcS0R";
        GiphyRoot newpic = restTemplate.getForObject(url, GiphyRoot.class);

        return newpic.getData().getBitly_url();
    }

    //inserts cat facts into a database
    public void insertCatSummary(ArrayList<OnlyFacts> facts) {
        for (OnlyFacts f : facts) {
            catMapper.insertCatFacts(f);
        }
    }

    public OnlyFacts addCF(OnlyFacts fact) {
        catMapper.insertCatFacts(fact);
        return catMapper.getCF(fact.getCat_fact());
    }

    public OnlyFacts updateCF(OnlyFacts fact) {
        catMapper.updateCF(fact);
        return catMapper.getCF(fact.getCat_fact());
    }

    public OnlyFacts deleteCF(OnlyFacts fact) {
        catMapper.deleteCF(fact);
        return catMapper.getCFById(fact.getId());
    }
}
