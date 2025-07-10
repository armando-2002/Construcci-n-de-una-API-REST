package com.poortoys.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Multimedia.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Multimedia_ {

	public static final String FORMAT = "format";
	public static final String ID = "id";
	public static final String TITLE = "title";

	
	/**
	 * @see com.poortoys.model.Multimedia#format
	 **/
	public static volatile SingularAttribute<Multimedia, String> format;
	
	/**
	 * @see com.poortoys.model.Multimedia#id
	 **/
	public static volatile SingularAttribute<Multimedia, Long> id;
	
	/**
	 * @see com.poortoys.model.Multimedia#title
	 **/
	public static volatile SingularAttribute<Multimedia, String> title;
	
	/**
	 * @see com.poortoys.model.Multimedia
	 **/
	public static volatile EntityType<Multimedia> class_;

}

