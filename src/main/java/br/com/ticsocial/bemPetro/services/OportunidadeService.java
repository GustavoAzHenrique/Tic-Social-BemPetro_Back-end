package br.com.ticsocial.bemPetro.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.ticsocial.bemPetro.exceptions.OportunidadeInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.PessoaInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.StatusInexistenteException;
import br.com.ticsocial.bemPetro.models.Oportunidade;
import br.com.ticsocial.bemPetro.models.Pessoa;
import br.com.ticsocial.bemPetro.repositories.OportunidadeRepository;

@Service
public class OportunidadeService {
	
	@Autowired
	OportunidadeRepository oportunidadeRepository;
	
	@Autowired
	StatusPublicacaoService statusPublicacaoService;
	
	@Autowired
	PessoaService pessoaService;
	
	
	public List<Oportunidade> findAllActive() {
		return oportunidadeRepository.findAllActive();
	}
	
	public List<Oportunidade> findAll() throws PessoaInexistenteException {
		Integer userId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		Pessoa pessoa = pessoaService.findPessoaById(userId);
		
		return oportunidadeRepository.findAll(pessoa);
	}
	
	public List<Oportunidade> findAllPending() {
		return oportunidadeRepository.findAllPending();
	}
	
	public List<Oportunidade> findAllApproved(Integer id) throws PessoaInexistenteException {
		Pessoa pessoa = pessoaService.findPessoaById(id);
		return oportunidadeRepository.findAllApproved(pessoa);
	}
	
	public List<Oportunidade> findAllDisapproved(Integer id) throws PessoaInexistenteException {
		Pessoa pessoa = pessoaService.findPessoaById(id);
		return oportunidadeRepository.findAllDisapproved(pessoa);
	}
	
	public Oportunidade findById(Integer id) throws OportunidadeInexistenteException {
		Optional<Oportunidade> optional = oportunidadeRepository.findActiveById(id);
		
		if(optional.isEmpty()) {
			throw new OportunidadeInexistenteException();
		}
		
		return optional.get();
	}
	
	public void save(Oportunidade oportunidade, Integer userId) throws PessoaInexistenteException, StatusInexistenteException {
		Pessoa pessoa = pessoaService.findPessoaById(userId);
		
		oportunidade.setPessoaInseriu(pessoa);
		oportunidade.setDataCadastro(LocalDate.now());
		oportunidade.setDataAtualizacao(LocalDate.now());
		oportunidade.setAtivo(true);
		oportunidade.setStatus(statusPublicacaoService.findByStatus("pendente"));
		oportunidadeRepository.save(oportunidade);
	}
	
	public void update(Oportunidade oportunidadeAtt, Integer id) throws OportunidadeInexistenteException, StatusInexistenteException {
		Optional<Oportunidade> optional = oportunidadeRepository.findById(id);
        
        if (optional.isEmpty()) {
            throw new OportunidadeInexistenteException();
        }
        
        oportunidadeAtt.setId(id);
        oportunidadeAtt.setPessoaInseriu(optional.get().getPessoaInseriu());
        oportunidadeAtt.setDataCadastro(optional.get().getDataCadastro());
        oportunidadeAtt.setDataAtualizacao(LocalDate.now());
        oportunidadeAtt.setAtivo(true);
        oportunidadeAtt.setStatus(statusPublicacaoService.findByStatus("pendente"));
        
        oportunidadeRepository.save(oportunidadeAtt);
	}
	
	public void aprovar(Integer id, Integer revisorId) throws OportunidadeInexistenteException, PessoaInexistenteException, StatusInexistenteException {
        Oportunidade oportunidade = this.findById(id);
        Pessoa pessoa = pessoaService.findPessoaById(revisorId);
        
        oportunidade.setStatus(statusPublicacaoService.findByStatus("aprovado"));
        oportunidade.setPessoaRevisou(pessoa);
        oportunidadeRepository.save(oportunidade);
	}
	
	public void reprovar(Integer id, Integer revisorId) throws OportunidadeInexistenteException, PessoaInexistenteException, StatusInexistenteException {
        Oportunidade oportunidade = this.findById(id);
        Pessoa pessoa = pessoaService.findPessoaById(revisorId);
        
        oportunidade.setStatus(statusPublicacaoService.findByStatus("reprovado"));
        oportunidade.setPessoaRevisou(pessoa);
        oportunidadeRepository.save(oportunidade);
	}
	
	public void pausar(Integer id) throws OportunidadeInexistenteException, StatusInexistenteException {
		Oportunidade oportunidade = this.findById(id);
		
		if(oportunidade.getStatus().getStatus().equals("aprovado")) {
			oportunidade.setStatus(statusPublicacaoService.findByStatus("pausado"));
		}else if(oportunidade.getStatus().getStatus().equals("pausado")) {
			oportunidade.setStatus(statusPublicacaoService.findByStatus("aprovado"));
		}
		
		oportunidadeRepository.save(oportunidade);
	}
	
	public void delete(Integer id) throws OportunidadeInexistenteException {
		Optional<Oportunidade> optional = oportunidadeRepository.findById(id);
		
		if (optional.isEmpty()) {
            throw new OportunidadeInexistenteException();
        }
		
		Oportunidade oportunidade = optional.get();
		
		oportunidade.setAtivo(false);
		oportunidadeRepository.save(oportunidade);
	}
}
