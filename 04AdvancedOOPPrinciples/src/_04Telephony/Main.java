package _04Telephony;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.3.2018 г.
 * Time: 17:52 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] phoneNumbers = reader.readLine().split("\\s+");
        String[] sites = reader.readLine().split("\\s+");

        for (String phoneNumber : phoneNumbers) {
            if (phoneNumber.matches("^[\\d]+$")) {
                Callable phone = new Smartphone(phoneNumber);
                System.out.println(phone.call());
            } else {
                System.out.println("Invalid number!");
            }
        }

        for (String site : sites) {
            if (!site.matches(".*\\d+.*")) {
                Browsable phone = new Smartphone(site);
                System.out.println(phone.browse());
            } else {
                System.out.println("Invalid URL!");
            }
        }
    }
}