/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.3.2018 г.
 * Time: 11:21 ч.
 */

import java.util.Random;
import java.util.Scanner;

public class _02AdvertisementMessage {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        String[] phrases = {"Excellent product.",
                "Such a great product.",
                "I always use that product.",
                "Best product of its category.",
                "Exceptional product.",
                "I can’t live without this product."};

        String[] events = {"Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.",
                "I feel great!"};

        String[] authors = {"Diana",
                "Petya",
                "Stella",
                "Elena",
                "Katya",
                "Iva",
                "Annie",
                "Eva"};

        String[] cities = {"Burgas",
                "Sofia",
                "Plovdiv",
                "Varna",
                "Ruse"};

        Random rnd = new Random();

        for (int i = 0; i < n; i++) {
            int randomPhraseNum = rnd.nextInt(phrases.length);
            int randomEventsNum = rnd.nextInt(events.length);
            int randomCitiesNum = rnd.nextInt(cities.length);
            int randomAuthorNum = rnd.nextInt(authors.length);

            System.out.println(phrases[randomPhraseNum] +
                    " " + events[randomEventsNum] +
                    " " + authors[randomAuthorNum] +
                    " - " + cities[randomCitiesNum]);
        }
    }
}
