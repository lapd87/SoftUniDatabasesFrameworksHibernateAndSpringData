package _04NumberInReversedOrder;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.3.2018 г.
 * Time: 12:23 ч.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        DecimalNumber num = new DecimalNumber(input);

        String result = num.reversedNumber();

        System.out.println(result);
    }
}