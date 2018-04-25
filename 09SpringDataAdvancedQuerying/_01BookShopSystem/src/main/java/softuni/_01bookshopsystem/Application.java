package softuni._01bookshopsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		//might return error but creates files
		ANSRBuilder.run(ResourceProperties.Strategy.REPOSITORIES_AND_SERVICES(),
				Application.class, args);

		//after error to run
		//SpringApplication.run(Application.class, args);


		SpringApplication.run(Application.class, args);
	}
}
