package br.com.stefanini.maratonadev.dao;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.stefanini.maratonadev.model.Aluguel;
import br.com.stefanini.maratonadev.model.Cliente;

@RequestScoped
public class AlguelDao {
	@Inject
	EntityManager em;
	
	public Long inserir(Aluguel aluguel) {
		String nomeSql = "INSERIR_ALUGUEL";
		aluguel.persistAndFlush();
		return aluguel.getId();
	}
	
	@Transactional
	public void atualizar(Aluguel aluguel) {
		String nomeSql = "ATUALIZAR_ALUGUEL";
		inserirOuAtualizar(nomeSql, aluguel);
	}
	
	public Aluguel buscarPorId(Long id) {
		String nomeSql = "CONSULTAR_TODO_ID";
		Aluguel aluguel;
		TypedQuery<Aluguel> query = 
				em
				.createNamedQuery(nomeSql, Aluguel.class);
		query.setParameter("id", id);
		try {
			aluguel = query.getSingleResult();
		}catch(NoResultException e) {
			aluguel = null;
		}
		return aluguel;
	}
	
	@Transactional
	private void inserirOuAtualizar(String nomeSql, Aluguel aluguel) {
		Query query = em.createNamedQuery(nomeSql);
		
		query.setParameter("id", aluguel.getId());
		query.setParameter("cliente", aluguel.getCliente());
		query.setParameter("carro", aluguel.getCarro());
		query.setParameter("dataAluguel", aluguel.getDataAluguel());
		query.setParameter("alugado", aluguel.getAlugado());
		
		query.executeUpdate();
	}
	
	
}
