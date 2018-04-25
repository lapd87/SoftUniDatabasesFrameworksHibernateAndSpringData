package softuni._01bookshopsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni._01bookshopsystem.models.entity.Author;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 31.3.2018 г.
 * Time: 13:09 ч.
 */
@Repository
public interface AuthorRepository
        extends JpaRepository<Author, Long> {

    @Query(value = "SELECT \n" +
            "    a.*\n" +
            "FROM\n" +
            "    authors AS a\n" +
            "        JOIN\n" +
            "    books AS b ON a.id = b.author_id\n" +
            "GROUP BY a.id\n" +
            "ORDER BY COUNT(b.id) DESC", nativeQuery = true)
    List<Author> findAllByOrderByBooksCountDesc();

    Author findByFirstNameAndLastName(String firstName, String lastName);

}
