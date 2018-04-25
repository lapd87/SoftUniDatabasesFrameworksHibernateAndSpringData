package softuni._01bookshopsystem.services;

import softuni._01bookshopsystem.models.entity.Author;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 31.3.2018 г.
 * Time: 13:33 ч.
 */
public interface AuthorService {

    void saveAuthorIntoDB(Author author);

    List<Author> getAllAuthors();

    Set<Author> getAllByFirstNameEnding(String pattern);

    Set<Author> getAllByLastNameStarting(String pattern);

    List<Object[]> getAllCopiesCount();

    void createUspFindByAuthorBooksCount();

    Long callUspFindByAuthorBooksCount(String firsName, String lastName);
}
