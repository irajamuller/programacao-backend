package br.com.store.backend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.store.backend.model.UnidadeFederativa;
import br.com.store.backend.service.UnidadeFederativaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/unidade-federativa")
@Tag(name = "Unidade Federativa", description = "Operações básicas para a Unidade Federativa")
public class UnidadeFederativaController {
	
	@Autowired
	private UnidadeFederativaService unidadeFederativaService;
	
	@GetMapping
	@Operation(summary = "Obter lista de UFs", description = "Obtém uma lista de UFs podendo filtrar por sigla")
	@Parameters({
		@Parameter(name = "sigla", description = "Sigla da Unidade Federativa", example = "RS", required = false)
	})
	@ApiResponse(responseCode = "200", description = "Lista de Unidades Federativas")
	public List<UnidadeFederativa> getAll(@RequestParam(required = false) String sigla) {
		return unidadeFederativaService.getAll(sigla);
	}
	
	@GetMapping("/{id}")
	@Parameters({
		@Parameter(name = "id", description = "UUID da Unidade Federativa")
	})
	@ApiResponse(responseCode = "200", description = "Dados da Unidade Federativa")
	public UnidadeFederativa getOne(@PathVariable UUID id) {
		return unidadeFederativaService.getOne(id);
	}

	@PostMapping
	@ApiResponse(responseCode = "200", description = "Unidade Federativa cadastrada com sucesso")
	@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Objeto Unidade Federativa", required = true)
	public void post(@RequestBody UnidadeFederativa unidadeFederativa) {
		unidadeFederativaService.save(unidadeFederativa);
	}
	
	@PutMapping
	@ApiResponse(responseCode = "200", description = "Unidade Federativa atualizada com sucesso")
	@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Objeto Unidade Federativa", required = true)
	public void put(@RequestBody UnidadeFederativa unidadeFederativa) {
		unidadeFederativaService.save(unidadeFederativa);
	}

	@DeleteMapping("/{id}")
	@ApiResponse(responseCode = "200", description = "Unidade Federativa excluída com sucesso")
	@Parameters({
		@Parameter(name = "id", description = "UUID da Unidade Federativa")
	})
	public void delete(@PathVariable UUID id) {
		unidadeFederativaService.delete(id);
	}
	
}
