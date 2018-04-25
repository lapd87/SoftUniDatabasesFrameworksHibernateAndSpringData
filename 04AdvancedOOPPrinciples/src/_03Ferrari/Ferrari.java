package _03Ferrari;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.3.2018 г.
 * Time: 15:40 ч.
 */


public class Ferrari implements Car {

    private String DEFAULT_MODEL = "488-Spider";

    private String model;
    private String driver;

    public Ferrari(String driver) {
        this.model = DEFAULT_MODEL;
        this.driver = driver;
    }

    public Ferrari(String model, String driver) {
        this.model = model;
        this.driver = driver;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getDriver() {
        return driver;
    }

    @Override
    public String pushBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushGasPedal() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s%n",
                this.getModel(),
                this.pushBrakes(),
                this.pushGasPedal(),
                this.getDriver());
    }
}