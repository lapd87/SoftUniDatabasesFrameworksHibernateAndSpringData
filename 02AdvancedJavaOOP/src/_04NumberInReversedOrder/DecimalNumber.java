package _04NumberInReversedOrder;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.3.2018 г.
 * Time: 12:23 ч.
 */

import java.util.Scanner;

public class DecimalNumber {

    private String Num;

    public DecimalNumber(String num) {
        this.Num = num;
    }

    public String getNum() {
        return this.Num;
    }

    public void setNum(String num) {
        this.Num = num;
    }

    public String reversedNumber() {
        String num = this.Num;

        String result = new StringBuilder(num).reverse().toString();

        return result;
    }
}