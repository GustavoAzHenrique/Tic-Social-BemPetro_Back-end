package br.com.ticsocial.bemPetro.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ticsocial.bemPetro.exceptions.JornadaExistenteException;
import br.com.ticsocial.bemPetro.exceptions.JornadaInexistenteException;
import br.com.ticsocial.bemPetro.models.TipoJornada;
import br.com.ticsocial.bemPetro.repositories.TipoJornadaRepository;

@Service
public class TipoJornadaService {
	
	@Autowired
	TipoJornadaRepository tipoJornadaRepository;
	
	
	public List<TipoJornada> findAll() {
		return tipoJornadaRepository.findAllActive();
	}
	
	public TipoJornada findById(Integer id) throws JornadaInexistenteException {
		Optional<TipoJornada> optional = tipoJornadaRepository.findActiveById(id);
		
		if(optional.isEmpty()) {
			throw new JornadaInexistenteException();
		}
		
		return optional.get();
	}
	
	public TipoJornada findByTipo(String tipo) throws JornadaInexistenteException {
		Optional<TipoJornada> optional = tipoJornadaRepository.findActiveByTipo(tipo);
		
		if(optional.isEmpty()) {
			throw new JornadaInexistenteException();
		}
		
		return optional.get();
	}
	
	public TipoJornada save(TipoJornada tipoJornada) throws JornadaExistenteException {
		Optional<TipoJornada> optional = tipoJornadaRepository.findActiveByTipo(tipoJornada.getTipo());
		
		if(optional.isPresent()) {
			throw new JornadaExistenteException();

		}
		
		tipoJornada.setDataCadastro(LocalDate.now());
		tipoJornada.setDataAtualizacao(LocalDate.now());
		tipoJornada.setAtivo(true);
		return tipoJornadaRepository.save(tipoJornada);
	}
	
	public void delete(Integer id) throws JornadaInexistenteException {
		TipoJornada jornada = this.findById(id);
		
		jornada.setAtivo(false);
		tipoJornadaRepository.save(jornada);
	}
}
