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
import java.util.stream.Collectors;

public class _10GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> students = new ArrayList<>();

        String input = "";

        while (!"END".equals(input = reader.readLine())) {

            String[] inputArgs = input.split("\\s+");

            String name = inputArgs[0] + " " + inputArgs[1];
            int group = Integer.parseInt(inputArgs[2]);

            Person person = new Person(name, group);

            students.add(person);
        }

        students
                .stream()
                .collect(Collectors.groupingBy(Person::getGroup))
                .forEach((g, p) -> {
                    System.out.printf("%d - %s%n", g, String
                            .join(", ", p
                                    .stream()
                                    .map(Person::getName)
                                    .collect(Collectors.toList())));
                });
    }

    private static class Person {
        String name;
        int group;

        private Person(String name, int group) {
            this.name = name;
            this.group = group;
        }

        private String getName() {
            return name;
        }

        private int getGroup() {
            return group;
        }
    }
}