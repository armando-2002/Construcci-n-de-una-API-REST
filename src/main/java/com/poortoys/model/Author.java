package com.poortoys.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity  
@Table(name = "author")
public class Author extends Person {

    private String authorName;

	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	

}
