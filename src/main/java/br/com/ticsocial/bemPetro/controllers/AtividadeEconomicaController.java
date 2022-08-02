package br.com.ticsocial.bemPetro.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ticsocial.bemPetro.dtos.AtividadeEconomicaDTO;
import br.com.ticsocial.bemPetro.exceptions.AtivEconomicaExistenteException;
import br.com.ticsocial.bemPetro.mappers.AtividadeEconomicaMapper;
import br.com.ticsocial.bemPetro.models.AtividadeEconomica;
import br.com.ticsocial.bemPetro.services.AtividadeEconomicaService;

@RestController
@RequestMapping("/atividadeEconomica")
public class AtividadeEconomicaController{
	
	@Autowired
	AtividadeEconomicaService atividadeEconomicaService;
	
	@Autowired
	AtividadeEconomicaMapper atividadeEconomicaMapper;
	
	@GetMapping
	/*
	@Operation(summary = "Busca todas as Atvidades economicas cadastradas no sistema.", responses = {
			@ApiResponse(responseCode = "200", description = "Sucesso. Retorna todas as categorias cadastradas no sistema.", content = @Content(mediaType = "application/json",  array = @ArraySchema(schema = @Schema(implementation = AtividadeEconomia.class)))),
			@ApiResponse(responseCode = "404", description = "Falha. Nenhuma Atvidade economica encontrada no sistema.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Falha. Erro inesperado.", content = @Content) })
			*/
	public ResponseEntity<List<AtividadeEconomica>> findAllAtividadeEconomia() {
		return new ResponseEntity<>(atividadeEconomicaService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	/*
	@Operation(summary = "Busca uma Atvidade economica cadastrada através do seu id.", parameters = {
		@Parameter(name = "id", description = "Id da Atvidade economica desejada.") }, responses = {
			@ApiResponse(responseCode = "200", description = "Sucesso. Retorna a Atvidade economica.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AtividadeEconomia.class))),
			@ApiResponse(responseCode = "404", description = "Falha. Não há uma Atvidade economica cadastrada com o id fornecido.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Falha. Erro inesperado.", content = @Content) })
	*/
	public ResponseEntity<AtividadeEconomica> findAtividadeEconomiaById(@PathVariable Integer id) {
		return new ResponseEntity<>(atividadeEconomicaService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	/*
	@Operation(summary = "Cadastra uma nova Atvidade economica no sistema.", responses = {
			@ApiResponse(responseCode = "200", description = "Sucesso. Cadastra uma nova Atvidade economica no sistema e retorna seus dados.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AtividadeEconomia.class))),
			@ApiResponse(responseCode = "400", description = "Falha. Erro na requisição.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Falha. Erro inesperado.", content = @Content) })
	*/
	public ResponseEntity<AtividadeEconomica> saveAtividadeEconomia(@Valid @RequestBody AtividadeEconomicaDTO dto) throws AtivEconomicaExistenteException {
		return new ResponseEntity<>(atividadeEconomicaService.save(atividadeEconomicaMapper.AtiEcoDtoToAtiEco(dto)), HttpStatus.CREATED);
	}


	@DeleteMapping("/{id}")
	/*
	@Operation(summary = "Exclui uma Atvidade economica cadastrada através do seu id.", responses = {
			@ApiResponse(responseCode = "200", description = "Sucesso. Exclui a Atvidade economica que possui o id fornecido.", content = @Content),
			@ApiResponse(responseCode = "404", description = "Falha. Nenhuma Atvidade economica encontrada no sistema com o id fornecido.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Falha. Erro inesperado.", content = @Content) })
	*/
	public ResponseEntity<String> deleteAtividadeEconomiaById(@PathVariable Integer id) {
		atividadeEconomicaService.deletePorId(id);
		
		return new ResponseEntity<>("A Atvidade economica de id = " + id + " foi excluída com sucesso.", HttpStatus.OK);
	}
	
	
	
	@PutMapping
	/*
	@Operation(summary = "Atualiza uma Atvidade economica cadastrada.", responses = {
			@ApiResponse(responseCode = "200", description = "Sucesso. Atualiza a Atvidade economica que possui o id fornecido e retorna os seus dados.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Categoria.class))),
			@ApiResponse(responseCode = "400", description = "Falha. Erro na requisição.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "404", description = "Falha. Nenhuma Atvidade economica encontrada no sistema com o id fornecido.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Falha. Erro inesperado.", content = @Content) })
			*/
	public ResponseEntity<AtividadeEconomica> updateAtividadeEconomia(@Valid @RequestBody AtividadeEconomica atividadeEconomia) {
		return new ResponseEntity<>(atividadeEconomicaService.update(atividadeEconomia), HttpStatus.OK);
	}

}