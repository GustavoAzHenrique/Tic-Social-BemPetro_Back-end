package br.com.ticsocial.bemPetro.services;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ticsocial.bemPetro.exceptions.TelefoneInexistenteException;
import br.com.ticsocial.bemPetro.models.Telefone;
import br.com.ticsocial.bemPetro.repositories.TelefoneRepository;

@Service
public class TelefoneService {
	
	@Autowired
	TelefoneRepository telefoneRepository;

	public List<Telefone> findAllTelefone() {
		return telefoneRepository.findAll();
	}
	
	public void deleteTelefoneById(Integer idTelefone) {
		telefoneRepository.deleteById(idTelefone);
	}
	
	public Telefone findTelefoneById(Integer id) {
		return telefoneRepository.findById(id).get();
	}
	
	public Telefone save(Telefone telefone) {
		telefone.setDt_cadastro(LocalDate.now());
        return telefoneRepository.save(telefone);
    }
	
	public Telefone updateTelefone(Telefone telefone, Integer id) throws TelefoneInexistenteException {
        Optional<Telefone> optional = telefoneRepository.findById(id);
        
        if (optional.isEmpty()) {
            throw new TelefoneInexistenteException();
        }
        
        Telefone oldTelefone = optional.get();
        if (telefone.getDdd() != null) {
        	oldTelefone.setDdd(telefone.getDdd());
        }
        if (telefone.getNumero() != null) {
        	oldTelefone.setNumero(telefone.getNumero());
        }
        
        oldTelefone.setDt_atualizacao(LocalDate.now());
        
        return telefoneRepository.save(oldTelefone);
	}
}
