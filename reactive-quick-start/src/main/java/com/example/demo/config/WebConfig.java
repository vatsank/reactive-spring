package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.demo.entity.Customer;
import com.example.demo.handlers.CustomerRequestHandler;

@Configuration
public class WebConfig  {

	
	  @Bean
	  public RouterFunction<ServerResponse> route(CustomerRequestHandler customerHandler) {

	    return RouterFunctions
	      .route(RequestPredicates.GET("/customer").
	    		  and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), customerHandler::findCustomer);
	  }


	  @Bean
	  public Customer vikram() {
		  
		  return new Customer(1034,"Vikram",75747);
	  }
}

