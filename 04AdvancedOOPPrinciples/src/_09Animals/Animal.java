package _09Animals;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.3.2018 г.
 * Time: 15:30 ч.
 */

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.TypeCheckError;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Animal {

    private String type;
    private String name;
    private int age;
    private String gender;

    public Animal() {
    }

    public Animal(String type, String name,
                  int age, String gender) {
        typeChecker(type);
        nameChecker(name);
        ageChecker(age);
        genderChecker(gender);
    }

    private void genderChecker(String gender) {
        if (gender.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.gender = gender;
    }

    private void ageChecker(int age) {
        if (age <= 0 || String.valueOf(age).isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    private void nameChecker(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.name = name;
    }

    private void typeChecker(String type) {
        if (type.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s %s %s",
                getType(), getName(), getAge(), getGender());
    }

    public String produceSound() {
        return "Not implemented!";
    }
}