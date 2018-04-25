package _005BankAccountClass;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 7.3.2018 г.
 * Time: 12:11 ч.
 */

public class Main {
    public static void main(String[] args) {

        List<BankAccount> accounts = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            String[] commandArgs = command.split("\\s+");

            String commantType = commandArgs[0];

            switch (commantType) {
                case "Create":
                    Create(accounts);
                    break;
                case "Deposit":
                    Deposit(commandArgs, accounts);
                    break;
                case "GetInterest":
                    GetInterest(commandArgs, accounts);
                    break;
                case "SetInterest":
                    BankAccount.setInterest(Double.parseDouble(commandArgs[1]));
                    break;
            }

            command = scanner.nextLine();
        }

    }


    private static void GetInterest(String[] commandArgs, List<BankAccount> accounts) {
        int id = Integer.parseInt(commandArgs[1]) - 1;

        if (id >= accounts.size()) {
            System.out.println("Account does not exist");
        } else {
            int years = Integer.parseInt(commandArgs[2]);

            BankAccount account = accounts.get(id);

            double interest = account.getInterest(years);
            System.out.printf("%.2f%n", interest);
        }
    }


    private static void Deposit(String[] commandArgs, List<BankAccount> accounts) {
        int id = Integer.parseInt(commandArgs[1]) - 1;

        if (id >= accounts.size()) {
            System.out.println("Account does not exist");
        } else {
            double amount = Double.parseDouble(commandArgs[2]);

            BankAccount account = accounts.get(id);
            account.deposit(amount);

            DecimalFormat df = new DecimalFormat("0.##");

            System.out.printf("Deposited %s to %s%n", df.format(amount).replace(',', '.'), account);
        }
    }

    private static void Create(List<BankAccount> accounts) {

        BankAccount account = new BankAccount();
        accounts.add(account);
        System.out.printf("Account %s created%n", account);
    }
}