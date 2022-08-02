package br.com.ticsocial.bemPetro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ticsocial.bemPetro.models.TermoUso;
import br.com.ticsocial.bemPetro.services.TermoUsoService;

@RestController
@RequestMapping("/termoUso")
public class TermoUsoController {
	
	@Autowired
	TermoUsoService termoUsoService;
	
	
	@GetMapping
	public ResponseEntity<List<TermoUso>> findAll() {
		return new ResponseEntity<List<TermoUso>>(termoUsoService.findAll(), HttpStatus.OK);
	}
}
