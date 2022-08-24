package SSF.mini_project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import SSF.mini_project.models.Query;
import SSF.mini_project.models.Response;

@Service
public class NewsService {
    private static final Logger logger = LoggerFactory.getLogger(NewsService.class);
    
    private static String URL = "https://api.apilayer.com/world_news/search-news";
    
    public Response searchNews(Query q){
        logger.info("api_start");
        String apikey = System.getenv("APILAYER_WORLDNEWS_APIKEY");
        
        String queryURL = UriComponentsBuilder.fromUriString(URL)
        .queryParam("source-countries", q.getSourceCountries())
        .toUriString();

        logger.info(queryURL);

        RestTemplate temp = new RestTemplate();
        ResponseEntity<String> response = null;

        try{
            HttpHeaders hdrs = new HttpHeaders();
            hdrs.set("apikey", apikey);
            HttpEntity reqs = new HttpEntity(hdrs);
            logger.info("api reqs");
            response = temp.exchange(queryURL, HttpMethod.GET, reqs, String.class, 1);
            Response r = Response.createJson(response.getBody());
            logger.info("api good");
            return r;

        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
        
    }

}
