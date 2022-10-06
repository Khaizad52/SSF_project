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
import SSF.mini_project.service.NewsService;

@Controller
@RequestMapping(path="/result")
public class ResultController {
    
    private static final Logger logger = LoggerFactory.getLogger(ResultController.class);

    @Autowired NewsService newsSvc;

    @GetMapping
    public String resultsPage(@RequestParam(value="Country", required = true)String country, Model model){
        List<News> searchNews = newsSvc.searchNews(country);
        logger.info(String.valueOf(searchNews.size()));
        logger.info(searchNews.get(0).getTitle());

        model.addAttribute("newsList", searchNews);


        return "result";
    }
    
}
