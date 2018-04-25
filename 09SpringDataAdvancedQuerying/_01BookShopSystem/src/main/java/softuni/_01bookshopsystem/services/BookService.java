package softuni._01bookshopsystem.services;


import softuni._01bookshopsystem.Dto.BookDto;
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
 * Time: 13:33 ч.
 */
public interface BookService {

    void saveBookIntoDB(Book book);

Set<Book> getAllByAgeRestriction(AgeRestriction ageRestriction);

Set<Book> getAllByEditionTypeAndCopies(EditionType editionType, Long copies);

Set<Book> getAllByPriceNotBetween(BigDecimal belowPrice, BigDecimal abovePrice);

Set<Book> getAllByReleasedNotFromYear(Date beforeDate, Date afterDate);

Set<Book> getAllByReleasedBefore(Date date);

Set<Book> getAllByTitleContaining(String pattern);

Set<Book> getAllByAuthorIn(Set<Author> authors);

Set<Book> getAllByTitleSize(int symbolCount);

BookDto getByTitle(String title);

Set<Book> getByReleasedDateAfter(Date releasedDate);

Set<Book> getByCopiesBelow(Long copiesCount);

void deleteBookFromDB(Book book);


}