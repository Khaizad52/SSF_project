package SSF.mini_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import SSF.mini_project.service.NewsService;

@Controller
@RequestMapping(path="/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    
    @GetMapping
    
}
