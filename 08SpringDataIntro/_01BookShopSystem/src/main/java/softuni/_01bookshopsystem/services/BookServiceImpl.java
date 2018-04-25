package softuni._01bookshopsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni._01bookshopsystem.models.entity.Author;
import softuni._01bookshopsystem.models.entity.Book;
import softuni._01bookshopsystem.repositories.BookRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 31.3.2018 г.
 * Time: 13:35 ч.
 */

@Service
@Transactional
public class BookServiceImpl
        implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public void saveBookIntoDB(Book book) {
        this.bookRepository.saveAndFlush(book);
    }

    @Override
    public List<Book> getAllBooksAfterReleaseDate(Date releaseDate) {
        return this.bookRepository.findAllByReleaseDateAfter(releaseDate);
    }

    @Override
    public List<Book> getAllBooksBeforeDate(Date releaseDate) {
        return this.bookRepository.findAllByReleaseDateAfter(releaseDate);
    }

    @Override
    public List<Book> getAllBooksFromAuthorOrderedByDateDescTitleAsc(Author author) {
        return this.bookRepository.findByAuthorOrderByReleaseDateDescTitleAsc(author);
    }
}