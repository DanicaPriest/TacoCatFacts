package mybatis.services;


import mybatis.mappers.NYTMapper;
import mybatis.model.nyt.NYTRoot;
import mybatis.model.nyt.challenges.ResponseComparison;
import mybatis.model.nyt.internal.NYTOverview;
import mybatis.model.nyt.threads.nyt.NYTOverviewThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NYTService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    NYTMapper nytMapper;

    public NYTRoot searchNYT(String query) {

        String fQuery = "https://api.nytimes.com/svc/search/v2/articlesearch.json?q=" + query + "&api-key=57900f43b72740299e677a600bf4e12c";

        NYTRoot response = restTemplate.getForObject(
                fQuery, NYTRoot.class);
        response.setCopyright("this is a copyright!");
        System.out.println("****got results");



        return response;
    }


    public ResponseComparison compareNYTResults(String t1, String t2) {
        NYTRoot responseOne = searchNYT(t1);
        NYTRoot responseTwo = searchNYT(t2);
        ResponseComparison obj = new ResponseComparison();
        obj.setSearchTermOne(t1);
        obj.setSearchTermTwo(t2);
        obj.setSearchTermOneResultCount(responseOne.getResponse().getMeta().getHits());
        obj.setSearchTermTwoResultCount(responseTwo.getResponse().getMeta().getHits());
        return obj;
    }

    public void insertNYTSummary(NYTOverview result) {
        nytMapper.insertSummary(result);
    }
}
