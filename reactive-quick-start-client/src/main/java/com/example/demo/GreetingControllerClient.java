package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.entity.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class GreetingControllerClient {

	WebClient client = WebClient.create("http://localhost:2020");

	
	 public void fetchOne() {
		 
		 
		 
	 
	      
	      Mono<Customer> result = client.get().uri("/customer")
	                                     .retrieve()
	                                     .bodyToMono(Customer.class);
	      
	      result.subscribe(data  -> System.out.println(data));
	      
	      System.out.println("After subscribe");
	      try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	      System.out.println("bye");

		
}
	 
}





