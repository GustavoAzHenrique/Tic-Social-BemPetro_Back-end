package br.com.ticsocial.bemPetro.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ticsocial.bemPetro.exceptions.InstituicaoEnsinoExistenteException;
import br.com.ticsocial.bemPetro.exceptions.InstituicaoEnsinoInexistenteException;
import br.com.ticsocial.bemPetro.models.InstituicaoEnsino;
import br.com.ticsocial.bemPetro.repositories.InstituicaoEnsinoRepository;

@Service
public class InstituicaoEnsinoService {

	@Autowired
	InstituicaoEnsinoRepository instituicaoEnsinoRepository;

	public InstituicaoEnsino save(InstituicaoEnsino instituicaoEnsino) throws InstituicaoEnsinoExistenteException {
		Optional<InstituicaoEnsino> optional = instituicaoEnsinoRepository.findByNome(instituicaoEnsino.getNome());

		if (optional.isPresent()) {
			throw new InstituicaoEnsinoExistenteException();
		}
		instituicaoEnsino.setDataCadastro(LocalDate.now());
		instituicaoEnsino.setDataAtualizacao(LocalDate.now());
		return instituicaoEnsinoRepository.save(instituicaoEnsino);
	}

	public InstituicaoEnsino update(InstituicaoEnsino instituicaoEnsino, Integer id) throws InstituicaoEnsinoInexistenteException {
		Optional<InstituicaoEnsino> optional = instituicaoEnsinoRepository.findById(id);
		if (optional.isEmpty()) {
			throw new InstituicaoEnsinoInexistenteException();
		}
		instituicaoEnsino.setId(id);
		instituicaoEnsino.setDataAtualizacao(LocalDate.now());
		return instituicaoEnsinoRepository.save(instituicaoEnsino);
	}

	public void delete(InstituicaoEnsino instituicaoEnsino) {
		instituicaoEnsinoRepository.delete(instituicaoEnsino);
	}

	public void deletePorId(Integer id) {
		instituicaoEnsinoRepository.deleteById(id);
	}

	public InstituicaoEnsino findById(Integer id) {
		return instituicaoEnsinoRepository.findById(id).isPresent() ? instituicaoEnsinoRepository.findById(id).get()
				: null;
	}

	public List<InstituicaoEnsino> findAll() {
		return instituicaoEnsinoRepository.findAll();
	}

	public InstituicaoEnsino findByNome(String nome) throws InstituicaoEnsinoInexistenteException {
		Optional<InstituicaoEnsino> optional = instituicaoEnsinoRepository.findByNome(nome);

		if (optional.isEmpty()) {
			throw new InstituicaoEnsinoInexistenteException();
		}

		return optional.get();
	}
}
