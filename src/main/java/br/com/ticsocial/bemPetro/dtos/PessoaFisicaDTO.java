package br.com.ticsocial.bemPetro.dtos;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public class PessoaFisicaDTO {

	@Email(message = "Email inválido")
	@NotNull
	private String email;
	
	@NotNull
	private String senha;
	
	@NotNull
	@Past(message = "Data de nascimento deve ser anterior a data atual")
	private LocalDate dataNascimento;
	
	@NotNull
	private String nome;
	
	private String instituicaoEnsino;
	
	private String grauInstrucao;
	
	private List<String> perfilPessoa;
	
	private List<TelefoneDTO> telefones;
	
	private List<EnderecoDTO> enderecos;
	
	public PessoaFisicaDTO() {
		super();
	}

	public PessoaFisicaDTO(@Email @NotNull String email, @NotNull String senha, @NotNull LocalDate dataNascimento,
			@NotNull String nome, @NotNull String instituicaoEnsino, @NotNull String grauInstrucao,
			List<String> perfilPessoa, @NotNull List<TelefoneDTO> telefones, @NotNull List<EnderecoDTO> enderecos) {
		super();
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.nome = nome;
		this.instituicaoEnsino = instituicaoEnsino;
		this.grauInstrucao = grauInstrucao;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInstituicaoEnsino() {
		return instituicaoEnsino;
	}

	public void setInstituicaoEnsino(String instituicaoEnsino) {
		this.instituicaoEnsino = instituicaoEnsino;
	}

	public String getGrauInstrucao() {
		return grauInstrucao;
	}

	public void setGrauInstrucao(String grauInstrucao) {
		this.grauInstrucao = grauInstrucao;
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
