package _09Animals;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.3.2018 г.
 * Time: 15:18 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();


        while (true) {

            if  ("Beast!".equals(input) || input == null){
                break;
            }

            try {
                String[] inputArgs = reader.readLine().split("\\s+");

                if (inputArgs.length < 3) {
                    throw new IllegalArgumentException("Invalid input!");
                }

                String type = input;
                String name = inputArgs[0];
                int age = Integer.parseInt(inputArgs[1]);
                String gender = inputArgs[2];

                Animal currentAnimal = new Animal();

                switch (type) {
                    case "Cat":
                        currentAnimal = new Cat(type,
                                name, age, gender);
                        break;
                    case "Dog":
                        currentAnimal = new Dog(type,
                                name, age, gender);
                        break;
                    case "Frog":
                        currentAnimal = new Frog(type,
                                name, age, gender);
                        break;
                    case "Kittens":
                        currentAnimal = new Kittens(type,
                                name, age, "Female");
                        break;
                    case "Tomcat":
                        currentAnimal = new Tomcat(type,
                                name, age, "Male");
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid input!");

                }

                System.out.println(currentAnimal.toString());

                System.out.println(currentAnimal.produceSound());

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            finally {
                input = reader.readLine();
            }
        }
    }
}