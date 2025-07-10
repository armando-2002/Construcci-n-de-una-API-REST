package com.poortoys.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(BookItem.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class BookItem_ extends com.poortoys.model.Book_ {

	public static final String RESOLUTION = "resolution";

	
	/**
	 * @see com.poortoys.model.BookItem
	 **/
	public static volatile EntityType<BookItem> class_;
	
	/**
	 * @see com.poortoys.model.BookItem#resolution
	 **/
	public static volatile SingularAttribute<BookItem, String> resolution;

}

