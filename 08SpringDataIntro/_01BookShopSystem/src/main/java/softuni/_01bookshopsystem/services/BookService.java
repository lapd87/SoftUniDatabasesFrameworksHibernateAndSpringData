package softuni._01bookshopsystem.services;


import softuni._01bookshopsystem.models.entity.Author;
import softuni._01bookshopsystem.models.entity.Book;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 31.3.2018 г.
 * Time: 13:33 ч.
 */
public interface BookService {

    void saveBookIntoDB(Book book);

    List<Book> getAllBooksAfterReleaseDate(Date releaseDate);

    List<Book> getAllBooksBeforeDate(Date releaseDate);

    List<Book> getAllBooksFromAuthorOrderedByDateDescTitleAsc(Author author);


}