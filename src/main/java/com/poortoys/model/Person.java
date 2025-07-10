package com.poortoys.model;

import java.time.LocalDate;

import jakarta.persistence.Id;

public class Person {
	 @Id
	    private String id;

	    private String name;
	    private LocalDate dob;
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
		public LocalDate getDob() {
			return dob;
		}
		public void setDob(LocalDate dob) {
			this.dob = dob;
		}
	    
	    

}
