package br.com.ticsocial.bemPetro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ticsocial.bemPetro.dtos.RecuperarSenhaDTO;
import br.com.ticsocial.bemPetro.exceptions.EmailInexistenteException;
import br.com.ticsocial.bemPetro.services.RecuperarSenhaService;

@RestController
@RequestMapping("/recuperarSenha")
public class RecuperarSenhaController {
	
	@Autowired
	RecuperarSenhaService recuperarSenhaService;
	
	
	@PutMapping
	public ResponseEntity<String> recuperarSenha(@RequestBody RecuperarSenhaDTO dto) throws EmailInexistenteException {
		recuperarSenhaService.recuperarSenha(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
