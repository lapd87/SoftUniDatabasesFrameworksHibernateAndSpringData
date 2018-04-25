package _09Students;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.3.2018 г.
 * Time: 20:34 ч.
 */

import java.util.Scanner;

public class Student {

    private static int counter = 0;

    public String name;

    public Student(String name) {
        this.name = name;
        counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getCounter() {
        return counter;
    }
}