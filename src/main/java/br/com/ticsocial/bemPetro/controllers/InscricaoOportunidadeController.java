package br.com.ticsocial.bemPetro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ticsocial.bemPetro.exceptions.OportunidadeInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.PessoaInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.PessoaJaInscritaException;
import br.com.ticsocial.bemPetro.services.InscricaoOportunidadeService;

@RestController
@RequestMapping("/inscricaoOportunidade")
public class InscricaoOportunidadeController {
	
	@Autowired
	InscricaoOportunidadeService inscricaoService;
	
	
	@PostMapping("/{oporId}/inscrever")
    public ResponseEntity<String> inscrever(@PathVariable Integer oporId) throws PessoaInexistenteException, OportunidadeInexistenteException, PessoaJaInscritaException {
		Integer userId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		inscricaoService.inscrever(oporId, userId);
		return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
	@GetMapping("/{oporId}/isInscrito")
	public ResponseEntity<Boolean> isInscrito(@PathVariable Integer oporId) throws PessoaInexistenteException, OportunidadeInexistenteException {
		Integer userId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		return new ResponseEntity<>(inscricaoService.isInscrito(oporId, userId), HttpStatus.OK);
    }
}
