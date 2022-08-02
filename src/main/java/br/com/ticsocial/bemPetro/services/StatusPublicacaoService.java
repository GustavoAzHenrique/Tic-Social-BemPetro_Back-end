package br.com.ticsocial.bemPetro.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ticsocial.bemPetro.exceptions.StatusInexistenteException;
import br.com.ticsocial.bemPetro.models.StatusPublicacao;
import br.com.ticsocial.bemPetro.repositories.StatusPublicacaoRepository;

@Service
public class StatusPublicacaoService {
	
	@Autowired
	StatusPublicacaoRepository statusPublicacaoRepository;
	
	public StatusPublicacao findByStatus(String status) throws StatusInexistenteException {
		Optional<StatusPublicacao> optional = statusPublicacaoRepository.findByStatus(status);
		
		if(optional.isEmpty()) {
			throw new StatusInexistenteException();
		}
		
		return optional.get();
	}
}
