package softuni._01bookshopsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni._01bookshopsystem.Dto.BookDto;
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

        Scanner scanner = new Scanner(System.in);

        loadInitialAuthors();
        loadInitialCategories();
        loadInitialBooks();

//        System.out.println("Enter age restriction:");
//        getBooksByAgeRestriction(scanner.nextLine().toUpperCase());
//
//
//        getBooksByEditionTypeAndCopies(EditionType
//                        .valueOf("GOLD"),
//                5000L);
//
//
//        getBooksByPriceNotBetween(BigDecimal.valueOf(5),
//                BigDecimal.valueOf(40));
//
//
//        System.out.println("Enter not released year:");
//        getBooksNotFromYear(scanner.nextLine());
//
//
//        System.out.println("Enter released before date:");
//        getBooksReleasedBefore(scanner.nextLine());
//
//
//        System.out.println("Enter author name pattern:");
//        getAuthorsByFirstNameEnding(scanner.nextLine());
//
//
//        System.out.println("Enter part of book title:");
//        getBooksByTitleContaining(scanner.nextLine());
//
//
//        System.out.println("Enter author name pattern:");
//        getBooksByAuthorsLastNameStarting(scanner.nextLine());
//
//
//        System.out.println("Enter title symbols:");
//        getBooksByTitleLonger(scanner.nextLine());
//
//
//        getAllCopiesByAuthor();
//
//
//        System.out.println("Enter book title:");
//        getBookByTitle(scanner.nextLine().trim());
//
//
//        System.out.println("Enter released after date " +
//                "then number of copies:");
//        updateBooksCopiesReleasedAfter(scanner.nextLine(),
//                scanner.nextLine());
//
//
//        System.out.println("Enter book copies:");
//        deleteBooksCopiesBelow(scanner.nextLine());
//
//
//        System.out.println("Enter author full name:");
//        getBooksCountByAuthorName(scanner.nextLine());
    }

    private void getBooksCountByAuthorName(String fullName) {

        String firstName = fullName.split("\\s+")[0];
        String lastName = fullName.split("\\s+")[1];

        this.authorService.createUspFindByAuthorBooksCount();

        Long booksCount = this.authorService
                .callUspFindByAuthorBooksCount(firstName, lastName);

        if (booksCount > 0) {
            System.out.printf("%s has written %d books%n",
                    fullName, booksCount);
        } else {
            System.out.printf("%s has not written any books yet%n",
                    fullName);
        }
    }

    private void deleteBooksCopiesBelow(String copiesCountString) {

        Long copiesCount = Long.parseLong(copiesCountString);

        Set<Book> booksCopiesBelow = this.bookService
                .getByCopiesBelow(copiesCount);

        booksCopiesBelow
                .forEach(this.bookService::deleteBookFromDB);

        System.out.println(booksCopiesBelow.size()
                + " books were deleted");

    }

    private void updateBooksCopiesReleasedAfter(String dateString, String copiesCountString) {

        Date releasedDate = parseReleaseDate(dateString);
        Long copiesCount = Long.parseLong(copiesCountString);


        Set<Book> booksReleasedAfter = this.bookService
                .getByReleasedDateAfter(releasedDate);

        for (Book b : booksReleasedAfter) {
            Book newBook = b;
            newBook.setCopies(b.getCopies() + copiesCount);
            this.bookService
                    .saveBookIntoDB(newBook);
        }

        System.out.println(booksReleasedAfter.size() * copiesCount);

    }

    private void getBookByTitle(String title) {

        BookDto book = this.bookService.getByTitle(title);

        Set<BookDto> books = new HashSet<>();
        books.add(book);

        printBookTitleEditionRestrictionPrice(books);

    }

    private void printBookTitleEditionRestrictionPrice(Set<BookDto> books) {

        books.forEach(b -> System.out
                .printf("%s %s %s %.2f%n",
                        b.getTitle(),
                        b.getEditionType(),
                        b.getAgeRestriction(),
                        b.getPrice()));

    }

    private void getAllCopiesByAuthor() {

        List<Object[]> authorsCopiesCount = this.authorService
                .getAllCopiesCount();

        for (Object[] object : authorsCopiesCount) {
            System.out.printf("%s - %s%n", object[0], object[1]);
        }

    }

    private void getBooksByTitleLonger(String symbolCountString) {

        int symbolCount = Integer.parseInt(symbolCountString);

        Set<Book> booksByTitleLonger = this.bookService
                .getAllByTitleSize(symbolCount);

        System.out.println(booksByTitleLonger.size());
    }

    private void getBooksByAuthorsLastNameStarting(String pattern) {

        Set<Author> authorsByNameLike = this.authorService
                .getAllByLastNameStarting(pattern);

        Set<Book> booksByAuthorNameLike = this.bookService
                .getAllByAuthorIn(authorsByNameLike);

        printBookTitle(booksByAuthorNameLike);

    }

    private void getBooksByTitleContaining(String pattern) {

        Set<Book> booksTitleHas = this.bookService
                .getAllByTitleContaining(pattern);

        printBookTitle(booksTitleHas);

    }

    private void getAuthorsByFirstNameEnding(String pattern) {

        Set<Author> authorsByNameLike = this.authorService
                .getAllByFirstNameEnding(pattern);

        printAuthorName(authorsByNameLike);


    }

    private void printAuthorName(Set<Author> authors) {

        authors.forEach(a -> System.out
                .println(a.getFirstName()
                        + " " + a.getLastName()));
    }

    private void getBooksReleasedBefore(String dateString) {

        Date releasedDate = parseReleaseDate(dateString);

        Set<Book> booksReleasedBefore = this.bookService
                .getAllByReleasedBefore(releasedDate);

        printBookTitle(booksReleasedBefore);

    }

    private void getBooksNotFromYear(String year) {

        String dateString = "01/01/" + year;
        Date beforeDate = parseReleaseDate(dateString);

        dateString = "31/12/" + year;
        Date afterDate = parseReleaseDate(dateString);

        Set<Book> booksNotFromYear = this.bookService
                .getAllByReleasedNotFromYear(beforeDate, afterDate);

        printBookTitle(booksNotFromYear);

    }

    private void getBooksByPriceNotBetween(BigDecimal belowPrice, BigDecimal abovePrice) {

        Set<Book> booksByPriceBetween = this.bookService
                .getAllByPriceNotBetween(belowPrice, abovePrice);

        printBookTitlePrice(booksByPriceBetween);
    }

    private void printBookTitlePrice(Set<Book> booksByPriceBetween) {

        booksByPriceBetween.forEach(b -> System.out
                .printf("%s - $%.2f%n",
                        b.getTitle(),
                        b.getPrice()));
    }

    private void getBooksByEditionTypeAndCopies(EditionType editionType, long copies) {

        Set<Book> booksByGoldenTypeUpto5000Copies = this.bookService
                .getAllByEditionTypeAndCopies(editionType, copies);

        printBookTitle(booksByGoldenTypeUpto5000Copies);
    }

    private void getBooksByAgeRestriction(String ageRestrictionString) {

        AgeRestriction ageRestriction = AgeRestriction
                .valueOf(ageRestrictionString);

        Set<Book> booksByAgeRestriction = this.bookService
                .getAllByAgeRestriction(ageRestriction);

        printBookTitle(booksByAgeRestriction);


    }

    private void printBookTitle(Set<Book> books) {

        books.forEach(b -> System.out.println(b.getTitle()));
    }


    private Date parseReleaseDate(String date) {

        SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
        Date releaseDate = null;

        try {
            releaseDate = formatter.parse(date);
        } catch (ParseException e) {
            formatter = new SimpleDateFormat("d-M-yyyy");
            try {
                releaseDate = formatter.parse(date);
            } catch (ParseException e1) {
                formatter = new SimpleDateFormat("dd MMM yyyy",
                        Locale.ENGLISH);
                try {
                    releaseDate = formatter.parse(date);
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }

            }
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
                    currentBook.setTitle(title.trim());

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