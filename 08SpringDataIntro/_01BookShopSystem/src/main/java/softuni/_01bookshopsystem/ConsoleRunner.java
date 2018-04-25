package softuni._01bookshopsystem;

import org.hibernate.criterion.Distinct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni._01bookshopsystem.enums.AgeRestriction;
import softuni._01bookshopsystem.enums.EditionType;
import softuni._01bookshopsystem.models.entity.Author;
import softuni._01bookshopsystem.models.entity.Book;
import softuni._01bookshopsystem.models.entity.Category;
import softuni._01bookshopsystem.services.AuthorService;
import softuni._01bookshopsystem.services.BookService;
import softuni._01bookshopsystem.services.CategoryService;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 31.3.2018 г.
 * Time: 13:29 ч.
 */
@Component
public class ConsoleRunner implements CommandLineRunner {

    private final String RECOURCE_MAIN_PATH = "src/main/resources/";

    private final String AUTHORS_FILE_PATH = RECOURCE_MAIN_PATH + "authors.txt";
    private final String BOOKS_FILE_PATH = RECOURCE_MAIN_PATH + "books.txt";
    private final String CATEGORIES_FILE_PATH = RECOURCE_MAIN_PATH + "categories.txt";

    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;

    @Autowired
    public ConsoleRunner(AuthorService authorService,
                         CategoryService categoryService,
                         BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }


    @Override
    public void run(String... strings) throws Exception {

        loadInitialAuthors();
        loadInitialCategories();
        loadInitialBooks();

        printBookTitlesReleasedAfterYear2000();

        printAuthorsPublishedBefore1990();

        printAuthorsAndBookCountOrderedDesc();

        printBookTitlesDateAndCopiesFromGeorgePowellOrderedByDateDescTitleAsc();

    }

    private void printBookTitlesDateAndCopiesFromGeorgePowellOrderedByDateDescTitleAsc() {

        String firstName = "George";
        String lastName = "Powell";

        Author georgePowell = this.authorService
                .getAuthorByFirstAndLastName(firstName, lastName);

        List<Book> booksByGeorgePowell = this.bookService
                .getAllBooksFromAuthorOrderedByDateDescTitleAsc(georgePowell);

        System.out.printf("%nBooks by George Powell:%n%n");

        booksByGeorgePowell
                .stream()
                .forEach(b -> System.out.println(b.getTitle()
                        + " " + b.getReleaseDate()
                        + " " + b.getCopies()));
    }

    private void printAuthorsAndBookCountOrderedDesc() {

        List<Author> orderedAuthors = this.authorService
                .getAllAuthorsOrderedByBooksCountDesc();

        System.out.printf("%nAuthors and book count ordered descending:%n%n");

        orderedAuthors
                .stream()
                .forEach(a -> System.out.println(a.getFirstName()
                        + " " + a.getLastName()
                        + " " + a.getBooks().size()));
    }

    private void printAuthorsPublishedBefore1990() {

        String year = "01/01/1990";

        Date releaseDate = parseReleaseDate(year);

        List<Book> booksPublishedBefore1990 = this.bookService
                .getAllBooksBeforeDate(releaseDate);

        LinkedHashSet<Author> authorsPublishedBefore1990 = new LinkedHashSet<>();

        booksPublishedBefore1990
                .stream()
                .forEach(b -> authorsPublishedBefore1990
                        .add(b.getAuthor()));

        System.out.printf("%nAuthors having book released before 1990:%n%n");

        authorsPublishedBefore1990
                .stream()
                .forEach(a -> System.out.println(a.getFirstName()
                        + " " + a.getLastName()));
    }

    private void printBookTitlesReleasedAfterYear2000() {

        String year = "01/01/2000";

        Date releaseDate = parseReleaseDate(year);

        List<Book> booksReleasedAfterYear2000 = this.bookService
                .getAllBooksAfterReleaseDate(releaseDate);

        System.out.printf("%nBook titles released after year 2000:%n%n");

        booksReleasedAfterYear2000
                .stream()
                .forEach(b -> System.out.println(b.getTitle()));

    }

    private Date parseReleaseDate(String date) {

        SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
        Date releaseDate = null;

        try {
            releaseDate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return releaseDate;
    }


    private void loadInitialBooks() throws IOException {

        List<String> initialBooks = Files
                .readAllLines(Paths
                        .get(BOOKS_FILE_PATH));

        initialBooks.removeIf(String::isEmpty);

        List<Author> allAuthors = this.authorService
                .getAllAuthors();
        List<Category> allCategories = this.categoryService
                .getAllCategories();

        initialBooks
                .stream()
                .forEach(b -> {
                    String[] bookArgs = b
                            .trim()
                            .split("\\s+");

                    Random random = new Random();

                    int authorIndex = random.nextInt(allAuthors.size());
                    Author author = allAuthors.get(authorIndex);

                    int categoryIndex = random.nextInt(allCategories.size());
                    Category category = allCategories.get(categoryIndex);

                    EditionType editionType = EditionType.values()[Integer.parseInt(bookArgs[0])];

                    SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
                    Date releaseDate = null;
                    try {
                        releaseDate = formatter.parse(bookArgs[1]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    Long copies = Long.parseLong(bookArgs[2]);
                    BigDecimal price = new BigDecimal(bookArgs[3]);
                    AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(bookArgs[4])];

                    StringBuilder titleBuilder = new StringBuilder();
                    for (int i = 5; i < bookArgs.length; i++) {
                        titleBuilder.append(bookArgs[i]).append(" ");
                    }
                    titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
                    String title = titleBuilder.toString();

                    Book currentBook = new Book();

                    currentBook.setAuthor(author);
                    currentBook.getCategories().add(category);
                    currentBook.setEditionType(editionType);
                    currentBook.setReleaseDate(releaseDate);
                    currentBook.setCopies(copies);
                    currentBook.setPrice(price);
                    currentBook.setAgeRestriction(ageRestriction);
                    currentBook.setTitle(title);

                    this.bookService.saveBookIntoDB(currentBook);
                });
    }


    private void loadInitialCategories() throws IOException {
        List<String> initialCategories = Files
                .readAllLines(Paths
                        .get(CATEGORIES_FILE_PATH));

        initialCategories.removeIf(String::isEmpty);

        initialCategories
                .stream()
                .forEach(c -> {
                    String categoryName = c.trim();

                    Category currentCategory = new Category();

                    currentCategory
                            .setName(categoryName);

                    this.categoryService.saveCategoryIntoDB(currentCategory);
                });
    }


    private void loadInitialAuthors() throws IOException {

        List<String> initialAuthors = Files
                .readAllLines(Paths
                        .get(AUTHORS_FILE_PATH));

        initialAuthors.removeIf(String::isEmpty);

        initialAuthors
                .stream()
                .forEach(a -> {
                    String[] authorArgs = a
                            .trim()
                            .split("\\s+");

                    Author currentAuthor = new Author();

                    if (authorArgs.length < 2) {
                        currentAuthor
                                .setLastName(authorArgs[0]);
                    } else {
                        currentAuthor
                                .setFirstName(authorArgs[0]);
                        currentAuthor
                                .setLastName(authorArgs[1]);
                    }

                    this.authorService.saveAuthorIntoDB(currentAuthor);
                });
    }
}