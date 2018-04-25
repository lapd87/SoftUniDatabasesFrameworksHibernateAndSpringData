/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.3.2018 г.
 * Time: 09:17 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _07ExcellentStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> students = new ArrayList<>();

        String input = "";

        while (!"END".equals(input = reader.readLine())) {
            students.add(input);
        }

        students
                .stream()
                .map(s -> s.split("\\s+", 3))
                .filter(s -> s[2].contains("6"))
                .forEach(s -> System.out.println(s[0] + " " + s[1]));
    }
}