package _05BorderControl;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.3.2018 г.
 * Time: 18:14 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Entrants> entrants = new ArrayList<>();

        String[] input;

        while (!"End".equals((input = reader.readLine().split("\\s+"))[0])) {

            if (input.length == 2) {
                Robot currentRobbot = new Robot(input[0], input[1]);
                entrants.add(currentRobbot);
            } else if (input.length == 3) {
                Citizen currentCitizen = new Citizen(input[0],
                        Integer.parseInt(input[1]), input[2]);
                entrants.add(currentCitizen);
            }
        }

        String fakeIdArg = reader.readLine();

        for (Entrants entrant : entrants) {
            String id = entrant.Id();

            if (id.endsWith(fakeIdArg)) {
                System.out.println(id);
            }
        }
    }
}