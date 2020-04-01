package com.example.demo.domains;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	private int bookId;
	private String bookName;
	private String author;
	private double ratePerUnit;
}
