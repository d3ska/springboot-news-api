package pl.deska.springbootlatestnewsapi.parser;
import pl.deska.springbootlatestnewsapi.model.News;

import java.util.List;

public interface DataParser {
    List<News> getListOfNews();
}
