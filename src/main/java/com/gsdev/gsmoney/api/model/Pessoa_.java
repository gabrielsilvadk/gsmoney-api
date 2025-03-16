package com.gsdev.gsmoney.api.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Pessoa.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Pessoa_ {

	
	/**
	 * @see com.gsdev.gsmoney.api.model.Pessoa#codigo
	 **/
	public static volatile SingularAttribute<Pessoa, Long> codigo;
	
	/**
	 * @see com.gsdev.gsmoney.api.model.Pessoa#ativo
	 **/
	public static volatile SingularAttribute<Pessoa, Boolean> ativo;
	
	/**
	 * @see com.gsdev.gsmoney.api.model.Pessoa#endereco
	 **/
	public static volatile SingularAttribute<Pessoa, Endereco> endereco;
	
	/**
	 * @see com.gsdev.gsmoney.api.model.Pessoa#nome
	 **/
	public static volatile SingularAttribute<Pessoa, String> nome;
	
	/**
	 * @see com.gsdev.gsmoney.api.model.Pessoa
	 **/
	public static volatile EntityType<Pessoa> class_;

	public static final String CODIGO = "codigo";
	public static final String ATIVO = "ativo";
	public static final String ENDERECO = "endereco";
	public static final String NOME = "nome";

}

