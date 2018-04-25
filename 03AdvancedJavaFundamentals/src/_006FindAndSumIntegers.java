/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.3.2018 г.
 * Time: 09:12 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _006FindAndSumIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        OptionalInt result = Arrays.stream(reader.readLine().split("\\s+"))
                .filter(s -> s.matches("([+-]?[0-9]+)"))
                .mapToInt(Integer::parseInt)
                .reduce(Integer::sum);

        if (result.isPresent()) {
            System.out.println(result.getAsInt());
        } else {
            System.out.println("No match");
        }
    }
}