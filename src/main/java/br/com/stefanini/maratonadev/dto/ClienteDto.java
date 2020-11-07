package br.com.stefanini.maratonadev.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import br.com.stefanini.maratonadev.model.Endereco;

public class ClienteDto implements Serializable {
	
	private Long id;
	
	@NotNull()
	@NotBlank(message = "Não é permito nome vazio")
	@Length(min = 3, max = 100, message = "Não é permido nomes "
			+ "menores que 3 caracteres ou maiores que 100")
	private String nome;
	
	private String cpf;
	
    private Endereco endereco;
	
	private String email;
	
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
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
	
	
}
