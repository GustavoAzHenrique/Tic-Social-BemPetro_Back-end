package br.com.ticsocial.bemPetro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ticsocial.bemPetro.dtos.TipoJornadaDTO;
import br.com.ticsocial.bemPetro.exceptions.JornadaExistenteException;
import br.com.ticsocial.bemPetro.exceptions.JornadaInexistenteException;
import br.com.ticsocial.bemPetro.mappers.TipoJornadaMapper;
import br.com.ticsocial.bemPetro.models.TipoJornada;
import br.com.ticsocial.bemPetro.services.TipoJornadaService;

@RestController
@RequestMapping("/tipoJornada")
public class TipoJornadaController {
	
	@Autowired
	TipoJornadaService tipoJornadaService;
	
	@Autowired
	TipoJornadaMapper tipoJornadaMapper;
	
	
	@GetMapping
	public ResponseEntity<List<TipoJornada>> findAll() {
		return new ResponseEntity<>(tipoJornadaService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoJornada> find(@PathVariable Integer id) throws JornadaInexistenteException {
		return new ResponseEntity<>(tipoJornadaService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
    public ResponseEntity<TipoJornada> save(@RequestBody TipoJornadaDTO dto) throws JornadaExistenteException {
		TipoJornada tipoJornada = tipoJornadaMapper.tipoJornadaDtoToTipoJornada(dto);
        return new ResponseEntity<>(tipoJornadaService.save(tipoJornada), HttpStatus.CREATED);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) throws JornadaInexistenteException {
		tipoJornadaService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
