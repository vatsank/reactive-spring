package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.entity.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class GreetingControllerClient {

	WebClient client = WebClient.create("http://localhost:2222");

	 public void fetch() {
		 
	 
	 
	   Flux<Customer> result = client.get().
			  uri("/api/v1/customer").retrieve().bodyToFlux(Customer.class);


	   result.subscribe(System.out::println);
	   

	 }
	 

		 
}





