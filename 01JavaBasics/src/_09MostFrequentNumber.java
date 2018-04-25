/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.3.2018 г.
 * Time: 18:07 ч.
 */

import java.util.Arrays;
import java.util.Scanner;

public class _09MostFrequentNumber {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] input = Arrays.stream(console.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (input.length < 1) {
            return;
        } else if (input.length == 1) {
            System.out.println(input[0]);
            return;
        }

        int count = 0;
        int maxCount = 0;
        int index = 0;

        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
                if (input[i] == input[j]) {
                    count++;
                }
            }

            if (maxCount < count) {
                maxCount = count;
                index = i;
            }

            count = 0;
        }

        System.out.println(input[index]);
    }
}