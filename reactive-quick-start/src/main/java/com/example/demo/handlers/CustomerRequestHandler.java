package com.example.demo.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.demo.entity.Customer;

import lombok.Setter;
import reactor.core.publisher.Mono;



@Component
@Setter
public class CustomerRequestHandler {

	
	@Autowired
	private Customer customer;
	
	
	public Mono<ServerResponse> findCustomer(ServerRequest request) {
		  Mono<Customer> resp = Mono.just(customer);
		    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
		      .body(resp,Customer.class);
		  }
   
	
	  

}







