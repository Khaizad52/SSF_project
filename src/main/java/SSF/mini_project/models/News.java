package SSF.mini_project.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.json.JsonNumber;
import jakarta.json.JsonObject;
import jakarta.json.JsonString;

public class News {
    private static final Logger logger = LoggerFactory.getLogger(News.class);
    

    private String id;
    private String author;
    private String image;
    private String language;
    private String publishDate;
    private String sourceCountry;
    private String text;
    private String title;
    private String url;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public String getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
    public String getSourceCountry() {
        return sourceCountry;
    }
    public void setSourceCountry(String sourceCountry) {
        this.sourceCountry = sourceCountry;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }


    public static News createJson(JsonObject jo){
        News n = new News();
        //logger.info("create Json");

        JsonNumber jId = jo.getJsonNumber("id");
        n.id = String.valueOf(jId.intValue());

        JsonString jAuthor = jo.getJsonString("author");
        n.author = jAuthor.toString().replace("\"", "");

        JsonString jImage = jo.getJsonString("image");
        n.image = jImage.toString().replace("\"", "");

        JsonString jLanguage = jo.getJsonString("language");
        n.language = jLanguage.toString().replace("\"", "");

        JsonString jPublishDate = jo.getJsonString("publish_date");
        n.publishDate = jPublishDate.toString().replace("\"", "");

        JsonString jSourceCountry = jo.getJsonString("source_country");
        n.sourceCountry = jSourceCountry.toString().replace("\"", "");

        JsonString jText = jo.getJsonString("text");
        n.text = jText.toString().replace("\"", "");

        JsonString jTitle = jo.getJsonString("title");
        n.title = jTitle.toString().replace("\"", "");

        JsonString jUrl = jo.getJsonString("url");
        n.url = jUrl.toString().replace("\"", "");

        logger.info(String.valueOf(n.id));

        return n;
    }
    public static News create(JsonObject jo) {
        News news = new News();
        news.setId(jo.getString("id"));
        news.setAuthor(jo.getString("author"));
        news.setImage(jo.getString("image"));
        news.setLanguage(jo.getString("language"));
        news.setPublishDate(jo.getString("publish_date"));
        news.setSourceCountry(jo.getString("source_country"));
        news.setText(jo.getString("text"));
        news.setTitle(jo.getString("title"));
        news.setUrl(jo.getString("url"));

        return news;
    }

}
