package softuni._01bookshopsystem.services;

import softuni._01bookshopsystem.models.entity.Author;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 31.3.2018 г.
 * Time: 13:33 ч.
 */
public interface AuthorService {

    void saveAuthorIntoDB(Author author);

    List<Author> getAllAuthors();

    List<Author> getAllAuthorsOrderedByBooksCountDesc();

    Author getAuthorByFirstAndLastName(String firstName, String lastName);

}
