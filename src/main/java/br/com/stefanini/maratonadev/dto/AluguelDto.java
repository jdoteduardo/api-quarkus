package br.com.stefanini.maratonadev.dto;

import java.time.LocalDateTime;

import br.com.stefanini.maratonadev.model.Carro;
import br.com.stefanini.maratonadev.model.Cliente;

public class AluguelDto {
	private Long id;
	
	private Cliente cliente;
	
	private Carro carro;
	
	private LocalDateTime dataAluguel;
	
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
