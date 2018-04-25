package _10BeerCounter;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.3.2018 г.
 * Time: 20:39 ч.
 */

import java.util.Scanner;

public class BeerCounter {

    private static int beerInStock = 0;
    private static int beerDrankCount = 0;

    public static void buyBeer(int bottlesCount) {
        beerInStock += bottlesCount;
    }

    public static void drinkBeer(int bottlesCount) {
        beerDrankCount += bottlesCount;
        beerInStock -= bottlesCount;
    }

    public static int getBeerInStock() {
        return beerInStock;
    }

    public static int getBeerDrankCount() {
        return beerDrankCount;
    }
}
