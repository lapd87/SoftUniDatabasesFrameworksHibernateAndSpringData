/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.3.2018 г.
 * Time: 18:04 ч.
 */

import java.util.Scanner;

public class _01VariableInHexadecimalFormat {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println(Integer
                .parseInt(console.nextLine(), 16));

    }
}