package br.com.ticsocial.bemPetro.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SecondaryTable(name = "pessoa_juridica")
@SecondaryTable(name = "pessoa_fisica")
public class Pessoa {

	@Id
	@Column(name = "pss_cd_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "pss_tx_email")
	private String email;

	@Column(name = "pss_tx_senha")
	private String senha;

	@Column(name = "pss_dt_cadastro")
	private LocalDate dataCadastro;

	@Column(name = "pss_dt_atualizacao")
	private LocalDate dataAtualizacao;

	@Column(name = "pss_bl_ativo")
	private Boolean ativo;

	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
	private List<Telefone> telefones;

	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
	private List<Endereco> enderecos;
	
	@JsonIgnore
	@OneToMany(mappedBy = "pessoaInseriu")
	private List<Oportunidade> oportunidadesInseridas;
	
	@JsonIgnore
	@OneToMany(mappedBy = "pessoaRevisou")
	private List<Oportunidade> oportunidadesRevisadas;
	
	@OneToMany(mappedBy = "pessoa")
	private List<InscricaoOportunidade> inscricoesOportunidades;

	// Pessoa Juridica
	@Column(name = "pss_tx_razao_social", table = "pessoa_juridica")

	private String razaoSocial;

	@Column(name = "pss_tx_nome_fantasia", table = "pessoa_juridica")
	private String nomeFantasia;

	@Column(name = "pss_nu_cnpj", table = "pessoa_juridica")
	private String cnpj;

	@ManyToOne
	@JoinColumn(name = "ate_cd_id", table = "pessoa_juridica")
	private AtividadeEconomica atividadeEconomica;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "pessoa_rel_perfil", joinColumns = @JoinColumn(name = "pss_cd_id"), inverseJoinColumns = @JoinColumn(name = "pps_cd_id"))
	private List<PerfilPessoa> perfilPessoa;

	// Pessoa Física

	@Column(name = "pss_tx_nome ", table = "pessoa_fisica")
	private String nome;

	@Column(name = "pss_dt_nascimento ", table = "pessoa_fisica")
	private LocalDate dataNascimento;

	@ManyToOne
	@JoinColumn(name = "ins_cd_id", table = "pessoa_fisica")
	private InstituicaoEnsino instituicaoEnsino;

	@ManyToOne
	@JoinColumn(name = "gre_cd_id", table = "pessoa_fisica")
	private GrauInstrucao grauInstrucao;

	// Eventos
//	@ManyToOne
//	@JoinColumn(name = "evt_cd_id", referencedColumnName = "evt_cd_id")
//	private Evento evento;
	
	@JsonIgnore
	@OneToMany(mappedBy = "pessoaInseriu")
	private List<Evento> eventosIseridos;
	
	@JsonIgnore
	@OneToMany(mappedBy = "revisor")
	private List<Evento> eventosRevisor;
	
	@JsonIgnore
	@OneToMany(mappedBy = "pessoaInseriu")
	private List<Noticia> noticiasIseridas;
	
	@JsonIgnore
	@OneToMany(mappedBy = "revisor")
	private List<Noticia> noticiasRevisor;

	
	public Pessoa() {
		super();
	}

	public Pessoa(Integer id, String email, String senha, LocalDate dataCadastro, LocalDate dataAtualizacao,
			Boolean ativo, List<Telefone> telefones, List<Endereco> enderecos,
			List<Oportunidade> oportunidadesInseridas, List<Oportunidade> oportunidadesRevisadas,
			List<InscricaoOportunidade> inscricoesOportunidades, String razaoSocial, String nomeFantasia, String cnpj,
			AtividadeEconomica atividadeEconomica, List<PerfilPessoa> perfilPessoa, String nome,
			LocalDate dataNascimento, InstituicaoEnsino instituicaoEnsino, GrauInstrucao grauInstrucao,
			List<Evento> eventosIseridos, List<Evento> eventosRevisor, List<Noticia> noticiasIseridas,
			List<Noticia> noticiasRevisor) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
		this.ativo = ativo;
		this.telefones = telefones;
		this.enderecos = enderecos;
		this.oportunidadesInseridas = oportunidadesInseridas;
		this.oportunidadesRevisadas = oportunidadesRevisadas;
		this.inscricoesOportunidades = inscricoesOportunidades;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.atividadeEconomica = atividadeEconomica;
		this.perfilPessoa = perfilPessoa;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.instituicaoEnsino = instituicaoEnsino;
		this.grauInstrucao = grauInstrucao;
		this.eventosIseridos = eventosIseridos;
		this.eventosRevisor = eventosRevisor;
		this.noticiasIseridas = noticiasIseridas;
		this.noticiasRevisor = noticiasRevisor;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDate getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
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

	public List<Oportunidade> getOportunidadesInseridas() {
		return oportunidadesInseridas;
	}

	public void setOportunidadesInseridas(List<Oportunidade> oportunidadesInseridas) {
		this.oportunidadesInseridas = oportunidadesInseridas;
	}

	public List<Oportunidade> getOportunidadesRevisadas() {
		return oportunidadesRevisadas;
	}

	public void setOportunidadesRevisadas(List<Oportunidade> oportunidadesRevisadas) {
		this.oportunidadesRevisadas = oportunidadesRevisadas;
	}

	public List<InscricaoOportunidade> getInscricoesOportunidades() {
		return inscricoesOportunidades;
	}

	public void setInscricoesOportunidades(List<InscricaoOportunidade> inscricoesOportunidades) {
		this.inscricoesOportunidades = inscricoesOportunidades;
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

	public List<Evento> getEventosIseridos() {
		return eventosIseridos;
	}

	public void setEventosIseridos(List<Evento> eventosIseridos) {
		this.eventosIseridos = eventosIseridos;
	}

	public List<Evento> getEventosRevisor() {
		return eventosRevisor;
	}

	public void setEventosRevisor(List<Evento> eventosRevisor) {
		this.eventosRevisor = eventosRevisor;
	}

	public List<Noticia> getNoticiasIseridas() {
		return noticiasIseridas;
	}

	public void setNoticiasIseridas(List<Noticia> noticiasIseridas) {
		this.noticiasIseridas = noticiasIseridas;
	}

	public List<Noticia> getNoticiasRevisor() {
		return noticiasRevisor;
	}

	public void setNoticiasRevisor(List<Noticia> noticiasRevisor) {
		this.noticiasRevisor = noticiasRevisor;
	}
}