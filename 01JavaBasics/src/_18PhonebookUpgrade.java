/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.3.2018 г.
 * Time: 18:10 ч.
 */

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _18PhonebookUpgrade {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine().split("\\s+");

        Map<String, String> phonebook = new TreeMap<>();

        while (!input[0].equals("END")) {
            if (input[0].equals("A")) {
                phonebook.put(input[1], input[2]);
            } else if (input[0].equals("S")) {
                if (phonebook.containsKey(input[1])) {
                    System.out.println(input[1] + " -> " + phonebook.get(input[1]));
                } else {
                    System.out.printf("Contact %s does not exist.%n", input[1]);
                }
            } else {
                for (Map.Entry<String, String> pair : phonebook.entrySet()) {
                    System.out.println(pair.getKey() + " -> " + pair.getValue());
                }
            }

            input = console.nextLine().split("\\s+");
        }
    }
}