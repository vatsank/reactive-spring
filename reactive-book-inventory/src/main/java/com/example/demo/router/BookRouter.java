package com.example.demo.router;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.demo.controllers.BookHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class BookRouter {
    @Bean
    public RouterFunction<ServerResponse> route(BookHandler handler) {
        return RouterFunctions
                .route(GET("/fbooks").and(accept(MediaType.APPLICATION_JSON)), handler::getAllBooks)
                .andRoute(GET("/fbooks/{id}").and(accept(MediaType.APPLICATION_STREAM_JSON)), handler::getBookById)
                .andRoute(POST("/fbooks").and(accept(MediaType.APPLICATION_JSON)), handler::save)
                .andRoute(DELETE("/fbooks/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::delete);
    }
}
