package br.com.ticsocial.bemPetro.dtos;

import java.time.LocalDate;
import java.util.List;

import br.com.ticsocial.bemPetro.models.AtividadeEconomica;
import br.com.ticsocial.bemPetro.models.Endereco;
import br.com.ticsocial.bemPetro.models.GrauInstrucao;
import br.com.ticsocial.bemPetro.models.InstituicaoEnsino;
import br.com.ticsocial.bemPetro.models.PerfilPessoa;
import br.com.ticsocial.bemPetro.models.Telefone;

public class PessoaOutDTO {
	private Integer id;
	private String email;
	private List<Telefone> telefones;
	private List<Endereco> enderecos;
	private String razaoSocial;
	private String nomeFantasia;
	private String cnpj;
	private AtividadeEconomica atividadeEconomica;
	private List<PerfilPessoa> perfilPessoa;
	private String nome;
	private LocalDate dataNascimento;
	private InstituicaoEnsino instituicaoEnsino;
	private GrauInstrucao grauInstrucao;
	
	
	public PessoaOutDTO() {
		super();
	}


	public PessoaOutDTO(Integer id, String email, List<Telefone> telefones, List<Endereco> enderecos,
			String razaoSocial, String nomeFantasia, String cnpj, AtividadeEconomica atividadeEconomica,
			List<PerfilPessoa> perfilPessoa, String nome, LocalDate dataNascimento, InstituicaoEnsino instituicaoEnsino,
			GrauInstrucao grauInstrucao) {
		super();
		this.id = id;
		this.email = email;
		this.telefones = telefones;
		this.enderecos = enderecos;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.atividadeEconomica = atividadeEconomica;
		this.perfilPessoa = perfilPessoa;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.instituicaoEnsino = instituicaoEnsino;
		this.grauInstrucao = grauInstrucao;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Telefone> getTelefones() {
		return telefones;
	}


	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}


	public List<Endereco> getEnderecos() {
		return enderecos;
	}


	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}


	public String getRazaoSocial() {
		return razaoSocial;
	}


	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
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


	public AtividadeEconomica getAtividadeEconomica() {
		return atividadeEconomica;
	}


	public void setAtividadeEconomica(AtividadeEconomica atividadeEconomica) {
		this.atividadeEconomica = atividadeEconomica;
	}


	public List<PerfilPessoa> getPerfilPessoa() {
		return perfilPessoa;
	}


	public void setPerfilPessoa(List<PerfilPessoa> perfilPessoa) {
		this.perfilPessoa = perfilPessoa;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public InstituicaoEnsino getInstituicaoEnsino() {
		return instituicaoEnsino;
	}


	public void setInstituicaoEnsino(InstituicaoEnsino instituicaoEnsino) {
		this.instituicaoEnsino = instituicaoEnsino;
	}


	public GrauInstrucao getGrauInstrucao() {
		return grauInstrucao;
	}


	public void setGrauInstrucao(GrauInstrucao grauInstrucao) {
		this.grauInstrucao = grauInstrucao;
	}
}
