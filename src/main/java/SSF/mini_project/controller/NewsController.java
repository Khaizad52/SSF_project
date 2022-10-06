package SSF.mini_project.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import SSF.mini_project.models.News;
import SSF.mini_project.models.User;
import SSF.mini_project.service.NewsService;

@Controller
//@RequestMapping(path="/")
public class NewsController {
    private static final Logger logger = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private NewsService newsService;

    @GetMapping("/")
    public String loginPage(Model model){
        return "login";
    }
    
    /*
    @PostMapping
    public String newsPage(Model model){
        News news = new News();

        User user = new User();

        model.addAttribute("name", user);
        
        logger.info("login successful");

        return "search";
        
    }
    */
    

    /*
    @PostMapping
    public String indexPage(@ModelAttribute String name, Model model){

        logger.info(name);
        return "search";
    }
    */


    
}
