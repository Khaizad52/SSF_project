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

        JsonNumber jId = jo.getJsonNumber("id");
        n.id = String.valueOf(jId.intValue());
        JsonString jAuthor = jo.getJsonString("author");
        n.author = jAuthor.toString();
        JsonString jImage = jo.getJsonString("image");
        n.image = jImage.toString();
        JsonString jLanguage = jo.getJsonString("language");
        n.language = jLanguage.toString();
        JsonString jPublishDate = jo.getJsonString("publish_date");
        n.publishDate = jPublishDate.toString();
        JsonString jSourceCountry = jo.getJsonString("source_country");
        n.sourceCountry = jSourceCountry.toString();
        JsonString jText = jo.getJsonString("text");
        n.text = jText.toString();
        JsonString jTitle = jo.getJsonString("title");
        n.title = jTitle.toString();
        JsonString jUrl = jo.getJsonString("url");
        n.url = jUrl.toString();

        logger.info(String.valueOf(n.id));

        return n;
    }

}
