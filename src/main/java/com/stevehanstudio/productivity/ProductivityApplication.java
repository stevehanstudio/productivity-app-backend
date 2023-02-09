package com.stevehanstudio.productivity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "My Productivity App API", version = "1.0", description = "API for performing CRUD operations on Projects and Tasks"))
public class ProductivityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductivityApplication.class, args);
	}

}
