package _08Vehicles;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.3.2018 г.
 * Time: 14:00 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Truck extends AbstractVehicle {
    private static final Double TRUCK_CLIMA_CONSUMPTION = 1.6;
    private static final Double TRUCK_FUEL_TANK_HOLE_LOSS = 0.95;

    public Truck(String type, Double fuelQuantity,
                 Double fuelConsumption) {
        super(type, fuelQuantity,
                fuelConsumption + TRUCK_CLIMA_CONSUMPTION);
    }

    @Override
    public void refuel(Double liters) {
        super.refuel(liters * TRUCK_FUEL_TANK_HOLE_LOSS);
    }
}