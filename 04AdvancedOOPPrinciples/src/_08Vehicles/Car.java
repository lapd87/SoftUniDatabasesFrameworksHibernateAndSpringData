package _08Vehicles;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.3.2018 г.
 * Time: 13:56 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Car extends AbstractVehicle {

    private static final Double CAR_CLIMA_CONSUMPTION = 0.9;

    public Car(String type, Double fuelQuantity,
               Double fuelConsumption) {
        super(type, fuelQuantity,
                fuelConsumption + CAR_CLIMA_CONSUMPTION);
    }

}