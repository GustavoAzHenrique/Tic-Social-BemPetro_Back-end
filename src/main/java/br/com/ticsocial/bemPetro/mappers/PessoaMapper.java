package br.com.ticsocial.bemPetro.mappers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.ticsocial.bemPetro.dtos.EnderecoDTO;
import br.com.ticsocial.bemPetro.dtos.PessoaFisicaDTO;
import br.com.ticsocial.bemPetro.dtos.PessoaJuridicaDTO;
import br.com.ticsocial.bemPetro.dtos.PessoaOutDTO;
import br.com.ticsocial.bemPetro.dtos.TelefoneDTO;
import br.com.ticsocial.bemPetro.exceptions.GrauInstrucaoInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.InstituicaoEnsinoInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.PerfilPessoaInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.UfInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.ativEconomicaInexistenteException;
import br.com.ticsocial.bemPetro.models.Endereco;
import br.com.ticsocial.bemPetro.models.PerfilPessoa;
import br.com.ticsocial.bemPetro.models.Pessoa;
import br.com.ticsocial.bemPetro.models.Telefone;
import br.com.ticsocial.bemPetro.services.AtividadeEconomicaService;
import br.com.ticsocial.bemPetro.services.GrauInstrucaoService;
import br.com.ticsocial.bemPetro.services.InstituicaoEnsinoService;
import br.com.ticsocial.bemPetro.services.PerfilPessoaService;

@Component
public class PessoaMapper {
	@Autowired
	TelefoneMapper telefoneMapper;

	@Autowired
	EnderecoMapper enderecoMapper;

	@Autowired
	AtividadeEconomicaService atividadeEconomicaService;

	@Autowired
	PerfilPessoaService perfilPessoaService;

	@Autowired
	InstituicaoEnsinoService instituicaoEnsinoService;

	@Autowired
	GrauInstrucaoService grauInstrucaoService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	

	public Pessoa pessoaJuridicaDtoToPessoa(PessoaJuridicaDTO pessoaJuridicaDTO)
			throws UfInexistenteException, ativEconomicaInexistenteException, PerfilPessoaInexistenteException {
		Pessoa pessoa = new Pessoa();

		pessoa.setAtivo(true);
		pessoa.setEmail(pessoaJuridicaDTO.getEmail());
		
		if(!pessoaJuridicaDTO.getSenha().equals("")) {
			pessoa.setSenha(bCryptPasswordEncoder.encode(pessoaJuridicaDTO.getSenha()));
		}
		
		pessoa.setNomeFantasia(pessoaJuridicaDTO.getNomeFantasia());
		pessoa.setCnpj(pessoaJuridicaDTO.getCnpj());
		pessoa.setRazaoSocial(pessoaJuridicaDTO.getRazaoSocial());
		
		if(pessoaJuridicaDTO.getAtividadeEconomica() != null) {
			pessoa.setAtividadeEconomica(atividadeEconomicaService.findByNome(pessoaJuridicaDTO.getAtividadeEconomica()));
		}

		if (pessoaJuridicaDTO.getPerfilPessoa() != null) {
			List<PerfilPessoa> perfilPessoaList = new ArrayList<>();
			for (String perfil : pessoaJuridicaDTO.getPerfilPessoa()) {
				perfilPessoaList.add(perfilPessoaService.findPerfilPessoaByPerfil(perfil));
			}
			pessoa.setPerfilPessoa(perfilPessoaList);
		}

		if (pessoaJuridicaDTO.getTelefones() != null) {
			List<Telefone> telefones = new ArrayList<>();
			for (TelefoneDTO telefoneDTO : pessoaJuridicaDTO.getTelefones()) {
				Telefone telefone = telefoneMapper.telefoneDtoToTelefone(telefoneDTO);
				telefone.setPessoa(pessoa);

				telefones.add(telefone);
			}
			pessoa.setTelefones(telefones);
		}

		if (pessoaJuridicaDTO.getEnderecos() != null) {
			List<Endereco> enderecos = new ArrayList<>();
			for (EnderecoDTO enderecoDTO : pessoaJuridicaDTO.getEnderecos()) {
				Endereco endereco = enderecoMapper.enderecoDtoToEndereco(enderecoDTO);
				endereco.setPessoa(pessoa);

				enderecos.add(endereco);
			}
			pessoa.setEnderecos(enderecos);
		}

		return pessoa;
	}

