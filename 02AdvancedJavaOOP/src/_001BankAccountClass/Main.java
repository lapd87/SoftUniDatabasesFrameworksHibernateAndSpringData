package _001BankAccountClass;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 7.3.2018 г.
 * Time: 12:11 ч.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        BankAccount acc = new BankAccount();

        acc.id = 1;
        acc.balance = 15;

        System.out.printf("Account ID%d, balance %.2f", acc.id, acc.balance);
    }
}