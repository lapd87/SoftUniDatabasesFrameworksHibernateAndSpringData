package _08Vehicles;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.3.2018 г.
 * Time: 13:31 ч.
 */

import com.sun.org.apache.bcel.internal.classfile.SourceFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public abstract class AbstractVehicle implements Vehicle {

    private String type;
    private Double fuelQuantity;
    private Double fuelConsumption;


    public AbstractVehicle(String type, Double fuelQuantity,
                           Double fuelConsumption) {
        this.type = type;
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;

    }

    public void setFuelQuantity(Double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public Double getFuelQuantity() {
        return fuelQuantity;
    }

    @Override
    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public String getType() {
        return type;
    }

    public void refuel(Double liters) {
        setFuelQuantity(getFuelQuantity() + liters);
    }

    public void drive(Double distance) {

        Double fuelNeeded = distance * getFuelConsumption();

        if (fuelNeeded > getFuelQuantity()) {
            System.out.printf("%s needs refueling%n",
                    getType());
        } else {
            setFuelQuantity(getFuelQuantity() - fuelNeeded);

            DecimalFormat df = new DecimalFormat("#.##################");

            System.out.printf("%s travelled %s km%n",
                    getType(), df.format(distance).replace(',','.'));
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",
                getType(), getFuelQuantity());
    }
}