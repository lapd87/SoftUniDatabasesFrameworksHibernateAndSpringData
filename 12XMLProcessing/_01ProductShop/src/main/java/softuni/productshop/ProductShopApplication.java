package softuni.productshop;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import softuni.productshop.util.config.ModelMapperConfig;

@SpringBootApplication
public class ProductShopApplication {

    public static void main(String[] args) {


//        might return error but creates files
//        ANSRBuilder.run(Strategy.REPOSITORIES_AND_SERVICES(),
//                ProductShopApplication.class, args);
//
//        after error to run


        SpringApplication.run(ProductShopApplication.class, args);
    }
}
