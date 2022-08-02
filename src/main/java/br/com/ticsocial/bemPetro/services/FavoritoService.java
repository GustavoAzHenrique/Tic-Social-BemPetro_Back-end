package br.com.ticsocial.bemPetro.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ticsocial.bemPetro.exceptions.EventoInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.NoticiaInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.OportunidadeInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.PessoaInexistenteException;
import br.com.ticsocial.bemPetro.models.Evento;
import br.com.ticsocial.bemPetro.models.Favorito;
import br.com.ticsocial.bemPetro.models.Noticia;
import br.com.ticsocial.bemPetro.models.Oportunidade;
import br.com.ticsocial.bemPetro.models.Pessoa;
import br.com.ticsocial.bemPetro.repositories.FavoritoRepository;

@Service
public class FavoritoService {
	
	@Autowired
	FavoritoRepository favoritoRepository;
	
	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	EventoService eventoService;
	
	@Autowired
	NoticiaService noticiaService;
	
	@Autowired
	OportunidadeService oportunidadeService;
	
	
	public void favoritarEvento(Integer eventoId, Integer userId) throws EventoInexistenteException, PessoaInexistenteException {
		Evento evento = eventoService.findEventoById(eventoId);
		Pessoa user = pessoaService.findPessoaById(userId);
		Favorito favorito = new Favorito();
		
		Optional<Favorito> optional = favoritoRepository.findEventoFavorito(user, evento);
		
		if(optional.isPresent()) {
			favorito.setId(optional.get().getId());
			favorito.setEvento(optional.get().getEvento());
			favorito.setPessoa(optional.get().getPessoa());
			favorito.setAtivo(false);
			favorito.setDataCadastro(optional.get().getDataCadastro());
		}else {
			favorito.setEvento(evento);
			favorito.setPessoa(user);
			favorito.setAtivo(true);
			favorito.setDataCadastro(LocalDate.now());
		}
		
		favoritoRepository.save(favorito);
	}
	
	public List<Evento> findAllEventos(Integer userId) throws PessoaInexistenteException {
		Pessoa user = pessoaService.findPessoaById(userId);
		return favoritoRepository.findAllEventos(user);
	}
	
	
	public void favoritarNoticia(Integer noticiaId, Integer userId) throws NoticiaInexistenteException, PessoaInexistenteException {
		Noticia noticia = noticiaService.findNoticiaById(noticiaId);
		Pessoa user = pessoaService.findPessoaById(userId);
		Favorito favorito = new Favorito();
		
		Optional<Favorito> optional = favoritoRepository.findNoticiaFavorita(user, noticia);
		
		if(optional.isPresent()) {
			favorito.setId(optional.get().getId());
			favorito.setNoticia(optional.get().getNoticia());
			favorito.setPessoa(optional.get().getPessoa());
			favorito.setAtivo(false);
			favorito.setDataCadastro(optional.get().getDataCadastro());
		}else {
			favorito.setNoticia(noticia);
			favorito.setPessoa(user);
			favorito.setAtivo(true);
			favorito.setDataCadastro(LocalDate.now());
		}
		
		favoritoRepository.save(favorito);
	}
	
	public List<Noticia> findAllNoticias(Integer userId) throws PessoaInexistenteException {
		Pessoa user = pessoaService.findPessoaById(userId);
		return favoritoRepository.findAllNoticias(user);
	}
	
	
	public void favoritarOportunidade(Integer oporId, Integer userId) throws OportunidadeInexistenteException, PessoaInexistenteException {
		Oportunidade oportunidade = oportunidadeService.findById(oporId);
		Pessoa user = pessoaService.findPessoaById(userId);
		Favorito favorito = new Favorito();
		
		Optional<Favorito> optional = favoritoRepository.findOportunidadeFavorita(user, oportunidade);
		
		if(optional.isPresent()) {
			favorito.setId(optional.get().getId());
			favorito.setOportunidade(optional.get().getOportunidade());
			favorito.setPessoa(optional.get().getPessoa());
			favorito.setAtivo(false);
			favorito.setDataCadastro(optional.get().getDataCadastro());
		}else {
			favorito.setOportunidade(oportunidade);
			favorito.setPessoa(user);
			favorito.setAtivo(true);
			favorito.setDataCadastro(LocalDate.now());
		}
		
		favoritoRepository.save(favorito);
	}
	
	public List<Oportunidade> findAllOportunidades(Integer userId) throws PessoaInexistenteException {
		Pessoa user = pessoaService.findPessoaById(userId);
		return favoritoRepository.findAllOportunidades(user);
	}
}
