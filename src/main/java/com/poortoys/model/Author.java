package com.poortoys.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity  
public class Author {
	@Id
    private String id;   // o Long si prefieres

    private String name;
    private String authorName;

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
