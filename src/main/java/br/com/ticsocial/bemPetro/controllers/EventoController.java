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

import br.com.ticsocial.bemPetro.dtos.EventoDTO;
import br.com.ticsocial.bemPetro.dtos.EventoOutDTO;
import br.com.ticsocial.bemPetro.exceptions.CategoriaEventoEsportivoInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.EventoInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.PessoaInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.StatusInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.TipoEventoInexistenteException;
import br.com.ticsocial.bemPetro.mappers.EventoMapper;
import br.com.ticsocial.bemPetro.models.Evento;
import br.com.ticsocial.bemPetro.services.EventoService;

@RestController
@RequestMapping("/evento")
public class EventoController {
	
	@Autowired
	EventoService eventoService;

	@Autowired
	EventoMapper eventoMapper;

	@GetMapping
	public ResponseEntity<List<EventoOutDTO>> findAllActive() {
		List<EventoOutDTO> eventos = eventoService.findAllActive().stream().map(item -> eventoMapper.eventoToEventoOutDto(item)).collect(Collectors.toList());
		return new ResponseEntity<>(eventos, HttpStatus.OK);
	}
	
	@GetMapping("/especifico")
	public ResponseEntity<List<EventoOutDTO>> findAll() throws PessoaInexistenteException {
		List<EventoOutDTO> eventos = eventoService.findAll().stream().map(item -> eventoMapper.eventoToEventoOutDto(item)).collect(Collectors.toList());
		return new ResponseEntity<>(eventos, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EventoOutDTO> findEventoById(@PathVariable Integer id) throws EventoInexistenteException {
		EventoOutDTO evento = eventoMapper.eventoToEventoOutDto(eventoService.findEventoById(id));
		return new ResponseEntity<>(evento, HttpStatus.OK);
	}
	
	@GetMapping("/aprovados")
	public ResponseEntity<List<EventoOutDTO>> findAllApproved() throws PessoaInexistenteException {
		Integer id = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		List<EventoOutDTO> eventos = eventoService.findAllApproved(id).stream().map(item -> eventoMapper.eventoToEventoOutDto(item)).collect(Collectors.toList());
		return new ResponseEntity<>(eventos, HttpStatus.OK);
	}
	
	@GetMapping("/reprovados")
	public ResponseEntity<List<EventoOutDTO>> findAllDisapproved() throws PessoaInexistenteException {
		Integer id = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		List<EventoOutDTO> eventos = eventoService.findAllDisapproved(id).stream().map(item -> eventoMapper.eventoToEventoOutDto(item)).collect(Collectors.toList());
		return new ResponseEntity<>(eventos, HttpStatus.OK);
	}
	
	@GetMapping("/pendentes")
	public ResponseEntity<List<EventoOutDTO>> findAllPending() {
		List<EventoOutDTO> eventos = eventoService.findAllPending().stream().map(item -> eventoMapper.eventoToEventoOutDto(item)).collect(Collectors.toList());
		return new ResponseEntity<>(eventos, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> saveEvento(@Valid @RequestBody EventoDTO eventoDTO)
			throws CategoriaEventoEsportivoInexistenteException, PessoaInexistenteException,
			TipoEventoInexistenteException, StatusInexistenteException {
		Integer userId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		Evento evento = eventoMapper.EventoDtoToEvento(eventoDTO);
		eventoService.saveEvento(evento, userId);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateEvento(@Valid @RequestBody EventoDTO eventoDTO, @PathVariable Integer id)
			throws EventoInexistenteException, CategoriaEventoEsportivoInexistenteException, PessoaInexistenteException,
			TipoEventoInexistenteException, StatusInexistenteException {
		Evento evento = eventoMapper.EventoDtoToEvento(eventoDTO);
		eventoService.updateEvento(evento, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}/aprovar")
    public ResponseEntity<String> aprovar(@PathVariable Integer id) throws EventoInexistenteException, PessoaInexistenteException, StatusInexistenteException {
		Integer revisorId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		eventoService.aprovar(id, revisorId);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@PutMapping("/{id}/reprovar")
    public ResponseEntity<String> reprovar(@PathVariable Integer id) throws EventoInexistenteException, PessoaInexistenteException, StatusInexistenteException {
		Integer revisorId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		eventoService.reprovar(id, revisorId);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@PutMapping("/{id}/pausar")
    public ResponseEntity<String> pausar(@PathVariable Integer id) throws EventoInexistenteException, StatusInexistenteException {
		eventoService.pausar(id);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> updateNoticiaDeleteLogico(@PathVariable Integer id) throws EventoInexistenteException {
		eventoService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
