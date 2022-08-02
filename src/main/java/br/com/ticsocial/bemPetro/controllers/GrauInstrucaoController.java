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

import br.com.ticsocial.bemPetro.dtos.GrauInstrucaoDTO;
import br.com.ticsocial.bemPetro.exceptions.GrauInstrucaoException;
import br.com.ticsocial.bemPetro.exceptions.GrauInstrucaoInexistenteException;
import br.com.ticsocial.bemPetro.mappers.GrauInstrucaoMapper;
import br.com.ticsocial.bemPetro.models.GrauInstrucao;
import br.com.ticsocial.bemPetro.services.GrauInstrucaoService;



@RestController
@RequestMapping("/grauInstrucao")
public class GrauInstrucaoController {
	@Autowired
	GrauInstrucaoService grauInstrucaoService;
	
	@Autowired
	GrauInstrucaoMapper grauInstrucaoMapper;
	
	@GetMapping
	/*
	@Operation(summary = "Busca todas as Atvidades economicas cadastradas no sistema.", responses = {
			@ApiResponse(responseCode = "200", description = "Sucesso. Retorna todas as categorias cadastradas no sistema.", content = @Content(mediaType = "application/json",  array = @ArraySchema(schema = @Schema(implementation = AtividadeEconomia.class)))),
			@ApiResponse(responseCode = "404", description = "Falha. Nenhuma Atvidade economica encontrada no sistema.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Falha. Erro inesperado.", content = @Content) })
			*/
	public ResponseEntity<List<GrauInstrucao>> findAllAtividadeEconomia() {
		return new ResponseEntity<>(grauInstrucaoService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	/*
	@Operation(summary = "Busca uma Atvidade economica cadastrada através do seu id.", parameters = {
		@Parameter(name = "id", description = "Id da Atvidade economica desejada.") }, responses = {
			@ApiResponse(responseCode = "200", description = "Sucesso. Retorna a Atvidade economica.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AtividadeEconomia.class))),
			@ApiResponse(responseCode = "404", description = "Falha. Não há uma Atvidade economica cadastrada com o id fornecido.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Falha. Erro inesperado.", content = @Content) })
	*/
	public ResponseEntity<GrauInstrucao> findAtividadeEconomiaById(@PathVariable Integer id) throws GrauInstrucaoInexistenteException {
		return new ResponseEntity<>(grauInstrucaoService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	/*
	@Operation(summary = "Cadastra uma nova Atvidade economica no sistema.", responses = {
			@ApiResponse(responseCode = "200", description = "Sucesso. Cadastra uma nova Atvidade economica no sistema e retorna seus dados.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AtividadeEconomia.class))),
			@ApiResponse(responseCode = "400", description = "Falha. Erro na requisição.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Falha. Erro inesperado.", content = @Content) })
	*/
	public ResponseEntity<GrauInstrucao> saveAtividadeEconomia(@Valid @RequestBody GrauInstrucaoDTO dto) throws GrauInstrucaoException {
		return new ResponseEntity<>(grauInstrucaoService.save(grauInstrucaoMapper.GrauInstrucaoDtoToGrauInstrucao(dto)), HttpStatus.CREATED);
	}


	@DeleteMapping("/{id}")
	/*
	@Operation(summary = "Exclui uma Atvidade economica cadastrada através do seu id.", responses = {
			@ApiResponse(responseCode = "200", description = "Sucesso. Exclui a Atvidade economica que possui o id fornecido.", content = @Content),
			@ApiResponse(responseCode = "404", description = "Falha. Nenhuma Atvidade economica encontrada no sistema com o id fornecido.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Falha. Erro inesperado.", content = @Content) })
	*/
	public ResponseEntity<String> deleteAtividadeEconomiaById(@PathVariable Integer id) {
		grauInstrucaoService.deletePorId(id);
		
		return new ResponseEntity<>("A Atvidade economica de id = " + id + " foi excluída com sucesso.", HttpStatus.OK);
	}
	
	
	
	@PutMapping("/{id}")
	/*
	@Operation(summary = "Atualiza uma Atvidade economica cadastrada.", responses = {
			@ApiResponse(responseCode = "200", description = "Sucesso. Atualiza a Atvidade economica que possui o id fornecido e retorna os seus dados.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Categoria.class))),
			@ApiResponse(responseCode = "400", description = "Falha. Erro na requisição.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "404", description = "Falha. Nenhuma Atvidade economica encontrada no sistema com o id fornecido.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Falha. Erro inesperado.", content = @Content) })
			*/
	public ResponseEntity<GrauInstrucao> updateAtividadeEconomia(@Valid @RequestBody GrauInstrucaoDTO grauInstrucaoDTO, @PathVariable Integer id) throws GrauInstrucaoInexistenteException {
		return new ResponseEntity<>(grauInstrucaoService.update(grauInstrucaoMapper.GrauInstrucaoDtoToGrauInstrucao(grauInstrucaoDTO),id), HttpStatus.OK);
	}
	
}
