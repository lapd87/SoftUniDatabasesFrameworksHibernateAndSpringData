/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.3.2018 г.
 * Time: 09:15 ч.
 */

import java.io.*;
import java.util.Scanner;

public class _010PrintFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isPrinted = false;
        char ch = 'y';

        try {
            do {
                System.out.println("Enter path to the file to print : ");
                String filePath = scanner.nextLine();
                try {
                    printFile(filePath);
                    isPrinted = true;
                } catch (FileNotFoundException e) {
                    System.out.println("File with name \""
                            + filePath
                            + " \" is not found !");
                    System.out.println("Do you want to try again ? (y or n)");
                    ch = scanner.next().toLowerCase().trim().charAt(0);
                }
            }
            while (!isPrinted && ch == 'y');
        } finally {
            scanner.close();
        }
        if (isPrinted) {
            System.out.println("File printed successfully !");
        }
        System.out.println("Good bye !");
    }


    private static void printFile(String fileName) throws FileNotFoundException {
        File sourceFile = new File(fileName);

        Scanner scanner = new Scanner(sourceFile);

        String line = "";

        try {
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                System.out.println(line);
            }
        } finally {
            scanner.close();
        }
    }
}