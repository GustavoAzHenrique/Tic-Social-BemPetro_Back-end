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

import br.com.ticsocial.bemPetro.dtos.TelefoneDTO;
import br.com.ticsocial.bemPetro.exceptions.TelefoneInexistenteException;
import br.com.ticsocial.bemPetro.mappers.TelefoneMapper;
import br.com.ticsocial.bemPetro.models.Telefone;
import br.com.ticsocial.bemPetro.services.TelefoneService;

@RestController
@RequestMapping("/telefone")
public class TelefoneController {
	
	@Autowired
	TelefoneService telefoneService;
	
	@Autowired
	TelefoneMapper telefoneMapper;
	
	
	@PutMapping("/{id}")
    public ResponseEntity<Telefone> updatePessoaFisica(@Valid @RequestBody TelefoneDTO telefoneDTO, @PathVariable Integer id) throws TelefoneInexistenteException {
    	Telefone telefone = telefoneMapper.telefoneDtoToTelefone(telefoneDTO);
    	return new ResponseEntity<>(telefoneService.updateTelefone(telefone, id), HttpStatus.OK);
    }
}
