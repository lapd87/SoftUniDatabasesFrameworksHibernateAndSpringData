/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.3.2018 г.
 * Time: 18:06 ч.
 */

import java.util.Scanner;

public class _06CompareCharArrays {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input1 = console.nextLine().replaceAll("\\s+","");
        String input2 = console.nextLine().replaceAll("\\s+","");

        if (input1.compareTo(input2) < 0) {
            System.out.println(input1);
            System.out.println(input2);
        } else {
            System.out.println(input2);
            System.out.println(input1);

        }
    }

}