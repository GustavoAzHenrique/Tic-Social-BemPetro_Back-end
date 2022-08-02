package br.com.ticsocial.bemPetro.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ticsocial.bemPetro.dtos.EventoOutDTO;
import br.com.ticsocial.bemPetro.dtos.NoticiaOutDTO;
import br.com.ticsocial.bemPetro.dtos.OportunidadeOutDTO;
import br.com.ticsocial.bemPetro.exceptions.EventoInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.NoticiaInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.OportunidadeInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.PessoaInexistenteException;
import br.com.ticsocial.bemPetro.mappers.EventoMapper;
import br.com.ticsocial.bemPetro.mappers.NoticiaMapper;
import br.com.ticsocial.bemPetro.mappers.OportunidadeMapper;
import br.com.ticsocial.bemPetro.services.FavoritoService;

@RestController
@RequestMapping("/favorito")
public class FavoritoController {
	
	@Autowired
	FavoritoService favoritoService;
	
	@Autowired
	EventoMapper eventoMapper;
	
	@Autowired
	NoticiaMapper noticiaMapper;
	
	@Autowired
	OportunidadeMapper oportunidadeMapper;
	
	
	@PostMapping("/evento/{eventoId}")
	public ResponseEntity<String> favoritarEvento(@PathVariable Integer eventoId) throws EventoInexistenteException, PessoaInexistenteException {
		Integer userId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		favoritoService.favoritarEvento(eventoId, userId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/eventos")
	public ResponseEntity<List<EventoOutDTO>> findAllEventos() throws PessoaInexistenteException {
		Integer userId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		List<EventoOutDTO> eventos = favoritoService.findAllEventos(userId).stream().map(item -> eventoMapper.eventoToEventoOutDto(item)).collect(Collectors.toList());
		return new ResponseEntity<>(eventos, HttpStatus.OK);
	}
	
	@PostMapping("/noticia/{noticiaId}")
	public ResponseEntity<String> favoritarNoticia(@PathVariable Integer noticiaId) throws NoticiaInexistenteException, PessoaInexistenteException {
		Integer userId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		favoritoService.favoritarNoticia(noticiaId, userId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/noticias")
	public ResponseEntity<List<NoticiaOutDTO>> findAllNoticias() throws PessoaInexistenteException {
		Integer userId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		List<NoticiaOutDTO> noticias = favoritoService.findAllNoticias(userId).stream().map(item -> noticiaMapper.noticiaToNoticiaOutDto(item)).collect(Collectors.toList());
		return new ResponseEntity<>(noticias, HttpStatus.OK);
	}
	
	@PostMapping("/oportunidade/{oporId}")
	public ResponseEntity<String> favoritarOportunidade(@PathVariable Integer oporId) throws OportunidadeInexistenteException, PessoaInexistenteException {
		Integer userId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		favoritoService.favoritarOportunidade(oporId, userId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/oportunidades")
	public ResponseEntity<List<OportunidadeOutDTO>> findAllOportunidades() throws PessoaInexistenteException {
		Integer userId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		List<OportunidadeOutDTO> oportunidade = favoritoService.findAllOportunidades(userId).stream().map(item -> oportunidadeMapper.oportunidadeToOportunidadeOutDto(item)).collect(Collectors.toList());
		return new ResponseEntity<>(oportunidade, HttpStatus.OK);
	}
}
