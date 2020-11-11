package pl.deska.springbootlatestnewsapi.reader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.deska.springbootlatestnewsapi.model.pojo.NewsData;

@RestController
public class NewsReader implements DataReader {

    private static final String NEWS_API = "https://newsapi.org/v2/top-headlines?country=us&apiKey=d49459d26655446ba0ea6c4d3c287e40";


    @Override
    public ResponseEntity getData(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<NewsData> exchange = restTemplate.exchange(NEWS_API, HttpMethod.GET, HttpEntity.EMPTY, NewsData.class);
        System.out.println(exchange.toString());
        return exchange;
    }



}
