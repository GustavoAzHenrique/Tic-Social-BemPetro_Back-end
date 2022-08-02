package br.com.ticsocial.bemPetro.controllers;

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

import br.com.ticsocial.bemPetro.dtos.PessoaFisicaDTO;
import br.com.ticsocial.bemPetro.dtos.PessoaJuridicaDTO;
import br.com.ticsocial.bemPetro.dtos.PessoaOutDTO;
import br.com.ticsocial.bemPetro.exceptions.CnpjExistenteException;
import br.com.ticsocial.bemPetro.exceptions.EmailExistenteException;
import br.com.ticsocial.bemPetro.exceptions.GrauInstrucaoInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.InstituicaoEnsinoInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.PerfilPessoaInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.PessoaInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.TelefoneInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.UfInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.ativEconomicaInexistenteException;
import br.com.ticsocial.bemPetro.mappers.PessoaMapper;
import br.com.ticsocial.bemPetro.models.Pessoa;
import br.com.ticsocial.bemPetro.services.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    
    @Autowired
    PessoaService pessoaService;
    
    @Autowired
    PessoaMapper pessoaMapper;
    

    @GetMapping("/{id}")
    public ResponseEntity<PessoaOutDTO> findPessoaById(@PathVariable Integer id) throws PessoaInexistenteException{
        PessoaOutDTO pessoa = pessoaMapper.pessoaToPessoaOutDto(pessoaService.findPessoaById(id));
        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }
    
    @PostMapping("/juridica")
    public ResponseEntity<String> savePessoaJuridica(@Valid @RequestBody PessoaJuridicaDTO pessoaDTO) throws UfInexistenteException, ativEconomicaInexistenteException, PerfilPessoaInexistenteException, CnpjExistenteException, EmailExistenteException{
    	Pessoa pessoa = pessoaMapper.pessoaJuridicaDtoToPessoa(pessoaDTO);
    	pessoaService.savePessoa(pessoa);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PutMapping("/juridica/{id}")
    public ResponseEntity<String> updatePessoaJuridica(@Valid @RequestBody PessoaJuridicaDTO pessoaDTO, @PathVariable Integer id) throws UfInexistenteException, ativEconomicaInexistenteException, PerfilPessoaInexistenteException, PessoaInexistenteException, TelefoneInexistenteException, EmailExistenteException {
    	Pessoa pessoa = pessoaMapper.pessoaJuridicaDtoToPessoa(pessoaDTO);
    	pessoaService.updatePessoaJuridica(pessoa, id);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/fisica")
    public ResponseEntity<String> savePessoaFisica(@Valid @RequestBody PessoaFisicaDTO pessoaDTO) throws UfInexistenteException, PerfilPessoaInexistenteException, EmailExistenteException, InstituicaoEnsinoInexistenteException, GrauInstrucaoInexistenteException{
    	Pessoa pessoa = pessoaMapper.pessoaFisicaDtoToPessoa(pessoaDTO);
    	pessoaService.savePessoaFisica(pessoa);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PutMapping("/fisica/{id}")
    public ResponseEntity<String> updatePessoaFisica(@Valid @RequestBody PessoaFisicaDTO pessoaDTO, @PathVariable Integer id) throws UfInexistenteException, PerfilPessoaInexistenteException, PessoaInexistenteException, TelefoneInexistenteException, InstituicaoEnsinoInexistenteException, GrauInstrucaoInexistenteException, EmailExistenteException {
    	Pessoa pessoa = pessoaMapper.pessoaFisicaDtoToPessoa(pessoaDTO);
    	pessoaService.updatePessoaFisica(pessoa, id);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePessoa(@PathVariable Integer id) throws PessoaInexistenteException {
    	pessoaService.deletePessoa(id);
    	return new ResponseEntity<String>(HttpStatus.OK);
    }
}
