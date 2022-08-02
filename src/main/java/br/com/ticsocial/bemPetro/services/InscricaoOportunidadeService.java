package br.com.ticsocial.bemPetro.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ticsocial.bemPetro.exceptions.OportunidadeInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.PessoaInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.PessoaJaInscritaException;
import br.com.ticsocial.bemPetro.models.InscricaoOportunidade;
import br.com.ticsocial.bemPetro.models.Oportunidade;
import br.com.ticsocial.bemPetro.models.Pessoa;
import br.com.ticsocial.bemPetro.repositories.InscricaoOportunidadeRepository;

@Service
public class InscricaoOportunidadeService {

	@Autowired
	InscricaoOportunidadeRepository inscricaoRepository;

	@Autowired
	OportunidadeService oportunidadeService;

	@Autowired
	PessoaService pessoaService;

	public void inscrever(Integer oporId, Integer userId)
			throws PessoaInexistenteException, OportunidadeInexistenteException, PessoaJaInscritaException {
		Pessoa user = pessoaService.findPessoaById(userId);
		Oportunidade oportunidade = oportunidadeService.findById(oporId);
		InscricaoOportunidade inscricao = new InscricaoOportunidade();

		Optional<InscricaoOportunidade> optional = inscricaoRepository.findInscricao(user, oportunidade);

		if (optional.isPresent()) {
			throw new PessoaJaInscritaException();
		}

		inscricao.setPessoa(user);
		inscricao.setOportunidade(oportunidade);
		inscricao.setDataInscricao(LocalDate.now());
		inscricao.setAtivo(true);

		inscricaoRepository.save(inscricao);
	}

	public Boolean isInscrito(Integer oporId, Integer userId) throws PessoaInexistenteException, OportunidadeInexistenteException {
		Pessoa user = pessoaService.findPessoaById(userId);
		Oportunidade oportunidade = oportunidadeService.findById(oporId);

		Optional<InscricaoOportunidade> optional = inscricaoRepository.findInscricao(user, oportunidade);

		if (optional.isPresent()) {
			return true;
		}
		
		return false;
	}
}
