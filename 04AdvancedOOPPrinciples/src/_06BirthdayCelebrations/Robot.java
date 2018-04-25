package _06BirthdayCelebrations;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.3.2018 г.
 * Time: 18:47 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Robot implements Inhabitants{

    private String name;
    private String id;

    public Robot(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }
}