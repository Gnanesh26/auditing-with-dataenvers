package springdata.envers.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;
import springdata.envers.Entity.Book;
@Repository

public interface BookRepo extends RevisionRepository<Book,Integer,Integer>, JpaRepository<Book,Integer> {
}
