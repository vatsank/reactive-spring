package com.example.demo.samples;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;

@Component
public class CreatingFlux {

	
	private static void handleFlux(Flux<?> fluxRef) {
		
		fluxRef.subscribe(
				value -> System.out.println(value),
				 error -> System.out.println(error),
				 () -> System.out.println("completed")
				);
	}

	public void createFluxValues() {
	
		Flux<Integer> integerFlux = Flux.just(1, 2, 3);
		Flux<String> stringFlux = Flux.just("Hello", "foo", "bar");

		handleFlux(integerFlux);
        handleFlux(stringFlux);
	}
	

	public void createFluxFromIterable() {
	
		List<String> stringList = Arrays.asList("Hello", "foo", "bar");

		Flux<String> fluxFromList = Flux.fromIterable(stringList);

		handleFlux(fluxFromList);
	}
	public void createFluxFromStreams() {
	
		List<String> stringList = Arrays.asList("Hello", "foo", "bar");
		Stream<String> stringStream = stringList.stream();
		Flux<String> fluxFromStream = Flux.fromStream(stringStream);
		
		handleFlux(fluxFromStream);

	}
	
	public void creteFlexInIntervals() {
	
		Flux<Long> intervalFlux = Flux.interval(Duration.ofMillis(100));
		
		handleFlux(intervalFlux);

	}
	
	public void createFluxFromOther() {


		// You can also create a Flux from another one, or from a Mono.

		List<String> stringList = Arrays.asList("Hello", "foo", "bar");

		Flux<String> fluxFromList = Flux.fromIterable(stringList);

		
		Flux<String> fluxCopy = Flux.from(fluxFromList);
		
		handleFlux(fluxCopy);
	}

}
