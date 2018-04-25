package _07Mankind;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.3.2018 г.
 * Time: 19:09 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputStudent = reader.readLine().split("\\s+");
        String[] inputWorker = reader.readLine().split("\\s+");

        try {
            System.out.println((new Student(inputStudent[0],
                    inputStudent[1], inputStudent[2])).toString());

            System.out.println();

            System.out.println((new Worker(inputWorker[0],
                    inputWorker[1],
                    Double.parseDouble(inputWorker[2]),
                    Double.parseDouble(inputWorker[3]))).toString());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}