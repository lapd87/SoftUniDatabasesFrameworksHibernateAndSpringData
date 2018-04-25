package _09Students;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.3.2018 г.
 * Time: 20:32 ч.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        while (!input.equals("End")){

            Student student = new Student(input);

            input = console.nextLine();
        }

        System.out.println(Student.getCounter());
    }
}