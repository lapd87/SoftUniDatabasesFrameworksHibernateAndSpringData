package _003CarShopExtended;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 15.3.2018 г.
 * Time: 15:30 ч.
 */


public final class Audi extends CarAbstract implements Rentable {

    private final int minRentDays;
    private final double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer minRentDays, Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDays = minRentDays;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public int getMinRentDays() {
        return this.minRentDays;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator()
                + "Min Rent Days: " + getMinRentDays() + System.lineSeparator()
                + "Price per Day: " + getPricePerDay();
    }
}