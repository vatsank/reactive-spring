package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class ReactiveQuickStartClientApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(ReactiveQuickStartClientApplication.class, args);
	
		GreetingControllerClient client =
				ctx.getBean(GreetingControllerClient.class);
		
		//client.fetch();
		
		client.fetchOne();
	
	}

}
