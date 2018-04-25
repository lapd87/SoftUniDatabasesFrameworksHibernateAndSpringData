/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.3.2018 г.
 * Time: 18:05 ч.
 */

import java.util.Scanner;

public class _02BooleanVariable {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        boolean input = Boolean.valueOf(console.nextLine());

        if (input) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}