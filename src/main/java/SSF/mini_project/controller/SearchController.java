package SSF.mini_project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SSF.mini_project.models.News;
import SSF.mini_project.models.User;
import SSF.mini_project.service.NewsService;

@Controller
@RequestMapping(path="/search")
public class SearchController {
    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
    
    @Autowired NewsService newsSvc;


    @GetMapping
    public String newsPage(Model model){
        News news = new News();

        User user = new User();

        model.addAttribute("name", user);
        
        logger.info("login successful");

        return "search";
        
    }





    /*
    @GetMapping
    public String searchNews(Model model, @RequestParam String search){
        logger.info("search News");

        List<News> searchNews = newsSvc.searchNews(search);
        model.addAttribute("country", searchNews);

        return "result";
    }
    */
}
