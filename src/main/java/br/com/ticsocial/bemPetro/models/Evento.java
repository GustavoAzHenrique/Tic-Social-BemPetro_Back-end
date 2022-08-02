package br.com.ticsocial.bemPetro.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Evento {
	@Id
	@Column(name = "evt_cd_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "evt_tx_titulo")
	private String nome;

	@Column(name = "evt_tx_subtitulo")
	private String subTitulo;

	@Column(name = "evt_tx_descricao")
	private String descricao;

	@Column(name = "evt_dt_evento")
	private LocalDate dataEvento;

	@Column(name = "evt_tx_imagem")
	private String imagem;

	@ManyToOne
	@JoinColumn(name = "tvt_cd_id", referencedColumnName = "tvt_cd_id")
	private TipoEvento tipoEvento;

	@Column(name = "evt_tx_organizador")
	private String organizador;

	@Column(name = "evt_hr_inicio")
	private LocalDateTime horaInicio;

	@Column(name = "evt_hr_termino")
	private LocalDateTime horaTermino;

	@Column(name = "evt_tx_local")
	private String local;

	@Column(name = "evt_nu_valor_ingresso")
	private Double valorIngresso;

	@ManyToOne
	@JoinColumn(name = "ces_cd_id", referencedColumnName = "ces_cd_id")
	private CategoriaEventoEsportivo categoriaEventoEsportivo;

	@Column(name = "evt_bl_ativo")
	private Boolean ativo;

	@Column(name = "evt_dt_cadastro")
	private LocalDate dataCadastro;

	@Column(name = "evt_dt_atualizacao")
	private LocalDate dataAtualizacao;

	@ManyToOne
	@JoinColumn(name = "stp_cd_id")
	private StatusPublicacao status;

	@ManyToOne
	@JoinColumn(name = "edt_cd_id")
	private Pessoa pessoaInseriu;

	@ManyToOne
	@JoinColumn(name = "rvs_cd_id")
	private Pessoa revisor;

	@OneToMany(mappedBy = "evento")
	private List<Favorito> favoritos;

//	@JsonIgnore
//	@OneToMany(mappedBy = "evento")
//	private List<Pessoa> pessoa;

	public Evento() {
		super();
	}

	public Evento(Integer id, String nome, String subTitulo, String descricao, LocalDate dataEvento, String imagem,
			TipoEvento tipoEvento, String organizador, LocalDateTime horaInicio, LocalDateTime horaTermino,
			String local, Double valorIngresso, CategoriaEventoEsportivo categoriaEventoEsportivo, Boolean ativo,
			LocalDate dataCadastro, LocalDate dataAtualizacao, StatusPublicacao status, Pessoa pessoaInseriu,
			Pessoa revisor, List<Favorito> favoritos) {
		super();
		this.id = id;
		this.nome = nome;
		this.subTitulo = subTitulo;
		this.descricao = descricao;
		this.dataEvento = dataEvento;
		this.imagem = imagem;
		this.tipoEvento = tipoEvento;
		this.organizador = organizador;
		this.horaInicio = horaInicio;
		this.horaTermino = horaTermino;
		this.local = local;
		this.valorIngresso = valorIngresso;
		this.categoriaEventoEsportivo = categoriaEventoEsportivo;
		this.ativo = ativo;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
		this.status = status;
		this.pessoaInseriu = pessoaInseriu;
		this.revisor = revisor;
		this.favoritos = favoritos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSubTitulo() {
		return subTitulo;
	}

	public void setSubTitulo(String subTitulo) {
		this.subTitulo = subTitulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getOrganizador() {
		return organizador;
	}

	public void setOrganizador(String organizador) {
		this.organizador = organizador;
	}

	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalDateTime getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(LocalDateTime horaTermino) {
		this.horaTermino = horaTermino;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Double getValorIngresso() {
		return valorIngresso;
	}

	public void setValorIngresso(Double valorIngresso) {
		this.valorIngresso = valorIngresso;
	}

	public CategoriaEventoEsportivo getCategoriaEventoEsportivo() {
		return categoriaEventoEsportivo;
	}

	public void setCategoriaEventoEsportivo(CategoriaEventoEsportivo categoriaEventoEsportivo) {
		this.categoriaEventoEsportivo = categoriaEventoEsportivo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
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

	public StatusPublicacao getStatus() {
		return status;
	}

	public void setStatus(StatusPublicacao status) {
		this.status = status;
	}

	public Pessoa getPessoaInseriu() {
		return pessoaInseriu;
	}

	public void setPessoaInseriu(Pessoa pessoaInseriu) {
		this.pessoaInseriu = pessoaInseriu;
	}

	public Pessoa getRevisor() {
		return revisor;
	}

	public void setRevisor(Pessoa revisor) {
		this.revisor = revisor;
	}

	public List<Favorito> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(List<Favorito> favoritos) {
		this.favoritos = favoritos;
	}
}
