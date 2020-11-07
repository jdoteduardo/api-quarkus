package br.com.stefanini.maratonadev.model.parser;

import br.com.stefanini.maratonadev.dao.AlguelDao;
import br.com.stefanini.maratonadev.dto.AluguelDto;
import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.model.Aluguel;
import br.com.stefanini.maratonadev.model.Cliente;

public class AluguelParser {
	public static AluguelParser get(){
        return  new AluguelParser();
    }
	
	public Aluguel entidade(AluguelDto dto) {
		Aluguel entidade = new Aluguel();
		
		entidade.setId(dto.getId());
        entidade.setCliente(dto.getCliente());
        entidade.setCarro(dto.getCarro());
        entidade.setDataAluguel(dto.getDataAluguel());
        entidade.setAlugado(dto.getAlugado());
        
        return entidade;
	}
	
    public AluguelDto dto(Aluguel entidade){
        AluguelDto dto = new AluguelDto();

        dto.setId(entidade.getId());
        dto.setCliente(entidade.getCliente());
        dto.setCarro(entidade.getCarro());
        dto.setDataAluguel(entidade.getDataAluguel());
        dto.setAlugado(entidade.getAlugado());
        
        return dto;
    }
}
