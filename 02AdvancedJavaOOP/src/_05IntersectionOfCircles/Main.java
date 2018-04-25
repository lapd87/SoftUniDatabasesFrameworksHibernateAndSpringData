package _05IntersectionOfCircles;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.3.2018 г.
 * Time: 14:26 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] firstCircleParam = Arrays
                .stream(reader.readLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondCircleParam = Arrays
                .stream(reader.readLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Point firstCircleCenter = new Point(firstCircleParam[0],
                firstCircleParam[1]);

        Circle firstCircle = new Circle(firstCircleCenter,
                firstCircleParam[2]);

        Point secondCircleCenter = new Point(secondCircleParam[0],
                secondCircleParam[1]);

        Circle secondCircle = new Circle(secondCircleCenter,
                secondCircleParam[2]);


        double differenceX = firstCircleCenter.getX() - secondCircleCenter.getX();

        double differenceY = firstCircleCenter.getY() - secondCircleCenter.getY();

        double distance = Math.sqrt(differenceX * differenceX + differenceY * differenceY);

        if (distance > firstCircle.getRadius() + secondCircle.getRadius()) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}