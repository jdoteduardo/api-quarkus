package br.com.stefanini.maratonadev.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "cliente")
@NamedNativeQueries({
	@NamedNativeQuery(name="CONSULTAR_CLIENTE", query = ""
			+ "SELECT id, nome, email, contato FROM cliente", resultClass = Cliente.class),
	@NamedNativeQuery(name="INSERIR_CLIENTE", query = ""
			+ "INSERT INTO todo (nome, cpf, email, contato) values "
			+ "(:nome, :cpf, :email, :contato)"),
})
public class Cliente extends PanacheEntity {
    private Long id;
    
    @Column(name="nome", length = 100, nullable = false)
    private String nome;
    
    @Column(name="cpf", nullable = false, unique = true)
    private String cpf;
    
    @OneToOne
    @JoinColumn
    private Endereco endereco;
    
    @Column(name="email", nullable = false)
    private String email;
    
    @Column(name="contato", nullable = false)
    private String contato;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}   
	
	
	
}
