package _001ShapesDrawing;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 15.3.2018 г.
 * Time: 11:46 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Circle implements Drawable {
    private int radius;
    private int X;
    private int Y;

    public Circle(int radius, int x, int y) {
        this.radius = radius;
        X = x;
        Y = y;
    }

    public void draw() {
        double r_in = this.radius - 0.4;
        double r_out = this.radius + 0.4;
        for (double y = this.radius;
             y >= -this.radius; --y) {
            for (double x = -this.radius;
                 x < r_out; x += 0.5) {
                double value = x * x + y * y;
                if (value >= r_in * r_in
                        && value <= r_out * r_out) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
