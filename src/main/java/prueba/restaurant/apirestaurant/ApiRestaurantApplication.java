package prueba.restaurant.apirestaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "prueba.restaurant.apirestaurant")
public class ApiRestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestaurantApplication.class, args);
	}

}
