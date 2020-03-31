package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.http.MediaType;

import com.example.demo.handlers.CustomerRequestHandler;
import com.example.demo.samples.CreatingFlux;
import com.example.demo.samples.CreatingMono;

@SpringBootApplication(exclude = WebMvcAutoConfiguration.class)
@EnableWebFlux
public class ReactiveQuickStartApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =SpringApplication.run(ReactiveQuickStartApplication.class, args);
	
		
		CreatingMono monoRef = ctx.getBean(CreatingMono.class);
		
		// monoRef.createMonoString();
		
		// monoRef.createMonoCallable();
		
		// monoRef.createFromSupplier();
	
		//monoRef.createMonoFromFlux();
		
		 // monoRef.createOneMonoFromOther();
		
		CreatingFlux fluxRef = ctx.getBean(CreatingFlux.class);
		
		fluxRef.creteFlexInIntervals();
		
		ctx.close();
	}

	
}

