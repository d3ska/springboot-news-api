package pl.deska.springbootlatestnewsapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.deska.springbootlatestnewsapi.model.News;


public interface NewsRepository extends JpaRepository<News, Long> {



}
