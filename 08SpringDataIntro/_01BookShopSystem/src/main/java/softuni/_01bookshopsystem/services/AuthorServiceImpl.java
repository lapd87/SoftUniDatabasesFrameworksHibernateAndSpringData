package softuni._01bookshopsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni._01bookshopsystem.models.entity.Author;
import softuni._01bookshopsystem.repositories.AuthorRepository;

import javax.transaction.Transactional;
import java.util.List;

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
    public List<Author> getAllAuthorsOrderedByBooksCountDesc() {
        return this.authorRepository.findAllByOrderByBooksCountDesc();
    }

    @Override
    public Author getAuthorByFirstAndLastName(String firstName, String lastName) {
        return this.authorRepository.findByFirstNameAndLastName(firstName,lastName);
    }
}