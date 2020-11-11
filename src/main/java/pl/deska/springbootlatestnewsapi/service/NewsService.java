package pl.deska.springbootlatestnewsapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.deska.springbootlatestnewsapi.model.News;
import pl.deska.springbootlatestnewsapi.parser.DataParser;
import pl.deska.springbootlatestnewsapi.repo.NewsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    private NewsRepository newsRepo;
    private DataParser dataParser;

    @Autowired
    public NewsService(NewsRepository newsRepo, DataParser dataParser) {
        this.newsRepo = newsRepo;
        this.dataParser = dataParser;
    }


    public News save(News news){
        return newsRepo.save(news);
    }

    public List<News> findAll(){
        return  newsRepo.findAll();
    }


    public Optional<News> findById(Long id){
        return newsRepo.findById(id);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void fillDb(){
        newsRepo.saveAll(dataParser.getListOfNews());
    }




}
