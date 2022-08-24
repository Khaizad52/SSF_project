package SSF.mini_project.models;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Response {

    private static final Logger logger = LoggerFactory.getLogger(Response.class);

    private int available;
    private static List<News> news;

    private Query query;

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public static List<News> getNews() {
        return news;
    }

    public static void setNews(List<News> news) {
        Response.news = news;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }


    public static Response createJson(String json) throws IOException{

        Response r = new Response();

        try(InputStream is = new ByteArrayInputStream(json.getBytes())){
            JsonReader jr = Json.createReader(is);
            JsonObject jo = jr.readObject();
            JsonArray ja = jo.getJsonArray("News");
            

            if(ja != null){
                List<News> newsArray = new ArrayList<>();
                for(Object jv: ja){
                    JsonObject joValue = (JsonObject) jv;
                    newsArray.add(News.createJson(joValue));
                }
                Response.news = newsArray;

            }
            logger.info("Response read");
            
        }
        return r;
    }
    
}
