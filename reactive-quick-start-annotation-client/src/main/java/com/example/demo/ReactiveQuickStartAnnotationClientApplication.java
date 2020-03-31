package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ReactiveQuickStartAnnotationClientApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(ReactiveQuickStartAnnotationClientApplication.class, args);
		
		GreetingControllerClient client =
				ctx.getBean(GreetingControllerClient.class);
		
		client.fetch();
		}

}
