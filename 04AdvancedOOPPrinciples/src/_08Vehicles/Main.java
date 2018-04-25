package _08Vehicles;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.3.2018 г.
 * Time: 13:25 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputCar = reader.readLine().split("\\s+");
        String[] inputTruck = reader.readLine().split("\\s+");

        int commandsCount = Integer.parseInt(reader.readLine());

        Car car = new Car(inputCar[0],
                Double.parseDouble(inputCar[1]),
                Double.parseDouble(inputCar[2]));

        Truck truck = new Truck(inputTruck[0],
                Double.parseDouble(inputTruck[1]),
                Double.parseDouble(inputTruck[2]));


        for (int i = 0; i < commandsCount; i++) {

            String[] currentCommand = reader.readLine().split("\\s+");

            String action = currentCommand[0].toLowerCase();
            String vehicleType = currentCommand[1];
            Double actionArgs;

            try {
                actionArgs = Double.parseDouble(currentCommand[2]);
            } catch (Exception e) {
                continue;
            }

            switch (vehicleType) {
                case "Car":
                    car.getClass().getMethod(action, Double.class).invoke(car, actionArgs);
                    break;
                case "Truck":
                    truck.getClass().getMethod(action, Double.class).invoke(truck, actionArgs);
                    break;
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}