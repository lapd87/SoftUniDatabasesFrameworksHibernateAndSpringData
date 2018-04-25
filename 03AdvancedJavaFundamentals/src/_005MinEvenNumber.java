/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.3.2018 г.
 * Time: 09:11 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;

public class _005MinEvenNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        if (input.isEmpty()){
            System.out.println("No match");
            return;
        }

        OptionalDouble result = Arrays
                .stream(input
                        .split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .filter(n -> n % 2 == 0)
                .sorted()
                .findFirst();

        if (result.isPresent()) {
            System.out.printf("%.2f%n", result.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}