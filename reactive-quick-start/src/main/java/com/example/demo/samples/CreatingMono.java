package com.example.demo.samples;

import java.util.Random;
import java.util.concurrent.Future;

import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Configuration
public class CreatingMono {

	private static void handleMono(Mono<?> monoRef) {
		
		monoRef.subscribe(
				value -> System.out.println(value),
				 error -> System.out.println(error),
				 () -> System.out.println("completed")
				);
	}
	
	public void createMonoString() {
		
		Mono<String> helloWorld = Mono.just("Hello World !");

		handleMono(helloWorld);
		
	}
	
	
	public void createMonoCallable() {
		
		Mono<String> callable = Mono.fromCallable(() -> "Hello From Callable !");

		handleMono(callable);
	}
	
	public void createMonoFuture() {
	
//		CompletableFuture<String> helloWorldFuture = MyApi.getHelloWorldAsync();
//	Mono<String> monoFromFuture = Mono.fromFuture(helloWorldFuture);

	}

	public void createFromSupplier() {
	
		Random rnd = new Random();
		Mono<Double> monoFromSupplier = Mono.fromSupplier(rnd::nextDouble);

		handleMono(monoFromSupplier);
	}

	public void createOneMonoFromOther() {
	
		Random rnd = new Random();
		Mono<Double> monoFromSupplier = Mono.fromSupplier(rnd::nextDouble);

		Mono<Double> monoCopy = Mono.from(monoFromSupplier);
		
		handleMono(monoCopy);

	}
	public void createMonoFromFlux() {
	
		Mono<Integer> monoFromFlux = Mono.from(Flux.range(1, 10)); 

		handleMono(monoFromFlux);
	}
	
}
