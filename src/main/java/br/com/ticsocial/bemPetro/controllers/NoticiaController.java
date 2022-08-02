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

import br.com.ticsocial.bemPetro.dtos.NoticiaDTO;
import br.com.ticsocial.bemPetro.dtos.NoticiaOutDTO;
import br.com.ticsocial.bemPetro.exceptions.NoticiaInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.PessoaInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.StatusInexistenteException;
import br.com.ticsocial.bemPetro.mappers.NoticiaMapper;
import br.com.ticsocial.bemPetro.models.Noticia;
import br.com.ticsocial.bemPetro.services.NoticiaService;

@RestController
@RequestMapping("/noticia")
public class NoticiaController {

	@Autowired
	NoticiaService noticiaService;

	@Autowired
	NoticiaMapper noticiaMapper;

	@GetMapping
	public ResponseEntity<List<NoticiaOutDTO>> findAllNoticia() {
		List<NoticiaOutDTO> noticias = noticiaService.findAllActive().stream().map(item -> noticiaMapper.noticiaToNoticiaOutDto(item)).collect(Collectors.toList());
		return new ResponseEntity<>(noticias, HttpStatus.OK);
	}
	
	@GetMapping("/especifico")
	public ResponseEntity<List<NoticiaOutDTO>> findAllSpecific() throws PessoaInexistenteException {
		List<NoticiaOutDTO> noticias = noticiaService.findAllSpecific().stream().map(item -> noticiaMapper.noticiaToNoticiaOutDto(item)).collect(Collectors.toList());
		return new ResponseEntity<>(noticias, HttpStatus.OK);
	}
	
	@GetMapping("/aprovados")
	public ResponseEntity<List<NoticiaOutDTO>> findAllApproved() throws PessoaInexistenteException {
		Integer id = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		List<NoticiaOutDTO> noticias = noticiaService.findAllApproved(id).stream().map(item -> noticiaMapper.noticiaToNoticiaOutDto(item)).collect(Collectors.toList());
		return new ResponseEntity<>(noticias, HttpStatus.OK);
	}
	
	@GetMapping("/reprovados")
	public ResponseEntity<List<NoticiaOutDTO>> findAllDisapproved() throws PessoaInexistenteException {
		Integer id = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		List<NoticiaOutDTO> noticias = noticiaService.findAllDisapproved(id).stream().map(item -> noticiaMapper.noticiaToNoticiaOutDto(item)).collect(Collectors.toList());
		return new ResponseEntity<>(noticias, HttpStatus.OK);
	}
	
	@GetMapping("/pendentes")
	public ResponseEntity<List<NoticiaOutDTO>> findAllPending() {
		List<NoticiaOutDTO> noticias = noticiaService.findAllPending().stream().map(item -> noticiaMapper.noticiaToNoticiaOutDto(item)).collect(Collectors.toList());
		return new ResponseEntity<>(noticias, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<NoticiaOutDTO> findNoticiaById(@PathVariable Integer id) throws NoticiaInexistenteException {
		NoticiaOutDTO noticia = noticiaMapper.noticiaToNoticiaOutDto(noticiaService.findNoticiaById(id));
		return new ResponseEntity<>(noticia, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> saveNoticia(@Valid @RequestBody NoticiaDTO noticiaDTO)
			throws PessoaInexistenteException, StatusInexistenteException {
		Noticia noticia = noticiaMapper.NoticiaDtoToNoticia(noticiaDTO);
		Integer userId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		noticiaService.saveNoticia(noticia, userId);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateNoticia(@Valid @RequestBody NoticiaDTO noticiaDTO, @PathVariable Integer id)
			throws NoticiaInexistenteException, PessoaInexistenteException, StatusInexistenteException {
		Noticia noticia = noticiaMapper.NoticiaDtoToNoticia(noticiaDTO);
		noticiaService.updateNoticia(noticia, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}/aprovar")
    public ResponseEntity<String> aprovar(@PathVariable Integer id) throws PessoaInexistenteException, NoticiaInexistenteException, StatusInexistenteException {
		Integer revisorId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		noticiaService.aprovar(id, revisorId);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@PutMapping("/{id}/reprovar")
    public ResponseEntity<String> reprovar(@PathVariable Integer id) throws PessoaInexistenteException, NoticiaInexistenteException, StatusInexistenteException {
		Integer revisorId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		noticiaService.reprovar(id, revisorId);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@PutMapping("/{id}/pausar")
    public ResponseEntity<String> pausar(@PathVariable Integer id) throws NoticiaInexistenteException, StatusInexistenteException {
		noticiaService.pausar(id);
    	return new ResponseEntity<>(HttpStatus.OK);
    }

	@DeleteMapping("/{id}")
	public ResponseEntity<String> updateNoticiaDeleteLogico(@PathVariable Integer id) throws NoticiaInexistenteException, PessoaInexistenteException {
		noticiaService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
