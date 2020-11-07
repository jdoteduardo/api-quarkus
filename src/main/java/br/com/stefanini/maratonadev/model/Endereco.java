package br.com.stefanini.maratonadev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "cliente")
public class Endereco extends PanacheEntity{
	@Column(name="cep", nullable = false)
	private String cep;
	
	@Column(name="bairro", nullable = false)
	private String bairro;
	
	@Column(name="cidade", nullable = false)
	private String cidade;
	
	@Column(name="uf", nullable = false)
	private String uf;
}
