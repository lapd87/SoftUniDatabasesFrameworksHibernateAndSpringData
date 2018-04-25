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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class _003FirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String names = reader.readLine();
        List<Character> letter = Arrays
                .stream(reader
                        .readLine()
                        .split("\\s+"))
                .map(s -> s.toUpperCase().charAt(0))
                .collect(Collectors.toList());

        Optional<String> result = Arrays
                .stream(names
                        .split("\\s+"))
                .filter(n -> letter.contains(n.toUpperCase().charAt(0)))
                .sorted()
                .findFirst();

        if (result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("No match");
        }
    }
}