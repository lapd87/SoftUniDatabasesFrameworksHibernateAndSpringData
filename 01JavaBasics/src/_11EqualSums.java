/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.3.2018 г.
 * Time: 18:08 ч.
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class _11EqualSums {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] input = Arrays.stream(console.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = IntStream.of(input).sum();
        int leftSum = 0;

        if (input.length == 1) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (leftSum == (sum - input[i]) / 2) {
                System.out.println(i);
                return;
            }

            leftSum += input[i];
        }

        System.out.println("no");
    }
}