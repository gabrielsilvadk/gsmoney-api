package com.gsdev.gsmoney.api.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Categoria.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Categoria_ {

	
	/**
	 * @see com.gsdev.gsmoney.api.model.Categoria#codigo
	 **/
	public static volatile SingularAttribute<Categoria, Long> codigo;
	
	/**
	 * @see com.gsdev.gsmoney.api.model.Categoria#nome
	 **/
	public static volatile SingularAttribute<Categoria, String> nome;
	
	/**
	 * @see com.gsdev.gsmoney.api.model.Categoria
	 **/
	public static volatile EntityType<Categoria> class_;

	public static final String CODIGO = "codigo";
	public static final String NOME = "nome";

}

