package softuni.gamestore;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import repository.builder.lib.ANSRBuilder;
import repository.builder.lib.enums.interfaces.Strategy;
import softuni.gamestore.config.ModelMapperConfig;

@SpringBootApplication
public class GameStoreApplication {

    public static void main(String[] args) {

//        might return error but creates files
//        ANSRBuilder.run(Strategy.REPOSITORIES_AND_SERVICES(),
//                GameStoreApplication.class, args);

//        after error to run
        SpringApplication.run(GameStoreApplication.class, args);
    }

    @Bean
    public ModelMapper getConfiguredMapper() {
        ModelMapper modelMapper = new ModelMapper();
        ModelMapperConfig config = new ModelMapperConfig(modelMapper);
        return modelMapper;
    }

}
