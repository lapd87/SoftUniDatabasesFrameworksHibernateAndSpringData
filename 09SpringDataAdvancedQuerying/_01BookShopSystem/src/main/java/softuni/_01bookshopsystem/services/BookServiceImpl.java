package softuni._01bookshopsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni._01bookshopsystem.Dto.BookDto;
import softuni._01bookshopsystem.enums.AgeRestriction;
import softuni._01bookshopsystem.enums.EditionType;
import softuni._01bookshopsystem.models.entity.Author;
import softuni._01bookshopsystem.models.entity.Book;
import softuni._01bookshopsystem.repositories.BookRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Set;

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
    public Set<Book> getAllByAgeRestriction(AgeRestriction ageRestriction) {
        return this.bookRepository
                .findAllByAgeRestriction(ageRestriction);
    }

    @Override
    public Set<Book> getAllByEditionTypeAndCopies(EditionType editionType, Long copies) {
        return this.bookRepository
                .findAllByEditionTypeAndCopiesLessThan(editionType, copies);
    }

    @Override
    public Set<Book> getAllByPriceNotBetween(BigDecimal belowPrice, BigDecimal abovePrice) {
        return this.bookRepository
                .findAllByPriceBeforeOrPriceAfter(belowPrice, abovePrice);
    }

    @Override
    public Set<Book> getAllByReleasedNotFromYear(Date beforeDate, Date afterDate) {
        return this.bookRepository
                .findAllByReleaseDateBeforeOrReleaseDateAfter(beforeDate, afterDate);
    }

    @Override
    public Set<Book> getAllByReleasedBefore(Date date) {
        return this.bookRepository
                .findAllByReleaseDateBefore(date);
    }

    @Override
    public Set<Book> getAllByTitleContaining(String pattern) {
        return this.bookRepository
                .findAllByTitleContaining(pattern);
    }

    @Override
    public Set<Book> getAllByAuthorIn(Set<Author> authors) {
        return this.bookRepository
                .findAllByAuthorIn(authors);
    }

    @Override
    public Set<Book> getAllByTitleSize(int symbolCount) {
        return this.bookRepository
                .findAllByTitleSize(symbolCount);
    }

    @Override
    public BookDto getByTitle(String title) {
        Book book = this.bookRepository
                .findByTitleIs(title);

        return new BookDto(book.getTitle(),
                book.getEditionType(),
                book.getPrice(),
                book.getAgeRestriction());
    }

    @Override
    public Set<Book> getByReleasedDateAfter(Date releasedDate) {
        return this.bookRepository
                .findByReleaseDateAfter(releasedDate);
    }

    @Override
    public Set<Book> getByCopiesBelow(Long copiesCount) {
        return this.bookRepository
                .findByCopiesLessThan(copiesCount);
    }

    @Override
    public void deleteBookFromDB(Book book) {
        this.bookRepository
                .delete(book);
    }


}