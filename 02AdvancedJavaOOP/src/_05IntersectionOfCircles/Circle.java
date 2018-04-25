package _05IntersectionOfCircles;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.3.2018 г.
 * Time: 14:26 ч.
 */


public class Circle {

    private Point center;
    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Circle(Point center, int radius) {

        this.center = center;
        this.radius = radius;
    }
}