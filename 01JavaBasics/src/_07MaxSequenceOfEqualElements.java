/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.3.2018 г.
 * Time: 18:07 ч.
 */

import java.util.Arrays;
import java.util.Scanner;

public class _07MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] inputArr = console.nextLine().split(" ");
        int[] intArray = Arrays.stream(inputArr).mapToInt(Integer::parseInt).toArray();

        int maxStart = 0;
        int maxLen = 1;
        int currentStart = 0;
        int currentLen = 1;

        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] == intArray[currentStart]) {
                currentLen++;
                if (currentLen > maxLen) {
                    maxLen = currentLen;
                    maxStart = currentStart;
                }
            } else {
                currentLen = 1;
                currentStart = i;
            }
        }

        for (int i = maxStart; i < maxStart + maxLen; i++)
            System.out.print(intArray[i] + " ");
    }
}