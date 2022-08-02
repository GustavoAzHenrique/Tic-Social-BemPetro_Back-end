package br.com.ticsocial.bemPetro.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.ticsocial.bemPetro.exceptions.NoticiaInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.PessoaInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.StatusInexistenteException;
import br.com.ticsocial.bemPetro.models.Noticia;
import br.com.ticsocial.bemPetro.models.Pessoa;
import br.com.ticsocial.bemPetro.repositories.NoticiaRepository;

@Service
public class NoticiaService {
	@Autowired
	NoticiaRepository noticiaRepository;
	
	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	StatusPublicacaoService statusPublicacaoService;
	

	public List<Noticia> findAllActive() {
		return noticiaRepository.findAllActive();
	}
	
	public List<Noticia> findAllSpecific() throws PessoaInexistenteException {
		Integer userId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		Pessoa pessoa = pessoaService.findPessoaById(userId);
		
		return noticiaRepository.findAll(pessoa);
	}
	
	public List<Noticia> findAllPending() {
		return noticiaRepository.findAllPending();
	}
	
	public List<Noticia> findAllApproved(Integer id) throws PessoaInexistenteException {
		Pessoa pessoa = pessoaService.findPessoaById(id);
		return noticiaRepository.findAllApproved(pessoa);
	}
	
	public List<Noticia> findAllDisapproved(Integer id) throws PessoaInexistenteException {
		Pessoa pessoa = pessoaService.findPessoaById(id);
		return noticiaRepository.findAllDisapproved(pessoa);
	}

	public Noticia findNoticiaById(Integer id) throws NoticiaInexistenteException {
		Optional<Noticia> optional = noticiaRepository.findActiveById(id);

		if (optional.isEmpty()) {
			throw new NoticiaInexistenteException();
		}

		return optional.get();
	}

	public void saveNoticia(Noticia noticia, Integer userId) throws PessoaInexistenteException, StatusInexistenteException {
		Pessoa pessoa = pessoaService.findPessoaById(userId);
		
		noticia.setPessoaInseriu(pessoa);
		noticia.setAtivo(true);
		noticia.setStatus(statusPublicacaoService.findByStatus("pendente"));
		noticia.setDataCadastro(LocalDate.now());
		noticia.setDataAtualizacao(LocalDate.now());
		noticiaRepository.save(noticia);
	}

	public void updateNoticia(Noticia noticia, Integer id) throws NoticiaInexistenteException, StatusInexistenteException {
		Optional<Noticia> optional = noticiaRepository.findById(id);

		if (optional.isEmpty()) {
			throw new NoticiaInexistenteException();
		}

		noticia.setId(id);
		noticia.setAtivo(true);
		noticia.setStatus(statusPublicacaoService.findByStatus("pendente"));
		noticia.setPessoaInseriu(optional.get().getPessoaInseriu());
		noticia.setDataCadastro(optional.get().getDataCadastro());
		noticia.setDataAtualizacao(LocalDate.now());
		noticiaRepository.save(noticia);
	}
	
	public void aprovar(Integer id, Integer revisorId) throws PessoaInexistenteException, NoticiaInexistenteException, StatusInexistenteException {
        Noticia noticia = this.findNoticiaById(id);
        Pessoa pessoa = pessoaService.findPessoaById(revisorId);
        
        noticia.setStatus(statusPublicacaoService.findByStatus("aprovado"));
        noticia.setRevisor(pessoa);
        noticiaRepository.save(noticia);
	}
	
	public void reprovar(Integer id, Integer revisorId) throws PessoaInexistenteException, NoticiaInexistenteException, StatusInexistenteException {
		Noticia noticia = this.findNoticiaById(id);
        Pessoa pessoa = pessoaService.findPessoaById(revisorId);
        
        noticia.setStatus(statusPublicacaoService.findByStatus("reprovado"));
        noticia.setRevisor(pessoa);
        noticiaRepository.save(noticia);
	}
	
	public void pausar(Integer id) throws NoticiaInexistenteException, StatusInexistenteException {
		Noticia noticia = this.findNoticiaById(id);
		
		if(noticia.getStatus().getStatus().equals("aprovado")) {
			noticia.setStatus(statusPublicacaoService.findByStatus("pausado"));
		}else if(noticia.getStatus().getStatus().equals("pausado")) {
			noticia.setStatus(statusPublicacaoService.findByStatus("aprovado"));
		}
		
		noticiaRepository.save(noticia);
	}
	
	public void delete(Integer id) throws NoticiaInexistenteException {
		Optional<Noticia> optional = noticiaRepository.findById(id);
		
		if (optional.isEmpty()) {
            throw new NoticiaInexistenteException();
        }
		
		Noticia noticia = optional.get();
		
		noticia.setAtivo(false);
		noticiaRepository.save(noticia);
	}
}
