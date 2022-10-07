package SSF.mini_project.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import SSF.mini_project.models.News;
import SSF.mini_project.models.User;
import SSF.mini_project.service.NewsService;

@Controller

public class NewsController {
    private static final Logger logger = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private NewsService newsService;

    @GetMapping("/")
    public String loginPage(Model model){
        return "login";
    }    
}
