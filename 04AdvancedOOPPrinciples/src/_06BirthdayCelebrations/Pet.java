package _06BirthdayCelebrations;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.3.2018 г.
 * Time: 18:46 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pet implements Birthdable {

    private String name;
    private String birthday;

    public Pet(String name, String birthday) {
        this.name = name;
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