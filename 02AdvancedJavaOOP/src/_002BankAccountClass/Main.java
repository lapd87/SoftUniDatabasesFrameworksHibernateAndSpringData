package _002BankAccountClass;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 7.3.2018 г.
 * Time: 12:11 ч.
 */

public class Main {
    public static void main(String[] args) {

        BankAccount acc = new BankAccount();

        acc.setId(1);
        acc.deposit(15);
        acc.withdraw(5);

        System.out.printf("Account ID%d, balance %.2f", acc, acc.getBalance());
    }
}