/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.3.2018 г.
 * Time: 18:09 ч.
 */

import java.util.HashMap;
import java.util.Scanner;

public class _17Phonebook {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine().split("\\s+");

        HashMap<String, String> phonebook = new HashMap<>();

        while (!input[0].equals("END")) {
            if (input[0].equals("A")) {
                phonebook.put(input[1], input[2]);
            } else {
                if (phonebook.containsKey(input[1])) {
                    System.out.println(input[1] + " -> " + phonebook.get(input[1]));
                } else {
                    System.out.printf("Contact %s does not exist.%n", input[1]);
                }
            }

            input = console.nextLine().split("\\s+");
        }
    }
}