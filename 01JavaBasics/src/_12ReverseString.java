/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.3.2018 г.
 * Time: 18:08 ч.
 */

import java.util.Scanner;

public class _12ReverseString {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        StringBuilder input = new StringBuilder(console.nextLine());

        System.out.println(input.reverse());
    }
}