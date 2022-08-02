package br.com.ticsocial.bemPetro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ticsocial.bemPetro.models.TermoUso;
import br.com.ticsocial.bemPetro.repositories.TermoUsoRepository;

@Service
public class TermoUsoService {
	
	@Autowired
	TermoUsoRepository termoUsoRepository;
	
	
	public List<TermoUso> findAll() {
		return termoUsoRepository.findAll();
	}
}
