package softuni._01bookshopsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni._01bookshopsystem.models.entity.Author;
import softuni._01bookshopsystem.repositories.AuthorRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 31.3.2018 г.
 * Time: 13:34 ч.
 */

@Service
@Transactional
public class AuthorServiceImpl
        implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public void saveAuthorIntoDB(Author author) {
        this.authorRepository.saveAndFlush(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return this.authorRepository.findAll();
    }

    @Override
    public Set<Author> getAllByFirstNameEnding(String pattern) {
        return this.authorRepository
                .findAllByFirstNameEndingWith(pattern);
    }

    @Override
    public Set<Author> getAllByLastNameStarting(String pattern) {
        return this.authorRepository
                .findAllByLastNameStartingWith(pattern);
    }

    @Override
    public List<Object[]> getAllCopiesCount() {
        return this.authorRepository
                .findAllByAuthorCopiesCount();
    }

    @Override
    public void createUspFindByAuthorBooksCount() {
        this.authorRepository
                .createUspFindByAuthorBooksCount();
    }

    @Override
    public Long callUspFindByAuthorBooksCount(String firsName, String lastName) {

        return this.authorRepository
                .callUspFindByAuthorBooksCount(firsName, lastName);
    }
}