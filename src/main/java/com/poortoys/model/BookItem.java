package com.poortoys.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_item")
public class BookItem extends Book{
	 private String ISBN;

	 public String getISBN() {
		 return ISBN;
	 }

	 public void setISBN(String iSBN) {
		 ISBN = iSBN;
	 }

	 

	 
	 
}
