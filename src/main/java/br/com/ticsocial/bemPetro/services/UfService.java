package br.com.ticsocial.bemPetro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ticsocial.bemPetro.exceptions.UfInexistenteException;
import br.com.ticsocial.bemPetro.models.Uf;
import br.com.ticsocial.bemPetro.repositories.UfRepository;

@Service
public class UfService {
	
	@Autowired
	UfRepository ufRepository;

	public List<Uf> findAllUf() {
		return ufRepository.findAll();
	}
	
	public void deleteUfById(Integer idUf) {
		ufRepository.deleteById(idUf);
	}
	
	public Uf findUfById(Integer id) {
		return ufRepository.findById(id).get();
	}
	
	public Uf findUfBySigla(String sigla) throws UfInexistenteException {
		Optional<Uf> optional = ufRepository.findBySigla(sigla.toUpperCase());
		
		if(optional.isEmpty()) {
			throw new UfInexistenteException();
		}
		
		return optional.get();
	}
	
	public Uf save(Uf uf) {
        return ufRepository.save(uf);
    }
}
