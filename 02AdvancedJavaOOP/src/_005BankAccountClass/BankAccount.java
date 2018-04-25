package _005BankAccountClass;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 7.3.2018 г.
 * Time: 12:10 ч.
 */


public class BankAccount {

    private final static double DEFAULT_INTEREST = 0.02;

    private static double rate = DEFAULT_INTEREST;
    private static int bankAccountCount = 0;

    private int id;
    private double balance;

    public BankAccount(){
        this.id = ++bankAccountCount;
    }

    public static void setInterest(double interest) {
        rate = interest;
    }

    public void  deposit(double amount){
        this.balance += amount;
    }

    public  double getInterest(int years){
        return this.balance* rate *years;
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}