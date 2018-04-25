package _06ShoppingSpree;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.3.2018 г.
 * Time: 15:27 ч.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            List<Person> clients = new ArrayList<>();
            List<Product> products = new ArrayList<>();

            String[] peopleArgs = reader.readLine().split(";");
            String[] productsArgs = reader.readLine().split(";");

            for (String arg : peopleArgs) {
                String name = arg.split("=")[0];
                double money = Double.parseDouble(arg.split("=")[1]);

                Person currentPerson = new Person(name, money);

                //       if (clients.stream().noneMatch(c->c.getName().equals(name))) {
                clients.add(currentPerson);
                //    }
            }

            for (String arg : productsArgs) {
                String name = arg.split("=")[0];
                double cost = Double.parseDouble(arg.split("=")[1]);

                Product currentPoduct = new Product(name, cost);

                //    if (products.stream().noneMatch(p->p.getName().equals(name))) {
                products.add(currentPoduct);
                //   }
            }


            while (true) {
                String[] command = reader.readLine().split(" ");

                if (command[0].equals("END")) {
                    break;
                }

                String buyer = command[0];
                String buying = command[1];

                Person currentBuyer = clients.stream().filter(p -> p.getName().equals(buyer)).findFirst().get();
                Product currentBuing = products.stream().filter(p -> p.getName().equals(buying)).findFirst().get();
                currentBuyer.buyProduct(currentBuing);

                if (peopleArgs.length == 1 && productsArgs.length == 1) {
                    break;
                }
            }

            for (Person person : clients) {
                List<Product> bag = person.getBag();

                List<String> productsName = new ArrayList<>();

                for (Product product : bag) {
                    String name = product.getName();
                    productsName.add(name);
                }

                String boughtProducts = String.join(", ", productsName);

                if (boughtProducts.length() < 1) {
                    System.out.printf("%s – Nothing bought%n", person.getName());
                } else {
                    System.out.printf("%s - %s%n", person.getName(), boughtProducts);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}