package com.poortoys.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(MultimediaItem.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class MultimediaItem_ extends com.poortoys.model.Multimedia_ {

	public static final String RESOLUTION = "resolution";

	
	/**
	 * @see com.poortoys.model.MultimediaItem
	 **/
	public static volatile EntityType<MultimediaItem> class_;
	
	/**
	 * @see com.poortoys.model.MultimediaItem#resolution
	 **/
	public static volatile SingularAttribute<MultimediaItem, String> resolution;

}

