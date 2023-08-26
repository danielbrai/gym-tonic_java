package com.danielbrai.gymtonic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class GymTonicApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymTonicApplication.class, args);
	}

}
@RestController
class GreetingController {

	@GetMapping(value = "/greet")
	public String greet() {
		return "Greeting from Railway.app";
	}
}

