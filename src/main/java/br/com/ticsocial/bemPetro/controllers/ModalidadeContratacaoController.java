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

import br.com.ticsocial.bemPetro.dtos.ModalidadeContratacaoDTO;
import br.com.ticsocial.bemPetro.exceptions.ModalidadeExistenteException;
import br.com.ticsocial.bemPetro.exceptions.ModalidadeInexistenteException;
import br.com.ticsocial.bemPetro.mappers.ModalidadeContratacaoMapper;
import br.com.ticsocial.bemPetro.models.ModalidadeContratacao;
import br.com.ticsocial.bemPetro.services.ModalidadeContratacaoService;

@RestController
@RequestMapping("/modalidadeContratacao")
public class ModalidadeContratacaoController {
	
	@Autowired
	ModalidadeContratacaoService modalidadeContratacaoService;
	
	@Autowired
	ModalidadeContratacaoMapper modalidadeContratacaoMapper;
	
	
	@GetMapping
	public ResponseEntity<List<ModalidadeContratacao>> findAll() {
		return new ResponseEntity<>(modalidadeContratacaoService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ModalidadeContratacao> find(@PathVariable Integer id) throws ModalidadeInexistenteException {
		return new ResponseEntity<>(modalidadeContratacaoService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
    public ResponseEntity<ModalidadeContratacao> save(@RequestBody ModalidadeContratacaoDTO dto) throws ModalidadeExistenteException {
		ModalidadeContratacao modalidadeContratacao = modalidadeContratacaoMapper.ModContDtoToModCont(dto);
        return new ResponseEntity<>(modalidadeContratacaoService.save(modalidadeContratacao), HttpStatus.CREATED);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) throws ModalidadeInexistenteException {
		modalidadeContratacaoService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
