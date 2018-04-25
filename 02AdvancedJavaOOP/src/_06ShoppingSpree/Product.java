package _06ShoppingSpree;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.3.2018 г.
 * Time: 15:27 ч.
 */


public class Product {

    private String name;
    private double cost;

    public Product(String name, double cost) {
        if (name == null || name.isEmpty()) {
            System.out.println("Name cannot be empty");
            throw new java.lang.RuntimeException();
        } else if (cost < 0) {
            System.out.println("Money cannot be negative");
            throw new java.lang.RuntimeException();
        } else {
            this.name = name;
            this.cost = cost;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new java.lang.RuntimeException("Name cannot be empty");
        } else {
            this.name = name;
        }
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if (cost < 0) {
            throw new java.lang.RuntimeException("Money cannot be negative");
        } else {
            this.cost = cost;
        }
    }
}