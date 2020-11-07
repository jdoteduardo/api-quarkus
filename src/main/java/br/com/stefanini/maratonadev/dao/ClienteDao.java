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

import br.com.stefanini.maratonadev.model.Cliente;

@RequestScoped
public class ClienteDao {
	@Inject
	EntityManager em;
	
	public Long inserir(Cliente cliente) {
		String nomeSql = "INSERIR_TODO";
		cliente.persistAndFlush();
		return cliente.getId();
	}
	
	//Listar
	public List<Cliente> listar(){
		String nomeConsulta = "CONSULTAR_TODO";
		List<Cliente> listaRetorno;
		TypedQuery<Cliente> query = em.createNamedQuery(nomeConsulta, Cliente.class);
		
		try {
			listaRetorno = query.getResultList();
		}catch(NoResultException e) {
			listaRetorno = new ArrayList();
		}
		
		return listaRetorno;
	}
	
	@Transactional
	private void inserirOuAtualizar(String nomeSql, Cliente cliente) {
		Query query = em.createNamedQuery(nomeSql);
		
		query.setParameter("id", cliente.getId());
		query.setParameter("nome", cliente.getNome());
		query.setParameter("cpf", cliente.getCpf());
		query.setParameter("endereco", cliente.getEndereco());
		query.setParameter("email", cliente.getEmail());
		query.setParameter("contato", cliente.getContato());
		
		query.executeUpdate();
	}
}
