package br.com.ticsocial.bemPetro.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.ticsocial.bemPetro.exceptions.EventoInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.PessoaInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.StatusInexistenteException;
import br.com.ticsocial.bemPetro.models.Evento;
import br.com.ticsocial.bemPetro.models.Pessoa;
import br.com.ticsocial.bemPetro.repositories.EventoRepository;

@Service
public class EventoService {
	@Autowired
	EventoRepository eventoRepository;
	
	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	StatusPublicacaoService statusPublicacaoService;
	

	public List<Evento> findAllActive() {
		return eventoRepository.findAllActive();
	}
	
	public List<Evento> findAll() throws PessoaInexistenteException {
		Integer userId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		Pessoa pessoa = pessoaService.findPessoaById(userId);
		
		return eventoRepository.findAll(pessoa);
	}

	public Evento findEventoById(Integer id) throws EventoInexistenteException {
		Optional<Evento> optional = eventoRepository.findActiveById(id);

		if (optional.isEmpty()) {
			throw new EventoInexistenteException();
		}

		return optional.get();
	}
	
	public List<Evento> findAllPending() {
		return eventoRepository.findAllPending();
	}
	
	public List<Evento> findAllApproved(Integer id) throws PessoaInexistenteException {
		Pessoa pessoa = pessoaService.findPessoaById(id);
		return eventoRepository.findAllApproved(pessoa);
	}
	
	public List<Evento> findAllDisapproved(Integer id) throws PessoaInexistenteException {
		Pessoa pessoa = pessoaService.findPessoaById(id);
		return eventoRepository.findAllDisapproved(pessoa);
	}

	public void saveEvento(Evento evento, Integer userId) throws PessoaInexistenteException, StatusInexistenteException {
		Pessoa pessoa = pessoaService.findPessoaById(userId);
		
		evento.setPessoaInseriu(pessoa);
		evento.setAtivo(true);
		evento.setStatus(statusPublicacaoService.findByStatus("pendente"));
		evento.setDataCadastro(LocalDate.now());
		evento.setDataAtualizacao(LocalDate.now());
		eventoRepository.save(evento);
	}

	public void updateEvento(Evento evento, Integer id) throws EventoInexistenteException, StatusInexistenteException {
		Optional<Evento> optional = eventoRepository.findById(id);

		if (optional.isEmpty()) {
			throw new EventoInexistenteException();
		}

		evento.setId(id);
		evento.setAtivo(true);
		evento.setStatus(statusPublicacaoService.findByStatus("pendente"));
		evento.setPessoaInseriu(optional.get().getPessoaInseriu());
		evento.setDataCadastro(optional.get().getDataCadastro());
		evento.setDataAtualizacao(LocalDate.now());
		eventoRepository.save(evento);
	}
	
	public void aprovar(Integer id, Integer revisorId) throws EventoInexistenteException, PessoaInexistenteException, StatusInexistenteException {
		Evento evento = this.findEventoById(id);
        Pessoa pessoa = pessoaService.findPessoaById(revisorId);
        
        evento.setStatus(statusPublicacaoService.findByStatus("aprovado"));
        evento.setRevisor(pessoa);
        eventoRepository.save(evento);
	}
	
	public void reprovar(Integer id, Integer revisorId) throws EventoInexistenteException, PessoaInexistenteException, StatusInexistenteException {
		Evento evento = this.findEventoById(id);
        Pessoa pessoa = pessoaService.findPessoaById(revisorId);
        
        evento.setStatus(statusPublicacaoService.findByStatus("reprovado"));
        evento.setRevisor(pessoa);
        eventoRepository.save(evento);
	}
	
	public void pausar(Integer id) throws EventoInexistenteException, StatusInexistenteException {
		Evento evento = this.findEventoById(id);
		
		if(evento.getStatus().getStatus().equals("aprovado")) {
			evento.setStatus(statusPublicacaoService.findByStatus("pausado"));
		}else if(evento.getStatus().getStatus().equals("pausado")) {
			evento.setStatus(statusPublicacaoService.findByStatus("aprovado"));
		}
		
		eventoRepository.save(evento);
	}
	
	public void delete(Integer id) throws EventoInexistenteException {
		Optional<Evento> optional = eventoRepository.findById(id);
		
		if (optional.isEmpty()) {
            throw new EventoInexistenteException();
        }
		
		Evento evento = optional.get();
		
		evento.setAtivo(false);
		eventoRepository.save(evento);
	}
}
