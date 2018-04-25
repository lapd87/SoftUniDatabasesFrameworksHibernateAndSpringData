package softuni._01bookshopsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni._01bookshopsystem.models.entity.Author;
import softuni._01bookshopsystem.models.entity.Book;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 31.3.2018 г.
 * Time: 13:10 ч.
 */
@Repository
public interface BookRepository
        extends JpaRepository<Book, Long> {


    List<Book> findAllByReleaseDateAfter(Date releaseDate);

    List<Book> findAllByReleaseDateBefore(Date releaseDate);

    List<Book> findByAuthorOrderByReleaseDateDescTitleAsc(Author author);

}