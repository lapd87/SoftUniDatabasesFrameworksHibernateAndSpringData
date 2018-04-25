package _002BankAccountClass;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 7.3.2018 г.
 * Time: 12:10 ч.
 */


public class BankAccount {
    private int id;
    private double balance;

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {

        if (amount < 0) {
            System.out.println("Negative amount");
        } else {
            this.balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > this.balance) {
            System.out.println("Insufficient funds");
        } else {
            this.balance -= amount;
        }
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}