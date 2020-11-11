package pl.deska.springbootlatestnewsapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.deska.springbootlatestnewsapi.model.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {



}
