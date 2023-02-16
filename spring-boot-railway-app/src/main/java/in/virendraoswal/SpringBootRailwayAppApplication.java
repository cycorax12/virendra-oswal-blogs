package in.virendraoswal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootRailwayAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRailwayAppApplication.class, args);
	}

}

@RestController
class GreetingController {

	@GetMapping(value = "/greet")
	public String greet() {
		return "Greeting from Railway.app";
	}
}
