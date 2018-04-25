/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.3.2018 г.
 * Time: 18:06 ч.
 */

import java.util.Scanner;

public class _04VowelOrDigit {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        char input = console.next().toLowerCase().charAt(0);

        if (Character.isDigit(input)) {
            System.out.println("digit");
        } else if ("aeiou".indexOf(input) != -1) {
            System.out.println("vowel");
        } else {
            System.out.println("other");
        }
    }
}