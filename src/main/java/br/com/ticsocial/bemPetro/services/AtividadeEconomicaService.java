package br.com.ticsocial.bemPetro.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ticsocial.bemPetro.exceptions.AtivEconomicaExistenteException;
import br.com.ticsocial.bemPetro.exceptions.ativEconomicaInexistenteException;
import br.com.ticsocial.bemPetro.models.AtividadeEconomica;
import br.com.ticsocial.bemPetro.repositories.AtividadeEconomicaRepository;

@Service
public class AtividadeEconomicaService {

	@Autowired
	AtividadeEconomicaRepository atividadeEconomicaRepository;

	
	public AtividadeEconomica save(AtividadeEconomica atividadeEconomica) throws AtivEconomicaExistenteException {
		Optional<AtividadeEconomica> optional = atividadeEconomicaRepository.findByNome(atividadeEconomica.getNome());
		
		if(optional.isPresent()) {
			throw new AtivEconomicaExistenteException();

		}
		return atividadeEconomicaRepository.save(atividadeEconomica);
	}

	public AtividadeEconomica update(AtividadeEconomica atividadeEconomia) {
		atividadeEconomia.setDataAtualizacao(LocalDate.now());
		return atividadeEconomicaRepository.save(atividadeEconomia);
	}

	public void delete(AtividadeEconomica atividadeEconomia) {
		atividadeEconomicaRepository.delete(atividadeEconomia);
	}

	public void deletePorId(Integer id) {
		atividadeEconomicaRepository.deleteById(id);
	}

	public AtividadeEconomica findById(Integer id) {
		return atividadeEconomicaRepository.findById(id).isPresent() ? atividadeEconomicaRepository.findById(id).get()
				: null;
	}

	
	public AtividadeEconomica findByNome(String nome) throws ativEconomicaInexistenteException {
		Optional<AtividadeEconomica> optional = atividadeEconomicaRepository.findByNome(nome);
		
		if(optional.isEmpty()) {
			throw new ativEconomicaInexistenteException();
		}
		
		return optional.get();
	}
	
	public List<AtividadeEconomica> findAll(){

		return atividadeEconomicaRepository.findAll();
	}
}
