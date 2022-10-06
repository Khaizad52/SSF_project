package SSF.mini_project.models;

import java.util.List;

public class User {

    private String name;
    private List<News> newsList;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<News> getNewsList() {
        return newsList;
    }
    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
    
    
}
