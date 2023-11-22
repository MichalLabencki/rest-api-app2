package carrestapi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("carrestapi.demo")
public class CarRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRestApiApplication.class, args);
	}

}
