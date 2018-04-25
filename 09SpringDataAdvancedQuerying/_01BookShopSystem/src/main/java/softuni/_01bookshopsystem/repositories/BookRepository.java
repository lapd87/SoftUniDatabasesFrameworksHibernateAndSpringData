package softuni._01bookshopsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni._01bookshopsystem.enums.AgeRestriction;
import softuni._01bookshopsystem.enums.EditionType;
import softuni._01bookshopsystem.models.entity.Author;
import softuni._01bookshopsystem.models.entity.Book;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 31.3.2018 г.
 * Time: 13:10 ч.
 */
@Repository
public interface BookRepository
        extends JpaRepository<Book, Long> {

    Set<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    Set<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Long copies);

    Set<Book> findAllByPriceBeforeOrPriceAfter(BigDecimal belowPrice, BigDecimal abovePrice);

    Set<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(Date beforeDate, Date afterDate);

    Set<Book> findAllByReleaseDateBefore(Date date);

    Set<Book> findAllByTitleContaining(String pattern);

    Set<Book> findAllByAuthorIn(Set<Author> authors);

    @Query(value = "select * from books as b where  length (b.title)>:symbolCount", nativeQuery = true)
    Set<Book> findAllByTitleSize(@Param("symbolCount") int symbolCount);

    Book findByTitleIs(String title);

    Set<Book> findByReleaseDateAfter(Date releasedDate);

    Set<Book> findByCopiesLessThan(Long copiesCount);


}