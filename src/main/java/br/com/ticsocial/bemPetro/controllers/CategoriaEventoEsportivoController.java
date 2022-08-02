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

import br.com.ticsocial.bemPetro.dtos.CategoriaEventoEsportivoDTO;
import br.com.ticsocial.bemPetro.exceptions.CategoriaEventoEsportivoExistenteException;
import br.com.ticsocial.bemPetro.exceptions.CategoriaEventoEsportivoInexistenteException;
import br.com.ticsocial.bemPetro.mappers.CategoriaEventoEsportivoMapper;
import br.com.ticsocial.bemPetro.models.CategoriaEventoEsportivo;
import br.com.ticsocial.bemPetro.services.CategoriaEventoEsportivoService;

@RestController
@RequestMapping("/catEventoEsport")
public class CategoriaEventoEsportivoController {
	@Autowired
	CategoriaEventoEsportivoService categoriaEventoEsportivoService;

	@Autowired
	CategoriaEventoEsportivoMapper categoriaEventoEsportivoMapper;

	@GetMapping
	public ResponseEntity<List<CategoriaEventoEsportivo>> findAllCategoriaEventoEsportivo() {
		return new ResponseEntity<>(categoriaEventoEsportivoService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaEventoEsportivo> findCategoriaEventoEsportivoById(@PathVariable Integer id) {
		return new ResponseEntity<>(categoriaEventoEsportivoService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CategoriaEventoEsportivo> saveCategoriaEventoEsportivo(
			@Valid @RequestBody CategoriaEventoEsportivoDTO categoriaEventoEsportivoDTO)
			throws CategoriaEventoEsportivoExistenteException {
		return new ResponseEntity<>(categoriaEventoEsportivoService
				.save(categoriaEventoEsportivoMapper.catEventoEsportDtoTocatEventoEsport(categoriaEventoEsportivoDTO)),
				HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTipoEventoById(@PathVariable Integer id) {
		categoriaEventoEsportivoService.deletePorId(id);

		return new ResponseEntity<>("A Atvidade economica de id = " + id + " foi excluída com sucesso.", HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoriaEventoEsportivo> updateCategoriaEventoEsportivo(
			@Valid @RequestBody CategoriaEventoEsportivoDTO categoriaEventoEsportivoDTO, @PathVariable Integer id)
			throws CategoriaEventoEsportivoInexistenteException {
		return new ResponseEntity<>(categoriaEventoEsportivoService.update(
				categoriaEventoEsportivoMapper.catEventoEsportDtoTocatEventoEsport(categoriaEventoEsportivoDTO), id),
				HttpStatus.OK);
	}
}
