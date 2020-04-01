package com.example.demo.repos;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.domains.Book;

@Repository
public interface BookRepository extends ReactiveMongoRepository<Book, Integer> {

}
