package _004PersonClass;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 7.3.2018 г.
 * Time: 12:45 ч.
 */

import _003BankAccountClass.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private int age;
    private List<BankAccount> accounts;

    public Person(String name, int age) {
        this(name, age, new ArrayList<>());
    }

    public Person(String name, int age, List<BankAccount> accounts) {
        this.name = name;
        this.age = age;
        this.accounts = accounts;
    }

    public double getBalance() {
        return this.accounts.stream().mapToDouble(a -> a.getBalance()).sum();
    }
}