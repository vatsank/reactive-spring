package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping(path = "/api/v1/customer")
public class CustomerController {

	
	@GetMapping
	public Flux<Customer> findAll(){
		
		return Flux.just(
				new Customer(101, "Ramesh", 95959595),
				new Customer(102, "Suresh", 65979685)
				
				);
		
	}
}
