/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.3.2018 г.
 * Time: 09:16 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _05FilterStudentsByEmailDomain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> students = new ArrayList<>();

        String input = "";

        while (!"END".equals(input = reader.readLine())) {
            students.add(input);
        }

        students
                .stream()
                .filter(s -> s.endsWith("@gmail.com"))
                .map(s -> s.split("\\s+"))
                .forEach(s -> System.out.println(s[0] + " " + s[1]));
    }
}