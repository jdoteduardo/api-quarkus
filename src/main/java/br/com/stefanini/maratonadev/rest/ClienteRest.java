package br.com.stefanini.maratonadev.rest;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.service.ClienteService;

@Path("cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteRest {
	@Inject
    ClienteService service;
	
	@Inject
	Validator validator;

	@GET
	@Path("")
	@Operation(summary = "Listar pessoas",
	description = "Retorna uma lista de  Todo.class")
	@APIResponse(responseCode = "201",
	description = "lista de pessoas",
	content = {
			@Content(mediaType =  "application/json",
			schema = @Schema(implementation = ClienteDto.class, type = SchemaType.ARRAY))
			}
	)
	public Response listar() {
		
		return Response
				.status(Response.Status.OK)
				.entity(service.listar())
				.build();
	}
	
	@POST
	@Path("")
	@Operation(summary = "Incluir uma tarefa",
	description = "Incluir uma tarefa")
	@APIResponse(responseCode = "201",
	description = "tarefa",
	content = {
			@Content(mediaType =  "application/json",
			schema = @Schema(implementation = ClienteDto.class))
			}
	)
	public Response incluir(ClienteDto cliente) {
		
		Set<ConstraintViolation<ClienteDto>> erros
		= validator.validate(cliente);
		
		if(erros.isEmpty()) {
			service.inserir(cliente);
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
}
