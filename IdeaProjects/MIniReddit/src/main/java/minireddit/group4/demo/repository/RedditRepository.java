package minireddit.group4.demo.repository;

import minireddit.group4.demo.model.Reddit;
import org.springframework.data.repository.CrudRepository;

public interface RedditRepository extends CrudRepository<Reddit,Long> {
}
