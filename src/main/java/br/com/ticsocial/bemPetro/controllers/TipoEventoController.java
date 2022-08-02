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

import br.com.ticsocial.bemPetro.dtos.TipoEventoDTO;
import br.com.ticsocial.bemPetro.exceptions.TipoEventoExistenteException;
import br.com.ticsocial.bemPetro.exceptions.TipoEventoInexistenteException;
import br.com.ticsocial.bemPetro.mappers.TipoEventoMapper;
import br.com.ticsocial.bemPetro.models.TipoEvento;
import br.com.ticsocial.bemPetro.services.TipoEventoService;

@RestController
@RequestMapping("/tipoEvento")
public class TipoEventoController {
	@Autowired
	TipoEventoService tipoEventoService;
	
	@Autowired
	TipoEventoMapper tipoEventoMapper;
	
	@GetMapping
	public ResponseEntity<List<TipoEvento>> findAllTipoEvento() {
		return new ResponseEntity<>(tipoEventoService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoEvento> findTipoEventoById(@PathVariable Integer id) {
		return new ResponseEntity<>(tipoEventoService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<TipoEvento> saveTipoEvento(@Valid @RequestBody TipoEventoDTO tipoEventoDTO) throws TipoEventoExistenteException {
		return new ResponseEntity<>(tipoEventoService.save(tipoEventoMapper.TipoEventoDtoToTipoEvento(tipoEventoDTO)), HttpStatus.CREATED);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTipoEventoById(@PathVariable Integer id) {
		tipoEventoService.deletePorId(id);
		
		return new ResponseEntity<>("A Atvidade economica de id = " + id + " foi excluída com sucesso.", HttpStatus.OK);
	}
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<TipoEvento> updateTipoEvento(@Valid @RequestBody TipoEventoDTO tipoEventoDTO, @PathVariable Integer id) throws TipoEventoInexistenteException  {
		return new ResponseEntity<>(tipoEventoService.update(tipoEventoMapper.TipoEventoDtoToTipoEvento(tipoEventoDTO),id), HttpStatus.OK);
	}
}
