package br.com.ticsocial.bemPetro.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ticsocial.bemPetro.exceptions.ModalidadeExistenteException;
import br.com.ticsocial.bemPetro.exceptions.ModalidadeInexistenteException;
import br.com.ticsocial.bemPetro.models.ModalidadeContratacao;
import br.com.ticsocial.bemPetro.repositories.ModalidadeContratacaoRepository;

@Service
public class ModalidadeContratacaoService {
	
	@Autowired
	ModalidadeContratacaoRepository modalidadeContratacaoRepository;
	
	
	public List<ModalidadeContratacao> findAll() {
		return modalidadeContratacaoRepository.findAllActive();
	}
	
	public ModalidadeContratacao findById(Integer id) throws ModalidadeInexistenteException {
		Optional<ModalidadeContratacao> optional = modalidadeContratacaoRepository.findActiveById(id);
		
		if(optional.isEmpty()) {
			throw new ModalidadeInexistenteException();
		}
		
		return optional.get();
	}
	
	public ModalidadeContratacao findByModalidade(String modalidade) throws ModalidadeInexistenteException {
		Optional<ModalidadeContratacao> optional = modalidadeContratacaoRepository.findActiveByModalidade(modalidade);
		
		if(optional.isEmpty()) {
			throw new ModalidadeInexistenteException();
		}
		
		return optional.get();
	}
	
	public ModalidadeContratacao save(ModalidadeContratacao modalidadeContratacao) throws ModalidadeExistenteException {
		Optional<ModalidadeContratacao> optional = modalidadeContratacaoRepository.findByModalidade(modalidadeContratacao.getModalidade());
		
		if(optional.isPresent()) {
			throw new ModalidadeExistenteException();

		}
		
		modalidadeContratacao.setDataCadastro(LocalDate.now());
		modalidadeContratacao.setDataAtualizacao(LocalDate.now());
		modalidadeContratacao.setAtivo(true);
		return modalidadeContratacaoRepository.save(modalidadeContratacao);
	}
	
	public void delete(Integer id) throws ModalidadeInexistenteException {
		ModalidadeContratacao modalidade = this.findById(id);
		
		modalidade.setAtivo(false);
		modalidadeContratacaoRepository.save(modalidade);
	}
}
