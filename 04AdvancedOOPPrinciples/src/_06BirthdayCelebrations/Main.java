package _06BirthdayCelebrations;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.3.2018 г.
 * Time: 18:48 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Birthdable> birthdables = new ArrayList<>();

        String[] input;

        while (!"End".equals((input = reader.readLine().split("\\s+"))[0])) {

            switch (input[0]) {
                case "Citizen":
                    Birthdable citizen = new Citizen(input[1],
                            input[2], input[3], input[4]);
                    birthdables.add(citizen);
                    break;
                case "Pet":
                    Birthdable pet = new Pet(input[1], input[2]);
                    birthdables.add(pet);
                    break;
                case "Robot":
                    break;
            }
        }

        String birthdayYear = reader.readLine();

        for (Birthdable birthdable : birthdables) {
            String birthday = birthdable.getBirthday();

            if (birthday.endsWith(birthdayYear)) {
                System.out.println(birthday);
            }
        }
    }
}