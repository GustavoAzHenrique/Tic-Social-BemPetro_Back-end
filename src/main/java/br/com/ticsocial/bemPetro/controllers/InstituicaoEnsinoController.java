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

import br.com.ticsocial.bemPetro.dtos.InstituicaoEnsinoDTO;
import br.com.ticsocial.bemPetro.exceptions.InstituicaoEnsinoExistenteException;
import br.com.ticsocial.bemPetro.exceptions.InstituicaoEnsinoInexistenteException;
import br.com.ticsocial.bemPetro.mappers.InstituicaoEnsinoMapper;
import br.com.ticsocial.bemPetro.models.InstituicaoEnsino;
import br.com.ticsocial.bemPetro.services.InstituicaoEnsinoService;

@RestController
@RequestMapping("/instituicaoEnsino")
public class InstituicaoEnsinoController {
    @Autowired
	InstituicaoEnsinoService instituicaoEnsinoService;
	
	@Autowired
	InstituicaoEnsinoMapper instituicaoEnsinoMapper;
	
	@GetMapping
	/*
	@Operation(summary = "Busca todas as Atvidades economicas cadastradas no sistema.", responses = {
			@ApiResponse(responseCode = "200", description = "Sucesso. Retorna todas as categorias cadastradas no sistema.", content = @Content(mediaType = "application/json",  array = @ArraySchema(schema = @Schema(implementation = AtividadeEconomia.class)))),
			@ApiResponse(responseCode = "404", description = "Falha. Nenhuma Atvidade economica encontrada no sistema.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Falha. Erro inesperado.", content = @Content) })
			*/
	public ResponseEntity<List<InstituicaoEnsino>> findAllInstituicaoEnsino() {
		return new ResponseEntity<>(instituicaoEnsinoService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	/*
	@Operation(summary = "Busca uma Atvidade economica cadastrada através do seu id.", parameters = {
		@Parameter(name = "id", description = "Id da Atvidade economica desejada.") }, responses = {
			@ApiResponse(responseCode = "200", description = "Sucesso. Retorna a Atvidade economica.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AtividadeEconomia.class))),
			@ApiResponse(responseCode = "404", description = "Falha. Não há uma Atvidade economica cadastrada com o id fornecido.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Falha. Erro inesperado.", content = @Content) })
	*/
	public ResponseEntity<InstituicaoEnsino> findInstituicaoEnsinoById(@PathVariable Integer id) {
		return new ResponseEntity<>(instituicaoEnsinoService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	/*
	@Operation(summary = "Cadastra uma nova Atvidade economica no sistema.", responses = {
			@ApiResponse(responseCode = "200", description = "Sucesso. Cadastra uma nova Atvidade economica no sistema e retorna seus dados.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AtividadeEconomia.class))),
			@ApiResponse(responseCode = "400", description = "Falha. Erro na requisição.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Falha. Erro inesperado.", content = @Content) })
	*/
	public ResponseEntity<InstituicaoEnsino> saveInstituicaoEnsino(@Valid @RequestBody InstituicaoEnsinoDTO dto) throws InstituicaoEnsinoExistenteException {
		return new ResponseEntity<>(instituicaoEnsinoService.save(instituicaoEnsinoMapper.InstEnsDtoToInstEns(dto)), HttpStatus.CREATED);
	}


	@DeleteMapping("/{id}")
	/*
	@Operation(summary = "Exclui uma Atvidade economica cadastrada através do seu id.", responses = {
			@ApiResponse(responseCode = "200", description = "Sucesso. Exclui a Atvidade economica que possui o id fornecido.", content = @Content),
			@ApiResponse(responseCode = "404", description = "Falha. Nenhuma Atvidade economica encontrada no sistema com o id fornecido.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Falha. Erro inesperado.", content = @Content) })
	*/
	public ResponseEntity<String> deleteInstituicaoEnsinoById(@PathVariable Integer id) {
		instituicaoEnsinoService.deletePorId(id);
		
		return new ResponseEntity<>("A Atvidade economica de id = " + id + " foi excluída com sucesso.", HttpStatus.OK);
	}
	
	
	
	@PutMapping("/{id}")
	/*
	@Operation(summary = "Atualiza uma Instituicao Ensino cadastrada.", responses = {
			@ApiResponse(responseCode = "200", description = "Sucesso. Atualiza a Atvidade economica que possui o id fornecido e retorna os seus dados.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Categoria.class))),
			@ApiResponse(responseCode = "400", description = "Falha. Erro na requisição.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "404", description = "Falha. Nenhuma Atvidade economica encontrada no sistema com o id fornecido.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Falha. Erro inesperado.", content = @Content) })
			*/
	public ResponseEntity<InstituicaoEnsino> updateInstituicaoEnsino(@Valid @RequestBody InstituicaoEnsinoDTO atividadeEconomiaDTO, @PathVariable Integer id) throws InstituicaoEnsinoInexistenteException {
		return new ResponseEntity<>(instituicaoEnsinoService.update(instituicaoEnsinoMapper.InstEnsDtoToInstEns(atividadeEconomiaDTO),id), HttpStatus.OK);
	}
}
