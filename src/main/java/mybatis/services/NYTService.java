package mybatis.services;

import mybatis.model.nyt.NYTRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class NYTService {

    @Autowired
    RestTemplate restTemplate;

    public NYTRoot searchNYT(String query) {
        String fQuery = "https://api.nytimes.com/svc/search/v2/articlesearch.json?q="+query+"&api-key=57900f43b72740299e677a600bf4e12c";
        NYTRoot response = restTemplate.getForObject(
                fQuery, NYTRoot.class);

        return  response;
    }
}
