package com.poortoys.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Book.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Book_ {

	public static final String AUTHOR = "author";
	public static final String ID = "id";
	public static final String TITLE = "title";

	
	/**
	 * @see com.poortoys.model.Book#author
	 **/
	public static volatile SingularAttribute<Book, Author> author;
	
	/**
	 * @see com.poortoys.model.Book#id
	 **/
	public static volatile SingularAttribute<Book, Long> id;
	
	/**
	 * @see com.poortoys.model.Book#title
	 **/
	public static volatile SingularAttribute<Book, String> title;
	
	/**
	 * @see com.poortoys.model.Book
	 **/
	public static volatile EntityType<Book> class_;

}

