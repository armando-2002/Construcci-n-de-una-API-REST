package com.poortoys.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Author.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Author_ {

	public static final String AUTHOR_NAME = "authorName";
	public static final String NAME = "name";
	public static final String ID = "id";

	
	/**
	 * @see com.poortoys.model.Author#authorName
	 **/
	public static volatile SingularAttribute<Author, String> authorName;
	
	/**
	 * @see com.poortoys.model.Author#name
	 **/
	public static volatile SingularAttribute<Author, String> name;
	
	/**
	 * @see com.poortoys.model.Author#id
	 **/
	public static volatile SingularAttribute<Author, String> id;
	
	/**
	 * @see com.poortoys.model.Author
	 **/
	public static volatile EntityType<Author> class_;

}

