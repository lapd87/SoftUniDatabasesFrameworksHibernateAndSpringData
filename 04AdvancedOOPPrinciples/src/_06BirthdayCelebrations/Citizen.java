package _06BirthdayCelebrations;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.3.2018 г.
 * Time: 18:44 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Citizen implements Birthdable{

    private String name;
    private int age;
    private String id;
    private String birthday;

    public Citizen(String name, String age,
                   String id, String birthday) {
        this.name = name;
        this.age = Integer.parseInt(age);
        this.id = id;
        this.birthday = birthday;
    }

    @Override
    public String getBirthday() {
        return birthday;
    }

    @Override
    public String getName() {
        return name;
    }
}