package br.com.ticsocial.bemPetro.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Oportunidade {
	
	@Id
	@Column(name = "opn_cd_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "opn_tx_empresa")
	private String empresa;
	
	@Column(name = "opn_tx_titulo")
	private String titulo;
	
	@Column(name = "opn_tx_descricao")
	private String descricao;
	
	@Column(name = "opn_tx_cargo")
	private String cargo;
	
	@Column(name = "opn_tx_requisito")
	private String requisito;
	
	@Column(name = "opn_nu_salario")
	private Double salario;
	
	@Column(name = "opn_tx_beneficio")
	private String beneficio;
	
	@Column(name = "opn_nu_quantidade_vaga")
	private Integer quantidadeVaga;
	
	@Column(name = "opn_dt_validade_inicio")
	private LocalDate dataValidadeInicio;
	
	@Column(name = "opn_dt_validade_fim")
	private LocalDate dataValidadeFim;
	
	@Column(name = "opn_tx_contato")
	private String contatoNome;
	
	@OneToMany(mappedBy = "oportunidade", cascade = CascadeType.ALL)
	private List<Telefone> contatoTelefones;
	
	@Column(name = "opn_tx_contato_email")
	private String contatoEmail;
	
	@ManyToOne
	@JoinColumn(name = "mun_ibge_cd_id")
	private Municipio municipio;
	
	@ManyToOne
	@JoinColumn(name = "mct_cd_id")
	private ModalidadeContratacao modalidade;
	
	@ManyToOne
	@JoinColumn(name = "tjd_cd_id")
	private TipoJornada jornada;
	
	@Column(name = "opn_bl_ativo")
	private boolean ativo;
	
	@ManyToOne
	@JoinColumn(name = "stp_cd_id")
	private StatusPublicacao status;
	
	@Column(name = "opn_dt_cadastro")
	private LocalDate dataCadastro;

	@Column(name = "opn_dt_atualizacao")
	private LocalDate dataAtualizacao;
	
	@ManyToOne
	@JoinColumn(name = "edt_cd_id")
	private Pessoa pessoaInseriu;
	
	@ManyToOne
	@JoinColumn(name = "rvs_cd_id")
	private Pessoa pessoaRevisou;
	
	@OneToMany(mappedBy = "oportunidade")
	private List<InscricaoOportunidade> inscricoesOportunidades;
	
	@OneToMany(mappedBy = "oportunidade")
	private List<Favorito> favoritos;
	
	
	public Oportunidade() {
		super();
	}


	public Oportunidade(Integer id, String empresa, String titulo, String descricao, String cargo, String requisito,
			Double salario, String beneficio, Integer quantidadeVaga, LocalDate dataValidadeInicio,
			LocalDate dataValidadeFim, String contatoNome, List<Telefone> contatoTelefones, String contatoEmail,
			Municipio municipio, ModalidadeContratacao modalidade, TipoJornada jornada, boolean ativo,
			StatusPublicacao status, LocalDate dataCadastro, LocalDate dataAtualizacao, Pessoa pessoaInseriu,
			Pessoa pessoaRevisou, List<InscricaoOportunidade> inscricoesOportunidades, List<Favorito> favoritos) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.titulo = titulo;
		this.descricao = descricao;
		this.cargo = cargo;
		this.requisito = requisito;
		this.salario = salario;
		this.beneficio = beneficio;
		this.quantidadeVaga = quantidadeVaga;
		this.dataValidadeInicio = dataValidadeInicio;
		this.dataValidadeFim = dataValidadeFim;
		this.contatoNome = contatoNome;
		this.contatoTelefones = contatoTelefones;
		this.contatoEmail = contatoEmail;
		this.municipio = municipio;
		this.modalidade = modalidade;
		this.jornada = jornada;
		this.ativo = ativo;
		this.status = status;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
		this.pessoaInseriu = pessoaInseriu;
		this.pessoaRevisou = pessoaRevisou;
		this.inscricoesOportunidades = inscricoesOportunidades;
		this.favoritos = favoritos;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getRequisito() {
		return requisito;
	}


	public void setRequisito(String requisito) {
		this.requisito = requisito;
	}


	public Double getSalario() {
		return salario;
	}


	public void setSalario(Double salario) {
		this.salario = salario;
	}


	public String getBeneficio() {
		return beneficio;
	}


	public void setBeneficio(String beneficio) {
		this.beneficio = beneficio;
	}


	public Integer getQuantidadeVaga() {
		return quantidadeVaga;
	}


	public void setQuantidadeVaga(Integer quantidadeVaga) {
		this.quantidadeVaga = quantidadeVaga;
	}


	public LocalDate getDataValidadeInicio() {
		return dataValidadeInicio;
	}


	public void setDataValidadeInicio(LocalDate dataValidadeInicio) {
		this.dataValidadeInicio = dataValidadeInicio;
	}


	public LocalDate getDataValidadeFim() {
		return dataValidadeFim;
	}


	public void setDataValidadeFim(LocalDate dataValidadeFim) {
		this.dataValidadeFim = dataValidadeFim;
	}


	public String getContatoNome() {
		return contatoNome;
	}


	public void setContatoNome(String contatoNome) {
		this.contatoNome = contatoNome;
	}


	public List<Telefone> getContatoTelefones() {
		return contatoTelefones;
	}


	public void setContatoTelefones(List<Telefone> contatoTelefones) {
		this.contatoTelefones = contatoTelefones;
	}


	public String getContatoEmail() {
		return contatoEmail;
	}


	public void setContatoEmail(String contatoEmail) {
		this.contatoEmail = contatoEmail;
	}


	public Municipio getMunicipio() {
		return municipio;
	}


	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}


	public ModalidadeContratacao getModalidade() {
		return modalidade;
	}


	public void setModalidade(ModalidadeContratacao modalidade) {
		this.modalidade = modalidade;
	}


	public TipoJornada getJornada() {
		return jornada;
	}


	public void setJornada(TipoJornada jornada) {
		this.jornada = jornada;
	}


	public boolean isAtivo() {
		return ativo;
	}


	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


	public StatusPublicacao getStatus() {
		return status;
	}


	public void setStatus(StatusPublicacao status) {
		this.status = status;
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


	public Pessoa getPessoaInseriu() {
		return pessoaInseriu;
	}


	public void setPessoaInseriu(Pessoa pessoaInseriu) {
		this.pessoaInseriu = pessoaInseriu;
	}


	public Pessoa getPessoaRevisou() {
		return pessoaRevisou;
	}


	public void setPessoaRevisou(Pessoa pessoaRevisou) {
		this.pessoaRevisou = pessoaRevisou;
	}


	public List<InscricaoOportunidade> getInscricoesOportunidades() {
		return inscricoesOportunidades;
	}


	public void setInscricoesOportunidades(List<InscricaoOportunidade> inscricoesOportunidades) {
		this.inscricoesOportunidades = inscricoesOportunidades;
	}


	public List<Favorito> getFavoritos() {
		return favoritos;
	}


	public void setFavoritos(List<Favorito> favoritos) {
		this.favoritos = favoritos;
	}
}
