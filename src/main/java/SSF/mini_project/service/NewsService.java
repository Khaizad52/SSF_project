package SSF.mini_project.service;

import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import SSF.mini_project.models.News;
import SSF.mini_project.models.Query;
import SSF.mini_project.models.Response;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@Service
public class NewsService {
    private static final Logger logger = LoggerFactory.getLogger(NewsService.class);
    
    private static String URL = "https://api.apilayer.com/world_news/search-news";

    public List<News> searchNews(String search){
        String apikey = System.getenv("SSF_Project_API");

        String queryURL = UriComponentsBuilder.fromUriString(URL)
        .queryParam("source-countries", search)
        .toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", apikey);
        HttpEntity request = new HttpEntity<>(headers);

        logger.info("APIKEY > "+apikey);

        RestTemplate restTemp = new RestTemplate();
        ResponseEntity<String> resp = restTemp.exchange(queryURL, HttpMethod.GET, request, String.class);
        
        String payload = resp.getBody();
        Reader strReader = new StringReader(payload);       
        JsonReader jsonReader = Json.createReader(strReader);
        JsonObject jsonObject = jsonReader.readObject();
        JsonArray data = jsonObject.getJsonArray("news");

        
        List<News> list = new LinkedList<>();

        for(int i = 0; i<data.size(); i++){
            
            JsonObject jo = data.getJsonObject(i);
            list.add(News.createJson(jo));
        }

        return list;
}
}
