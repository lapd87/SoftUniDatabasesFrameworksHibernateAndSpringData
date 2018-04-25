/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.3.2018 г.
 * Time: 18:06 ч.
 */

import java.util.Scanner;

public class _05IntegerToHexAndBinary {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int input = console.nextInt();

        System.out.println(Integer.toString(input, 16).toUpperCase());
        System.out.println(Integer.toString(input, 2));
    }
}