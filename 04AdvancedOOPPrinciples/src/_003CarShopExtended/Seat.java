package _003CarShopExtended;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 15.3.2018 г.
 * Time: 15:20 ч.
 */


public class Seat extends CarAbstract implements Sellable {

    private final double price;

    public Seat(String model,
                String color,
                Integer horsePower,
                String countryProduced,
                Double price) {

        super(model, color, horsePower, countryProduced);
        this.price = price;

    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator()
                + "Price: " + getPrice();
    }
}