package _10BeerCounter;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.3.2018 г.
 * Time: 20:33 ч.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner console = new Scanner(System.in);

            String[] inputArgs = console.nextLine().split(" ");

            while (true) {
                if (inputArgs[0].equals("End")) {
                    break;
                }

                int bought = Integer.parseInt(inputArgs[0]);
                int drank = Integer.parseInt(inputArgs[1]);

                BeerCounter.buyBeer(bought);
                BeerCounter.drinkBeer(drank);

                inputArgs = console.nextLine().split(" ");
            }
        } catch (Exception e) {
        } finally {
            System.out.println(BeerCounter.getBeerInStock()
                    + " " + BeerCounter.getBeerDrankCount());
        }
    }
}