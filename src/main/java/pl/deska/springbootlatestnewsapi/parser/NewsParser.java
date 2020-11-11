package pl.deska.springbootlatestnewsapi.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.deska.springbootlatestnewsapi.model.News;
import pl.deska.springbootlatestnewsapi.model.pojo.Article;
import pl.deska.springbootlatestnewsapi.model.pojo.NewsData;
import pl.deska.springbootlatestnewsapi.reader.DataReader;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsParser implements DataParser {

    private DataReader dataReader;

    @Autowired
    public NewsParser(DataReader dataReader) {
        this.dataReader = dataReader;
    }

    @Override
    public List<News> getListOfNews() {
        NewsData data = (NewsData) dataReader.getData().getBody();
        List<News> newsList = new ArrayList<>();

        data.getArticles().stream().forEach(article -> {
            News news = new News(article.getTitle(), article.getUrl(),
                    article.getUrlToImage(), article.getPublishedAt().substring(0,10));

            newsList.add(news);
        });

        return newsList;

    }
}
