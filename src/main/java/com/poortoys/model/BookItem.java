package com.poortoys.model;

import jakarta.persistence.Entity;

@Entity
public class BookItem extends Book{
	 private String resolution;

	 public String getResolution() {
		 return resolution;
	 }

	 public void setResolution(String resolution) {
		 this.resolution = resolution;
	 }
	 
}
