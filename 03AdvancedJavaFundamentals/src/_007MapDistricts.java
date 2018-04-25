/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.3.2018 г.
 * Time: 09:14 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _007MapDistricts {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, List<Integer>> cities = new HashMap<>();

        List<String> input = Arrays
                .asList(reader
                        .readLine()
                        .split("\\s+"));

        int minPopulation = Integer.parseInt(reader.readLine());

        for (String cityPopulation : input) {
            String[] cityPopulationArgs = cityPopulation.split(":");

            String city = cityPopulationArgs[0];
            int population = Integer.parseInt(cityPopulationArgs[1]);

            cities.putIfAbsent(city, new ArrayList<>());
            cities.get(city).add(population);
        }

        cities
                .entrySet()
                .stream()
                .filter(c -> c.getValue()
                        .stream()
                        .mapToInt(Integer::valueOf)
                        .sum() >= minPopulation)
                .sorted((d1, d2) -> Integer
                        .compare(d2.getValue()
                                        .stream()
                                        .mapToInt(Integer::valueOf)
                                        .sum(),
                                d1.getValue()
                                        .stream()
                                        .mapToInt(Integer::valueOf)
                                        .sum()))
                .forEach(c->{
                    System.out.print(c.getKey() + ": ");
                    c.getValue()
                            .stream()
                            .sorted(Comparator.reverseOrder())
                            .limit(5)
                            .forEach(d-> System.out.print(d + " "));
                    System.out.println();
                });
    }
}