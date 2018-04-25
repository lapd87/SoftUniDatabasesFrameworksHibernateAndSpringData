package _04Telephony;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.3.2018 г.
 * Time: 17:56 ч.
 */


public class Smartphone implements Callable, Browsable {

    private String actionArgs;

    public Smartphone(String action) {
        this.actionArgs = action;
    }

    @Override
    public String browse() {
        return "Browsing: " + actionArgs+ "!";
    }

    @Override
    public String call() {
        return "Calling... " + actionArgs;
    }
}