package com.example.bhintunaReview.MovieReview;

//the name of the artifact is Movies hence this file has been named as MoviesApplication.java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//marks the class as the main entry point for the Spring Boot application,
// enabling auto-configuration, component scanning, and other Spring Boot features.
@EnableMongoRepositories(basePackages = "com.example.bhintunaReview.MovieReview")
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	@GetMapping
//	maps HTTP GET requests to the apiRoot method.
//	When someone accesses the root URL (/), the method below @GetMapping will be called.
	public String apiRoot(){
		return "Hello World ! This is me, Spring Boot!";
	}
}