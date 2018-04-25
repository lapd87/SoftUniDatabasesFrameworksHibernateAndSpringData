package _07AverageGrades;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.3.2018 г.
 * Time: 20:22 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");

            String currentName = input[0];
            List<Double> currentGrades = new ArrayList<>();

            for (int j = 1; j < input.length; j++) {
                currentGrades.add(Double.parseDouble(input[j]));
            }

            Student currentStudent = new Student(currentName, currentGrades);

            if (currentStudent.Average() >= 5) {
                students.add(currentStudent);
            }
        }

        Comparator<Student> studentComparator = (first, second) ->
                first.Name.compareTo(second.Name);

        studentComparator = studentComparator.thenComparing((first, second) ->
                second.Average().compareTo(first.Average()));

        students.sort(studentComparator);

        for (Student st : students) {
            System.out.println(st.Name + " -> " +
                    String.format("%.2f",st.Average()));
        }
    }

    private static class Student {
        private String Name;
        private List<Double> Grade;

        private Double Average() {
            return Grade.stream()
                    .mapToDouble(Double::doubleValue)
                    .sum() / Grade.size();
        }

        ;

        public Double gerAverage() {
            return Average();
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public List<Double> getGrade() {
            return Grade;
        }

        public void setGrade(List<Double> grade) {
            Grade = grade;
        }

        public Student(String name, List<Double> grade) {
            Name = name;
            Grade = grade;
        }
    }
}