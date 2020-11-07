package br.com.stefanini.maratonadev.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "aluguel")
@NamedNativeQueries({
	@NamedNativeQuery(name="INSERIR_ALUGUEL", query = ""
			+ "INSERT INTO aluguel (cliente, carro, dataAluguel, alugado) values "
			+ "(:cliente, :carro, :dataAluguel, :alugado)"),
	@NamedNativeQuery(name="ATUALIZAR_ALUGUEL", query="UPDATE todo "
			+ "set alugado = :alugado WHERE id = :id")
})
public class Aluguel extends PanacheEntity{
	private Long id;
	
	@OneToOne
	@JoinColumn
	private Cliente cliente;
	
	@OneToOne
	@JoinColumn
	private Carro carro;
	
	@Column(name="dataCriacao", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime dataAluguel;
	
	@Column(name="alugado", nullable = false, updatable = true)
	private Boolean alugado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public LocalDateTime getDataAluguel() {
		return dataAluguel;
	}

	public void setDataAluguel(LocalDateTime dataAluguel) {
		this.dataAluguel = dataAluguel;
	}

	public Boolean getAlugado() {
		return alugado;
	}

	public void setAlugado(Boolean alugado) {
		this.alugado = alugado;
	}
}
