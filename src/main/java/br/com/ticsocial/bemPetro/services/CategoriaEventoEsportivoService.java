package br.com.ticsocial.bemPetro.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ticsocial.bemPetro.exceptions.CategoriaEventoEsportivoExistenteException;
import br.com.ticsocial.bemPetro.exceptions.CategoriaEventoEsportivoInexistenteException;
import br.com.ticsocial.bemPetro.models.CategoriaEventoEsportivo;
import br.com.ticsocial.bemPetro.repositories.CategoriaEventoEsportivoRepository;

@Service
public class CategoriaEventoEsportivoService {
	@Autowired
	CategoriaEventoEsportivoRepository categoriaEventoEsportivoRepository;

	public CategoriaEventoEsportivo save(CategoriaEventoEsportivo categoriaEventoEsportivo) throws CategoriaEventoEsportivoExistenteException {
		Optional<CategoriaEventoEsportivo> optional = categoriaEventoEsportivoRepository.findByNome(categoriaEventoEsportivo.getNome());

		if (optional.isPresent()) {
			throw new CategoriaEventoEsportivoExistenteException();
		}
		categoriaEventoEsportivo.setDataCadastro(LocalDate.now());
		categoriaEventoEsportivo.setDataAtualizacao(LocalDate.now());
		return categoriaEventoEsportivoRepository.save(categoriaEventoEsportivo);
	}

	public CategoriaEventoEsportivo update(CategoriaEventoEsportivo grauInstrucao, Integer id) throws CategoriaEventoEsportivoInexistenteException {
		Optional<CategoriaEventoEsportivo> optional = categoriaEventoEsportivoRepository.findById(id);
		if (optional.isEmpty()) {
			throw new CategoriaEventoEsportivoInexistenteException();
		}
		grauInstrucao.setId(id);
		grauInstrucao.setDataAtualizacao(LocalDate.now());
		return categoriaEventoEsportivoRepository.save(grauInstrucao);
	}

	public void delete(CategoriaEventoEsportivo grauInstrucao) {
		categoriaEventoEsportivoRepository.delete(grauInstrucao);
	}

	public void deletePorId(Integer id) {
		categoriaEventoEsportivoRepository.deleteById(id);
	}

	public CategoriaEventoEsportivo findById(Integer id) {
		return categoriaEventoEsportivoRepository.findById(id).isPresent() ? categoriaEventoEsportivoRepository.findById(id).get() : null;
	}

	public List<CategoriaEventoEsportivo> findAll() {
		return categoriaEventoEsportivoRepository.findAll();
	}

	public CategoriaEventoEsportivo findByNome(String nome) throws CategoriaEventoEsportivoInexistenteException {
		Optional<CategoriaEventoEsportivo> optional = categoriaEventoEsportivoRepository.findByNome(nome);

		if (optional.isEmpty()) {
			throw new CategoriaEventoEsportivoInexistenteException();
		}

		return optional.get();
	}
}
