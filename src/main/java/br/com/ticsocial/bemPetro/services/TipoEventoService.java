package br.com.ticsocial.bemPetro.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ticsocial.bemPetro.exceptions.TipoEventoExistenteException;
import br.com.ticsocial.bemPetro.exceptions.TipoEventoInexistenteException;
import br.com.ticsocial.bemPetro.models.TipoEvento;
import br.com.ticsocial.bemPetro.repositories.TipoEventoRepository;

@Service
public class TipoEventoService {

	@Autowired
	TipoEventoRepository tipoEventoRepository;

	public TipoEvento save(TipoEvento tipoEvento) throws TipoEventoExistenteException {
		Optional<TipoEvento> optional = tipoEventoRepository.findByTipo(tipoEvento.getTipo());

		if (optional.isPresent()) {
			throw new TipoEventoExistenteException();
		}
		tipoEvento.setDataCadastro(LocalDate.now());
		tipoEvento.setDataAtualizacao(LocalDate.now());
		return tipoEventoRepository.save(tipoEvento);
	}

	public TipoEvento update(TipoEvento tipoEvento, Integer id) throws TipoEventoInexistenteException {
		Optional<TipoEvento> optional = tipoEventoRepository.findById(id);
		if (optional.isEmpty()) {
			throw new TipoEventoInexistenteException();
		}
		tipoEvento.setId(id);
		tipoEvento.setDataAtualizacao(LocalDate.now());
		return tipoEventoRepository.save(tipoEvento);
	}

	public void delete(TipoEvento tipoEvento) {
		tipoEventoRepository.delete(tipoEvento);
	}

	public void deletePorId(Integer id) {
		tipoEventoRepository.deleteById(id);
	}

	public TipoEvento findById(Integer id) {
		return tipoEventoRepository.findById(id).isPresent() ? tipoEventoRepository.findById(id).get() : null;
	}

	public TipoEvento findByTipo(String nome) throws TipoEventoInexistenteException {
		Optional<TipoEvento> optional = tipoEventoRepository.findByTipo(nome);
		if (optional.isEmpty()) {
			throw new TipoEventoInexistenteException();
		}
		return optional.get();
	}

	public List<TipoEvento> findAll() {

		return tipoEventoRepository.findAll();
	}
}