	public Pessoa pessoaFisicaDtoToPessoa(PessoaFisicaDTO pessoaFisicaDTO) throws UfInexistenteException,
			PerfilPessoaInexistenteException, InstituicaoEnsinoInexistenteException, GrauInstrucaoInexistenteException {
		Pessoa pessoa = new Pessoa();

		pessoa.setAtivo(true);
		pessoa.setEmail(pessoaFisicaDTO.getEmail());
		
		if(!pessoaFisicaDTO.getSenha().equals("")) {
			pessoa.setSenha(bCryptPasswordEncoder.encode(pessoaFisicaDTO.getSenha()));
		}
		
		pessoa.setNome(pessoaFisicaDTO.getNome());
		
		if(pessoaFisicaDTO.getInstituicaoEnsino() != null) {
			pessoa.setInstituicaoEnsino(instituicaoEnsinoService.findByNome(pessoaFisicaDTO.getInstituicaoEnsino()));
		}
		
		if(pessoaFisicaDTO.getGrauInstrucao() != null) {
			pessoa.setGrauInstrucao(grauInstrucaoService.findByGrau(pessoaFisicaDTO.getGrauInstrucao()));	
		}
		
		pessoa.setDataNascimento(pessoaFisicaDTO.getDataNascimento());
		pessoa.setDataCadastro(LocalDate.now());
		pessoa.setDataAtualizacao(LocalDate.now());

		if (pessoaFisicaDTO.getPerfilPessoa() != null) {
			List<PerfilPessoa> perfilPessoaList = new ArrayList<>();
			for (String perfil : pessoaFisicaDTO.getPerfilPessoa()) {
				perfilPessoaList.add(perfilPessoaService.findPerfilPessoaByPerfil(perfil));
			}
			pessoa.setPerfilPessoa(perfilPessoaList);
		}

		if (pessoaFisicaDTO.getTelefones() != null) {
			List<Telefone> telefones = new ArrayList<>();
			for (TelefoneDTO telefoneDTO : pessoaFisicaDTO.getTelefones()) {
				Telefone telefone = telefoneMapper.telefoneDtoToTelefone(telefoneDTO);
				telefone.setPessoa(pessoa);

				telefones.add(telefone);
			}
			pessoa.setTelefones(telefones);
		}

		if (pessoaFisicaDTO.getEnderecos() != null) {
			List<Endereco> enderecos = new ArrayList<>();
			for (EnderecoDTO enderecoDTO : pessoaFisicaDTO.getEnderecos()) {
				Endereco endereco = enderecoMapper.enderecoDtoToEndereco(enderecoDTO);
				endereco.setPessoa(pessoa);

				enderecos.add(endereco);
			}
			pessoa.setEnderecos(enderecos);
		}

		return pessoa;
	}
	
	public PessoaOutDTO pessoaToPessoaOutDto(Pessoa pessoa) {
		PessoaOutDTO dto = new PessoaOutDTO();
		
		dto.setId(pessoa.getId());
		dto.setEmail(pessoa.getEmail());
		dto.setTelefones(pessoa.getTelefones());
		dto.setEnderecos(pessoa.getEnderecos());
		dto.setRazaoSocial(pessoa.getRazaoSocial());
		dto.setNomeFantasia(pessoa.getNomeFantasia());
		dto.setCnpj(pessoa.getCnpj());
		dto.setAtividadeEconomica(pessoa.getAtividadeEconomica());
		dto.setPerfilPessoa(pessoa.getPerfilPessoa());
		dto.setNome(pessoa.getNome());
		dto.setDataNascimento(pessoa.getDataNascimento());
		dto.setInstituicaoEnsino(pessoa.getInstituicaoEnsino());
		dto.setGrauInstrucao(pessoa.getGrauInstrucao());
		
		return dto;
	}
}
