package br.com.stefanini.maratonadev.rest;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.com.stefanini.maratonadev.dto.AluguelDto;
import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.service.AluguelService;
import br.com.stefanini.maratonadev.service.ClienteService;

@Path("aluguel")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AluguelRest {
	@Inject
    AluguelService service;
	
	@Inject
	Validator validator;
	
	@POST
	@Path("")
	@Operation(summary = "Incluir um aluguel",
	description = "Incluir um aluguel")
	@APIResponse(responseCode = "201",
	description = "aluguel",
	content = {
			@Content(mediaType =  "application/json",
			schema = @Schema(implementation = AluguelDto.class))
			}
	)
	public Response incluir(AluguelDto aluguel) {
		
		Set<ConstraintViolation<AluguelDto>> erros
		= validator.validate(aluguel);
		
		if(erros.isEmpty()) {
			service.inserir(aluguel);
		}else {
			List<String> listaErros = erros.stream()
			.map(ConstraintViolation::getMessage)
			.collect(Collectors.toList());
			throw new NotFoundException(listaErros.get(0));
			
		}
		
		
		return Response
				.status(Response.Status.CREATED)
				.build();
	}
	
	@PUT
	@Path("{id}")
	@Operation(summary = "Editar um ALUGUEL",
	description = "Editar um aluguel com base no ID")
	@APIResponse(responseCode = "200",
	description = "aluguel",
	content = {
			@Content(mediaType =  "application/json",
			schema = @Schema(implementation = AluguelDto.class))
			}
	)
	public Response atualizar(@PathParam("id") Long id, AluguelDto aluguel) {
		service.atualizar(id, aluguel);
		return Response
				.status(Response.Status.OK)
				.build();
	}
}
