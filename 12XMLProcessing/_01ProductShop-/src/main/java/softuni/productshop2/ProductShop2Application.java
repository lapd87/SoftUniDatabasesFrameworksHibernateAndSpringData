package softuni.productshop2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import repository.builder.lib.ANSRBuilder;
import repository.builder.lib.enums.interfaces.Strategy;

@SpringBootApplication
public class ProductShop2Application {

    public static void main(String[] args) {

//        might return error but creates files
//        ANSRBuilder.run(Strategy.REPOSITORIES_AND_SERVICES(),
//                ProductShop2Application.class, args);
//
//        after error to run

        SpringApplication.run(ProductShop2Application.class, args);
    }
}
