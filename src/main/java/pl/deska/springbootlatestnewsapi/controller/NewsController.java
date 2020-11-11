package pl.deska.springbootlatestnewsapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.deska.springbootlatestnewsapi.model.News;
import pl.deska.springbootlatestnewsapi.service.NewsService;

import java.util.List;
import java.util.Optional;

@Controller
public class NewsController {

    private NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public String showNews(Model model){
        List<News> newsList = newsService.findAll();
        model.addAttribute("newsList", newsList);
        return "home";
    }


    @GetMapping("/update/{id}")
    public String showUpdateNewsForm(@PathVariable Long id, Model model){
        Optional<News> optionalNews = newsService.findById(id);
            News news = optionalNews.get();
            model.addAttribute("news",news);
            return "update-news";
    }

    @PostMapping("/updateNews")
    public String updateNews(@ModelAttribute News newsToUpdate){
        newsService.save(newsToUpdate);
        return "redirect:/";
    }
}
