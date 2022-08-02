package br.com.ticsocial.bemPetro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ticsocial.bemPetro.dtos.PerfilPessoaDTO;
import br.com.ticsocial.bemPetro.exceptions.PerfilPessoaExistenteException;
import br.com.ticsocial.bemPetro.mappers.PerfilPessoaMapper;
import br.com.ticsocial.bemPetro.models.PerfilPessoa;
import br.com.ticsocial.bemPetro.services.PerfilPessoaService;

@RestController
@RequestMapping("/perfilPessoa")
public class PerfilPessoaController {
	
	@Autowired
	PerfilPessoaService perfilPessoaService;
	
	@Autowired
	PerfilPessoaMapper perfilPessoaMapper;
	
	
	@GetMapping
	public ResponseEntity<List<PerfilPessoa>> findAll() {
		return new ResponseEntity<>(perfilPessoaService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
    public ResponseEntity<PerfilPessoa> savePerfilPessoa(@RequestBody PerfilPessoaDTO dto) throws PerfilPessoaExistenteException{
    	PerfilPessoa perfilPessoa = perfilPessoaMapper.PerfilPessoaDtoToPerfilPessoa(dto);
        return new ResponseEntity<>(perfilPessoaService.save(perfilPessoa), HttpStatus.CREATED);
    }
}
