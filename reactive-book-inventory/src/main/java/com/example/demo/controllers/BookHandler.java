package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

import com.example.demo.domains.Book;
import com.example.demo.service.BookService;

import lombok.Setter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Setter
@Component
public class BookHandler {

	
	@Autowired
	private BookService service;
	
	
    public Mono<ServerResponse> getBookById(ServerRequest request) {
        
    	int id = Integer.parseInt(request.pathVariable("id"));
        
    	return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(service.findById(id),Book.class);
    	
    }
    
    
       public Mono<ServerResponse> getAllBooks(ServerRequest request) {
          

           
    	  return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).
    			   body(service.findAll(),Book.class);
    }
       
       public Mono<ServerResponse> save(ServerRequest request) {
           final Mono<Book> book = request.bodyToMono(Book.class);
           
           return ServerResponse.ok()
                   .contentType(MediaType.APPLICATION_JSON)
                   .body(fromPublisher(book.flatMap(service::save), Book.class));
       }
       public Mono<ServerResponse> delete(ServerRequest request) {
           int id = Integer.parseInt(request.pathVariable("id"));
           return ServerResponse.ok()
                   .contentType(MediaType.APPLICATION_JSON)
                   .body(service.deleteById(id), Void.class);
       }


}
