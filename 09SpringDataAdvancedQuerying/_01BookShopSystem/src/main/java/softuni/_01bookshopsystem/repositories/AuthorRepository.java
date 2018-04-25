package softuni._01bookshopsystem.repositories;

import javafx.util.Pair;
import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni._01bookshopsystem.models.entity.Author;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 31.3.2018 г.
 * Time: 13:09 ч.
 */
@Repository
public interface AuthorRepository
        extends JpaRepository<Author, Long> {

    Set<Author> findAllByFirstNameEndingWith(String pattern);

    Set<Author> findAllByLastNameStartingWith(String pattern);

    @Query(value = "SELECT CONCAT(a.first_name, ' ', a.last_name), " +
            "SUM(b.copies) AS copies " +
            "FROM Authors AS a " +
            "JOIN Books AS b ON b.author_id = a.id " +
            "GROUP BY a.id " +
            "ORDER BY copies DESC", nativeQuery = true)
    List<Object[]> findAllByAuthorCopiesCount();

    @Modifying
    @Query(value = "CREATE PROCEDURE `usp_get_books_count_by_author_name` ( " +
            "IN `f_name` VARCHAR(50), " +
            "`l_name` VARCHAR(50)) " +
            "   SELECT COUNT(`b`.`id`) AS `books_count` " +
            "   FROM `authors` AS `a` " +
            "   JOIN `books` AS `b`\n" +
            "   ON `a`.`id` = `b`.`author_id` " +
            "   WHERE `a`.`first_name` = `f_name` " +
            "   AND `a`.`last_name` = `l_name`; ", nativeQuery = true)
    void createUspFindByAuthorBooksCount();

    @Query(value = "CALL `usp_get_books_count_by_author_name`(:f_Name, :l_Name);",
            nativeQuery = true)
    Long callUspFindByAuthorBooksCount(@Param("f_Name") String firstName,
                                       @Param("l_Name") String lastName);
}
