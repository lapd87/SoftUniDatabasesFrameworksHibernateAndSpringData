package _03LastDigitName;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.3.2018 г.
 * Time: 11:57 ч.
 */

import java.util.Scanner;

public class Number {

    private int Number;

    public Number(String number) {
        this.Number = Integer.parseInt(number);
    }

    public int getNumber() {
        return this.Number;
    }

    public void setNumber(String number) {
        this.Number = Integer.parseInt(number);
    }

    public String lastDigitName() {

        int lastChar = Math.abs(this.Number % 10);
        String[] area = new String[]{"zero", "one",
                "two", "three", "four", "five", "six",
                "seven", "eight", "nine"};

        for (int i = 0; i < area.length; i++) {
            if (lastChar == i) {
                return area[i];
            }
        }

        return "";
    }
}