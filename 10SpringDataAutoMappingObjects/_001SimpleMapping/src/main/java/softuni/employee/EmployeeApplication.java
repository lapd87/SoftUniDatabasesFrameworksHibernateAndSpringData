package softuni.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import repository.builder.lib.ANSRBuilder;
import repository.builder.lib.enums.interfaces.Strategy;

@SpringBootApplication
public class EmployeeApplication {

    public static void main(String[] args) {

        //might return error but creates files
        //ANSRBuilder.run(Strategy.REPOSITORIES_AND_SERVICES(),
        //        EmployeeApplication.class, args);

        //after error to run
        SpringApplication.run(EmployeeApplication.class, args);
    }

//        @Bean
//    public ModelMapper getConfiguredMapper() {
//        ModelMapper modelMapper = new ModelMapper();
//        ModelMapperConfig config = new ModelMapperConfig(modelMapper);
//        return modelMapper;
//    }
}
