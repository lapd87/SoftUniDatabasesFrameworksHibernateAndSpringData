package _003BankAccountClass;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 7.3.2018 г.
 * Time: 12:11 ч.
 */

public class Main {
    public static void main(String[] args) {

        HashMap<Integer, BankAccount> accounts = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            String[] commandArgs = command.split("\\s+");

            String commantType = commandArgs[0];

            switch (commantType) {
                case "Create":
                    Create(commandArgs, accounts);
                    break;
                case "Deposit":
                    Deposit(commandArgs, accounts);
                    break;
                case "Withdraw":
                    Withdraw(commandArgs, accounts);
                    break;
                case "Print":
                    Print(commandArgs, accounts);
                    break;
            }

            command = scanner.nextLine();
        }

    }

    private static void Print(String[] commandArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(commandArgs[1]);

        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
        } else {

            BankAccount account = accounts.get(id);

            System.out.printf("Account %s, balance %.2f%n", account, account.getBalance());
        }
    }

    private static void Withdraw(String[] commandArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(commandArgs[1]);
        double amount = Double.parseDouble(commandArgs[2]);

        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
        } else {
            BankAccount account = accounts.get(id);
            account.withdraw(amount);
        }
    }

    private static void Deposit(String[] commandArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(commandArgs[1]);
        double amount = Double.parseDouble(commandArgs[2]);

        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
        } else {
            BankAccount account = accounts.get(id);
            account.deposit(amount);
        }
    }

    private static void Create(String[] commandArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(commandArgs[1]);

        if (accounts.containsKey(id)) {
            System.out.println("Account already exists");
        } else {
            BankAccount account = new BankAccount();
            account.setId(id);
            accounts.put(id, account);
        }
    }
}