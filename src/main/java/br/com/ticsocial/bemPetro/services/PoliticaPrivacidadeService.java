package br.com.ticsocial.bemPetro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ticsocial.bemPetro.models.PoliticaPrivacidade;
import br.com.ticsocial.bemPetro.repositories.PoliticaPrivacidadeRepository;

@Service
public class PoliticaPrivacidadeService {
	
	@Autowired
	PoliticaPrivacidadeRepository politicaPrivacidadeRepository;
	
	
	public List<PoliticaPrivacidade> findAll() {
		return politicaPrivacidadeRepository.findAll();
	}
}
