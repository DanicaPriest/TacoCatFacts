package mybatis.services;

import mybatis.mappers.CatMapper;
import mybatis.model.CatFacts.All;
import mybatis.model.CatFacts.CatRoot;
import mybatis.model.CatFacts.OnlyFacts;
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


    //CADEN: nice job breaking up the methods to specific tasks such as mapping root object, mapping OnlyFacts object,
    //      and then dealing with the DB.
    public CatRoot getFacts() {
        String url = "https://cat-fact.herokuapp.com/facts/";

        CatRoot all = restTemplate.getForObject(url, CatRoot.class);

        return all;
    }

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

    //CADEN: i believe that this returns an empty object or nothing at all to the user if the object was successfully
    //      deleted. changing the delete statement in the mapper would allow that record to still be looked up
    //      by the .getCFById() method and return a record for the user to see.
    public OnlyFacts deleteCF(OnlyFacts fact) {
        catMapper.deleteCF(fact);
        return catMapper.getCFById(fact.getId());
    }
}
