package _003CarShopExtended;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 15.3.2018 г.
 * Time: 12:04 ч.
 */


public abstract class CarAbstract implements Car {

    private final String model;
    private final String color;
    private final int horsePower;

    private final String countryProduced;

    CarAbstract(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and has %d tires",
        this.getModel(), this.countryProduced, TYRES);
    }
}
