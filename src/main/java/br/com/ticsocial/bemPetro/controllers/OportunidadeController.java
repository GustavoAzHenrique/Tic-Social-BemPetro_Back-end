package br.com.ticsocial.bemPetro.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ticsocial.bemPetro.dtos.OportunidadeDTO;
import br.com.ticsocial.bemPetro.dtos.OportunidadeOutDTO;
import br.com.ticsocial.bemPetro.exceptions.JornadaInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.ModalidadeInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.OportunidadeInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.PessoaInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.StatusInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.UfInexistenteException;
import br.com.ticsocial.bemPetro.mappers.OportunidadeMapper;
import br.com.ticsocial.bemPetro.models.Oportunidade;
import br.com.ticsocial.bemPetro.services.OportunidadeService;

@RestController
@RequestMapping("/oportunidade")
public class OportunidadeController {
	
	@Autowired
	OportunidadeService oportunidadeService;
	
	@Autowired
	OportunidadeMapper oportunidadeMapper;
	
	
	@GetMapping()
	public ResponseEntity<List<OportunidadeOutDTO>> findAllActive() {
		List<OportunidadeOutDTO> oportunidades = oportunidadeService.findAllActive().stream().map(item -> oportunidadeMapper.oportunidadeToOportunidadeOutDto(item)).collect(Collectors.toList());
		return new ResponseEntity<>(oportunidades, HttpStatus.OK);
	}
	
	@GetMapping("/especifico")
	public ResponseEntity<List<OportunidadeOutDTO>> findAll() throws PessoaInexistenteException {
		List<OportunidadeOutDTO> oportunidades = oportunidadeService.findAll().stream().map(item -> oportunidadeMapper.oportunidadeToOportunidadeOutDto(item)).collect(Collectors.toList());
		return new ResponseEntity<>(oportunidades, HttpStatus.OK);
	}
	
	@GetMapping("/aprovados")
	public ResponseEntity<List<OportunidadeOutDTO>> findAllApproved() throws PessoaInexistenteException {
		Integer id = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		List<OportunidadeOutDTO> oportunidades = oportunidadeService.findAllApproved(id).stream().map(item -> oportunidadeMapper.oportunidadeToOportunidadeOutDto(item)).collect(Collectors.toList());
		return new ResponseEntity<>(oportunidades, HttpStatus.OK);
	}
	
	@GetMapping("/reprovados")
	public ResponseEntity<List<OportunidadeOutDTO>> findAllDisapproved() throws PessoaInexistenteException {
		Integer id = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		List<OportunidadeOutDTO> oportunidades = oportunidadeService.findAllDisapproved(id).stream().map(item -> oportunidadeMapper.oportunidadeToOportunidadeOutDto(item)).collect(Collectors.toList());
		return new ResponseEntity<>(oportunidades, HttpStatus.OK);
	}
	
	@GetMapping("/pendentes")
	public ResponseEntity<List<OportunidadeOutDTO>> findAllPending() {
		List<OportunidadeOutDTO> oportunidades = oportunidadeService.findAllPending().stream().map(item -> oportunidadeMapper.oportunidadeToOportunidadeOutDto(item)).collect(Collectors.toList());
		return new ResponseEntity<>(oportunidades, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OportunidadeOutDTO> find(@PathVariable Integer id) throws OportunidadeInexistenteException {
		OportunidadeOutDTO oportunidade = oportunidadeMapper.oportunidadeToOportunidadeOutDto(oportunidadeService.findById(id));
		return new ResponseEntity<>(oportunidade, HttpStatus.OK);
	}
	
	@PostMapping
    public ResponseEntity<String> save(@RequestBody OportunidadeDTO dto) throws ModalidadeInexistenteException, JornadaInexistenteException, UfInexistenteException, PessoaInexistenteException, StatusInexistenteException {
		Integer userId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		Oportunidade oportunidade = oportunidadeMapper.oportunidadeDtoToOportunidade(dto);
		
		oportunidadeService.save(oportunidade, userId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<String> updatePessoaFisica(@Valid @RequestBody OportunidadeDTO oportunidadeDTO, @PathVariable Integer id) throws ModalidadeInexistenteException, JornadaInexistenteException, UfInexistenteException, OportunidadeInexistenteException, PessoaInexistenteException, StatusInexistenteException {
    	Oportunidade oportunidade = oportunidadeMapper.oportunidadeDtoToOportunidade(oportunidadeDTO);
    	oportunidadeService.update(oportunidade, id);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@PutMapping("/{id}/aprovar")
    public ResponseEntity<String> aprovar(@PathVariable Integer id) throws OportunidadeInexistenteException, PessoaInexistenteException, StatusInexistenteException {
		Integer revisorId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		oportunidadeService.aprovar(id, revisorId);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@PutMapping("/{id}/reprovar")
    public ResponseEntity<String> reprovar(@PathVariable Integer id) throws OportunidadeInexistenteException, PessoaInexistenteException, StatusInexistenteException {
		Integer revisorId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		oportunidadeService.reprovar(id, revisorId);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@PutMapping("/{id}/pausar")
    public ResponseEntity<String> pausar(@PathVariable Integer id) throws OportunidadeInexistenteException, StatusInexistenteException {
		oportunidadeService.pausar(id);
    	return new ResponseEntity<>(HttpStatus.OK);
    }

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) throws OportunidadeInexistenteException {
		oportunidadeService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
