package br.com.ticsocial.bemPetro.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ticsocial.bemPetro.exceptions.GrauInstrucaoException;
import br.com.ticsocial.bemPetro.exceptions.GrauInstrucaoInexistenteException;
import br.com.ticsocial.bemPetro.models.GrauInstrucao;
import br.com.ticsocial.bemPetro.repositories.GrauInstrucaoRepository;

@Service
public class GrauInstrucaoService {
	@Autowired
	GrauInstrucaoRepository grauInstrucaoRepository;

	public GrauInstrucao save(GrauInstrucao grauInstrucao) throws GrauInstrucaoException {
		Optional<GrauInstrucao> optional = grauInstrucaoRepository.findByGrau(grauInstrucao.getGrau());

		if (optional.isPresent()) {
			throw new GrauInstrucaoException();
		}
		grauInstrucao.setDataCadastro(LocalDate.now());
		grauInstrucao.setDataAtualizacao(LocalDate.now());
		return grauInstrucaoRepository.save(grauInstrucao);
	}

	public GrauInstrucao update(GrauInstrucao grauInstrucao, Integer id) throws GrauInstrucaoInexistenteException {
		Optional<GrauInstrucao> optional = grauInstrucaoRepository.findById(id);
		if (optional.isEmpty()) {
			throw new GrauInstrucaoInexistenteException();
		}
		grauInstrucao.setId(id);
		grauInstrucao.setDataAtualizacao(LocalDate.now());
		return grauInstrucaoRepository.save(grauInstrucao);
	}

	public void delete(GrauInstrucao grauInstrucao) {
		grauInstrucaoRepository.delete(grauInstrucao);
	}

	public void deletePorId(Integer id) {
		grauInstrucaoRepository.deleteById(id);
	}

	public GrauInstrucao findById(Integer id) throws GrauInstrucaoInexistenteException {
		Optional<GrauInstrucao> optional = grauInstrucaoRepository.findById(id);
		
		if(optional.isEmpty()) {
			throw new GrauInstrucaoInexistenteException();
		}
		
		return optional.get();
	}

	public List<GrauInstrucao> findAll() {
		return grauInstrucaoRepository.findAll();
	}

	public GrauInstrucao findByGrau(String grau) throws GrauInstrucaoInexistenteException {
		Optional<GrauInstrucao> optional = grauInstrucaoRepository.findByGrau(grau);

		if (optional.isEmpty()) {
			throw new GrauInstrucaoInexistenteException();
		}

		return optional.get();
	}
}
