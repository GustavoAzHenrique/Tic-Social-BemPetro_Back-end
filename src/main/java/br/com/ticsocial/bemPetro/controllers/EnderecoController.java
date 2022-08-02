package br.com.ticsocial.bemPetro.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ticsocial.bemPetro.dtos.EnderecoDTO;
import br.com.ticsocial.bemPetro.exceptions.EnderecoInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.UfInexistenteException;
import br.com.ticsocial.bemPetro.mappers.EnderecoMapper;
import br.com.ticsocial.bemPetro.models.Endereco;
import br.com.ticsocial.bemPetro.services.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	EnderecoService enderecoService;
	
	@Autowired
	EnderecoMapper enderecoMapper;
	
	
	@PutMapping("/{id}")
    public ResponseEntity<Endereco> updatePessoaFisica(@Valid @RequestBody EnderecoDTO enderecoDTO, @PathVariable Integer id) throws UfInexistenteException, EnderecoInexistenteException {
    	Endereco endereco = enderecoMapper.enderecoDtoToEndereco(enderecoDTO);
    	return new ResponseEntity<>(enderecoService.atualizar(endereco, id), HttpStatus.OK);
    }
}
