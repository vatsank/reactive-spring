package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication(exclude =WebMvcAutoConfiguration.class)
@EnableWebFlux

public class ReactiveBookInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveBookInventoryApplication.class, args);
	}

	
}
