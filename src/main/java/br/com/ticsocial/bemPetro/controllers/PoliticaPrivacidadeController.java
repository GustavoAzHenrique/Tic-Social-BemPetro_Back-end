package br.com.ticsocial.bemPetro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ticsocial.bemPetro.models.PoliticaPrivacidade;
import br.com.ticsocial.bemPetro.services.PoliticaPrivacidadeService;

@RestController
@RequestMapping("/politicaPrivacidade")
public class PoliticaPrivacidadeController {
	
	@Autowired
	PoliticaPrivacidadeService politicaPrivacidadeService;
	
	
	@GetMapping
	public ResponseEntity<List<PoliticaPrivacidade>> findAll() {
		return new ResponseEntity<List<PoliticaPrivacidade>>(politicaPrivacidadeService.findAll(), HttpStatus.OK);
	}
}
