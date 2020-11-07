package br.com.stefanini.maratonadev.model.parser;

import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.model.Cliente;

public class ClienteParser {
	public static ClienteParser get(){
        return  new ClienteParser();
    }
	
	public Cliente entidade(ClienteDto dto) {
		Cliente entidade = new Cliente();
		
		entidade.setId(dto.getId());
        entidade.setNome(dto.getNome());
        entidade.setCpf(dto.getCpf());
        entidade.setEndereco(dto.getEndereco());
        entidade.setEmail(dto.getEmail());
        entidade.setContato(dto.getContato());
        
        return entidade;
	}
	
    public ClienteDto dto(Cliente entidade){
        ClienteDto dto = new ClienteDto();

        dto.setId(entidade.getId());
        dto.setNome(entidade.getNome());
        dto.setCpf(entidade.getCpf());
        dto.setEndereco(entidade.getEndereco());
        dto.setEmail(entidade.getEmail());
        dto.setContato(entidade.getContato());
        
        return dto;
    }
}