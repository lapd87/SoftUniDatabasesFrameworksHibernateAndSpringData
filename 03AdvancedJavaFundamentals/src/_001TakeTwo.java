/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.3.2018 г.
 * Time: 09:10 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class _001TakeTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(Arrays
                .stream(reader
                        .readLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .distinct()
                .filter(i -> i >= 10 && i <= 20)
                .limit(2)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" ")));
    }
}