package com.poortoys.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_item")
public class BookItem extends Book{
	 private String isbn;

	 public String getIsbn() {
		 return isbn;
	 }

	 public void setIsbn(String isbn) {
		 this.isbn = isbn;
	 }


	 

	 
	 
}
