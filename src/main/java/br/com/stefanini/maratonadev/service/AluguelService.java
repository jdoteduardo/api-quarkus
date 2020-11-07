package br.com.stefanini.maratonadev.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.NotFoundException;

import br.com.stefanini.maratonadev.dao.AlguelDao;
import br.com.stefanini.maratonadev.dao.ClienteDao;
import br.com.stefanini.maratonadev.dto.AluguelDto;
import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.model.Aluguel;
import br.com.stefanini.maratonadev.model.Cliente;
import br.com.stefanini.maratonadev.model.parser.AluguelParser;
import br.com.stefanini.maratonadev.model.parser.ClienteParser;

@RequestScoped
public class AluguelService {
	@Inject
    AlguelDao dao;
	
	
	public void inserir(@Valid AluguelDto aluguelDto) {
		Aluguel aluguel = AluguelParser.get().entidade(aluguelDto);
		

		Long id = dao.inserir(aluguel);
	}
	
	@Transactional(rollbackOn = Exception.class)
	public void atualizar(Long id, AluguelDto dto) {
		Aluguel aluguel1 = AluguelParser
				.get()
				.entidade(dto);
		Aluguel aluguelBanco = buscarPorId(id);
		aluguelBanco.setAlugado(aluguel1.getAlugado());
		dao.atualizar(aluguelBanco);
	}
	
	private Aluguel buscarPorId(Long id) {
		Aluguel aluguel = dao.buscarPorId(id);
		if(aluguel == null) {
			throw new NotFoundException();
		}
		return aluguel;
	}
}
