/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.3.2018 г.
 * Time: 18:07 ч.
 */

import java.util.Arrays;
import java.util.Scanner;

public class _08MaxSequenceOfIncreasingElements {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);


        int[] input = Arrays
                .stream(console.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (input.length < 1) {
            return;
        } else if (input.length == 1) {
            System.out.println((input[0]));
            return;
        }

        int length = 1;
        int maxLength = 1;
        int endIndex = 0;
        int maxEndIndex = 0;

        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] < input[i + 1]) {
                length++;
                endIndex = i + 1;
            } else {
                if (length > maxLength) {
                    maxEndIndex = i;
                    maxLength = length;
                }

                length = 1;
            }
        }

        if (length > maxLength) {
            maxEndIndex = endIndex;
            maxLength = length;
        }

        for (int i = maxEndIndex - maxLength + 1; i <= maxEndIndex; i++) {
            System.out.printf((input[i] + " "));
        }
    }
}