package br.com.ticsocial.bemPetro.dtos;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;

public class PessoaJuridicaDTO {
	
	@Email(message = "Email inválido")
	@NotNull
	private String email;
	
	@NotNull
	private String senha;
	
	@NotNull
	private String nomeFantasia;
	
	@CNPJ(message = "CNPJ inválido")
	private String cnpj;
	
	@NotNull
	private String razaoSocial;
	
	@NotNull
	private String atividadeEconomica;
	
	@NotNull
	private List<String> perfilPessoa;

	private List<TelefoneDTO> telefones;

	private List<EnderecoDTO> enderecos;
	
	
	public PessoaJuridicaDTO() {
		super();
	}

	public PessoaJuridicaDTO(String email, String senha, String nomeFantasia, String cnpj, String razaoSocial,
			String atividadeEconomica, List<String> perfilPessoa, List<TelefoneDTO> telefones,
			List<EnderecoDTO> enderecos) {
		super();
		this.email = email;
		this.senha = senha;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.atividadeEconomica = atividadeEconomica;
		this.perfilPessoa = perfilPessoa;
		this.telefones = telefones;
		this.enderecos = enderecos;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getNomeFantasia() {
		return nomeFantasia;
	}


	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getRazaoSocial() {
		return razaoSocial;
	}


	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}


	public String getAtividadeEconomica() {
		return atividadeEconomica;
	}


	public void setAtividadeEconomica(String atividadeEconomica) {
		this.atividadeEconomica = atividadeEconomica;
	}


	public List<String> getPerfilPessoa() {
		return perfilPessoa;
	}


	public void setPerfilPessoa(List<String> perfilPessoa) {
		this.perfilPessoa = perfilPessoa;
	}


	public List<TelefoneDTO> getTelefones() {
		return telefones;
	}


	public void setTelefones(List<TelefoneDTO> telefones) {
		this.telefones = telefones;
	}


	public List<EnderecoDTO> getEnderecos() {
		return enderecos;
	}


	public void setEnderecos(List<EnderecoDTO> enderecos) {
		this.enderecos = enderecos;
	}
}
