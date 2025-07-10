package com.poortoys.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "multimedia_item")
public class MultimediaItem extends Multimedia{
	 private String resolution;

	 public String getResolution() {
		 return resolution;
	 }

	 public void setResolution(String resolution) {
		 this.resolution = resolution;
	 }
	 
	 
	 
}
