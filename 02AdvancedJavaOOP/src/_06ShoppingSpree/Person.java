package _06ShoppingSpree;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.3.2018 г.
 * Time: 15:27 ч.
 */

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private double money;
    private List<Product> bag;

    public Person(String name, double money) {
        if (name == null || name.isEmpty()) {
            throw new java.lang.RuntimeException("Name cannot be empty");
        } else if (money < 0) {
            throw new java.lang.RuntimeException("Money cannot be negative");
        } else {
            this.name = name;
            this.money = money;
            this.bag = new ArrayList<>();
        }
    }

    public Person(String name, double money, Product product) {
        this.name = name;
        this.money = money;
        this.bag.add(product);
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new java.lang.RuntimeException("Money cannot be negative");
        } else {
            this.money = money;
        }
    }

    public List<Product> getBag() {
        return bag;
    }

    public void buyProduct(Product product) {
        if (product.getCost() <= money) {
            money -= product.getCost();
            bag.add(product);
            System.out.printf("%s bought %s%n", name, product.getName());
        } else {
            System.out.printf("%s can't afford %s%n", name, product.getName());
        }
    }
}