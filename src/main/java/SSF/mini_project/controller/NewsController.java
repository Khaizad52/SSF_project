package SSF.mini_project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import SSF.mini_project.models.News;
import SSF.mini_project.service.NewsService;

@Controller
@RequestMapping(path="/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    
    @GetMapping
    public String newsPage(Model model){
        News news = new News();
        
        
    }
}
