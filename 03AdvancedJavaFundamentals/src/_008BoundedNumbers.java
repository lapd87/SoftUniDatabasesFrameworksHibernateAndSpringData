/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.3.2018 г.
 * Time: 09:14 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _008BoundedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] bounds = Arrays
                .stream(reader
                        .readLine()
                        .split("\\s+"))
                .mapToInt(Integer::valueOf)
                .sorted()
                .toArray();

        System.out.println(String
                .join(" ", Arrays
                        .stream(reader
                                .readLine()
                                .split("\\s+"))
                        .mapToInt(Integer::valueOf)
                        .filter(n -> n >= bounds[0] && n <= bounds[1])
                        .mapToObj(String::valueOf)
                        .collect(Collectors.toList())));
    }
}