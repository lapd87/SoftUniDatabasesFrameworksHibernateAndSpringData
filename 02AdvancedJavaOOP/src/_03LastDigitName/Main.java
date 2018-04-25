package _03LastDigitName;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.3.2018 г.
 * Time: 11:57 ч.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        Number num = new Number(input);

        String result = num.lastDigitName();

        System.out.println(result);
    }
}