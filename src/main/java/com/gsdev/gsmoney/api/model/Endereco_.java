package com.gsdev.gsmoney.api.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EmbeddableType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Endereco.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Endereco_ {

	
	/**
	 * @see com.gsdev.gsmoney.api.model.Endereco#cidade
	 **/
	public static volatile SingularAttribute<Endereco, String> cidade;
	
	/**
	 * @see com.gsdev.gsmoney.api.model.Endereco#estado
	 **/
	public static volatile SingularAttribute<Endereco, String> estado;
	
	/**
	 * @see com.gsdev.gsmoney.api.model.Endereco#complemento
	 **/
	public static volatile SingularAttribute<Endereco, String> complemento;
	
	/**
	 * @see com.gsdev.gsmoney.api.model.Endereco#numero
	 **/
	public static volatile SingularAttribute<Endereco, String> numero;
	
	/**
	 * @see com.gsdev.gsmoney.api.model.Endereco#logradouro
	 **/
	public static volatile SingularAttribute<Endereco, String> logradouro;
	
	/**
	 * @see com.gsdev.gsmoney.api.model.Endereco#bairro
	 **/
	public static volatile SingularAttribute<Endereco, String> bairro;
	
	/**
	 * @see com.gsdev.gsmoney.api.model.Endereco
	 **/
	public static volatile EmbeddableType<Endereco> class_;
	
	/**
	 * @see com.gsdev.gsmoney.api.model.Endereco#cep
	 **/
	public static volatile SingularAttribute<Endereco, String> cep;

	public static final String CIDADE = "cidade";
	public static final String ESTADO = "estado";
	public static final String COMPLEMENTO = "complemento";
	public static final String NUMERO = "numero";
	public static final String LOGRADOURO = "logradouro";
	public static final String BAIRRO = "bairro";
	public static final String CEP = "cep";

}

