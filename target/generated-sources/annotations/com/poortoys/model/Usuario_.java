package com.poortoys.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Usuario.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Usuario_ {

	public static final String CORREO = "correo";
	public static final String ID = "id";
	public static final String NOMBRE = "nombre";

	
	/**
	 * @see com.poortoys.model.Usuario#correo
	 **/
	public static volatile SingularAttribute<Usuario, String> correo;
	
	/**
	 * @see com.poortoys.model.Usuario#id
	 **/
	public static volatile SingularAttribute<Usuario, Long> id;
	
	/**
	 * @see com.poortoys.model.Usuario
	 **/
	public static volatile EntityType<Usuario> class_;
	
	/**
	 * @see com.poortoys.model.Usuario#nombre
	 **/
	public static volatile SingularAttribute<Usuario, String> nombre;

}

