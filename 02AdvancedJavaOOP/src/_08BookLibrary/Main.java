package _08BookLibrary;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.3.2018 г.
 * Time: 20:24 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Library newLibrary = new Library("New",
                new ArrayList<>());

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");

            newLibrary.books.add(ReadBook(input));
        }

        PrintBooks(newLibrary);
    }

    private static void PrintBooks(Library newLibrary) {

        HashMap<String, Double> authorSales = new HashMap<>();

        for (Book b : newLibrary.books) {
            if (!authorSales.containsKey(b.author)) {
                authorSales.put(b.author, 0.0);
            }
            authorSales.put(b.author,
                    authorSales.get(b.author) + b.price);
        }

        Map<String, Double> sorted = sortHash(authorSales);

        for (Map.Entry<String, Double> entry : sorted.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();

            System.out.printf(key + " -> %.2f%n", value);
        }
    }

    private static Map<String, Double> sortHash(Map<String, Double> map) {
        List<Map.Entry<String, Double>> list = new ArrayList<>(map.entrySet());

        // Sort list by integer values then by string keys
        Collections.sort(list, (a, b) -> {
            int cmp1 = b.getValue().compareTo(a.getValue());
            if (cmp1 != 0)
                return cmp1;
            else
                return a.getKey().compareTo(b.getKey());
        });

        Map<String, Double> result = new LinkedHashMap<>();
        for (Map.Entry<String, Double> entry : list)
            result.put(entry.getKey(), entry.getValue());

        return result;
    }

    public static Book ReadBook(String[] input) {

        String title = input[0];
        String author = input[1];
        String publisher = input[2];
        Date releaseDate = null;
        try {
            releaseDate = new SimpleDateFormat("dd.MM.yyyy").parse(input[3]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String ISBN = input[4];
        double price = Double.parseDouble(input[5]);

        Book currentBook = new Book(title,
                author,
                publisher,
                releaseDate,
                ISBN,
                price);

        return currentBook;
    }


    public static class Library {
        public String name;
        public List<Book> books;

        public Library(String name, List<Book> books) {
            this.name = name;
            this.books = books;
        }
    }

    public static class Book {
        public String title;
        public String author;
        public String publisher;
        public Date releaseDate;
        public String ISBN;
        public Double price;

        public Book(String title,
                    String author,
                    String publisher,
                    Date releaseDate,
                    String ISBN,
                    Double price) {
            this.title = title;
            this.author = author;
            this.publisher = publisher;
            this.releaseDate = releaseDate;
            this.ISBN = ISBN;
            this.price = price;
        }
    }
}
