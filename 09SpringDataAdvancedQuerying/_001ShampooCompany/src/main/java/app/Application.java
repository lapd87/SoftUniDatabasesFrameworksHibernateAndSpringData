package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import repository.builder.lib.ANSRBuilder;
import repository.builder.lib.enums.interfaces.Strategy;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        //might return error but creates files
        ANSRBuilder.run(Strategy.REPOSITORIES_AND_SERVICES(),
                Application.class, args);

        //after error to run
        //SpringApplication.run(Application.class, args);
    }
}
