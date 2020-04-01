package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domains.Book;
import com.example.demo.repos.BookRepository;

import lombok.Setter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Setter
public class BookService {

	
	@Autowired
	private BookRepository repo;
	

    public Mono<Book> findById(Integer id){
		
		return this.repo.findById(id);
	}
	

	
	public Flux<Book> findAll(){
		
		return this.repo.findAll();
	}
	
	
	public Mono<Book> save(Book entity) {
		
		return this.repo.save(entity);
	}
	
	
    public Mono<Void> deleteById(Integer id) {
        return this.repo.deleteById(id);
    }

}
