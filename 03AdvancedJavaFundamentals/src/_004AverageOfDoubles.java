/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.3.2018 г.
 * Time: 09:11 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

public class _004AverageOfDoubles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        OptionalDouble result = Arrays
                .stream(reader
                        .readLine()
                        .split("\\s+"))
                .filter(s->!s.isEmpty())
                .mapToDouble(Double::parseDouble)
                .average();

        if (result.isPresent()){
            System.out.printf("%.2f%n",result.getAsDouble());
        }
        else {
            System.out.println("No match");
        }

    }
}