/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.3.2018 г.
 * Time: 18:05 ч.
 */

import java.util.Scanner;

public class _03ReverseCharacters {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        StringBuilder input = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            input.append(console.nextLine());
        }

        System.out.println(input.reverse());

    }
}