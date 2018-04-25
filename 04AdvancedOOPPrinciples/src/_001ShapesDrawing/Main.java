package _001ShapesDrawing;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 15.3.2018 г.
 * Time: 11:45 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            queue.add(Integer.parseInt(scanner.nextLine()));
        }

        Drawable circle = new Circle(queue.poll(), queue.poll(), queue.poll());
        Drawable rect = new Rectangle(queue.poll(), queue.poll());

        circle.draw();
        rect.draw();
    }

}