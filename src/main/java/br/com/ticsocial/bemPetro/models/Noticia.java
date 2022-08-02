package br.com.ticsocial.bemPetro.models;

import java.time.LocalDate;
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
public class Noticia {
	@Id
	@Column(name = "ntc_cd_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "ntc_tx_titulo")
	private String nome;

	@Column(name = "ntc_tx_subtitulo")
	private String subTitulo;

	@Column(name = "ntc_tx_conteudo")
	private String conteudo;

	@Column(name = "ntc_tx_imagem_principal")
	private String imagemPrimaria;

	@Column(name = "ntc_tx_imagem_secundaria")
	private String imagemSecundaria;

	@Column(name = "ntc_bl_ativo")
	private Boolean ativo;

	@Column(name = "ntc_dt_cadastro")
	private LocalDate dataCadastro;

	@Column(name = "ntc_dt_atualizacao")
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
	
	@OneToMany(mappedBy = "noticia")
	private List<Favorito> favoritos;

	
	public Noticia() {
		super();
	}


	public Noticia(Integer id, String nome, String subTitulo, String conteudo, String imagemPrimaria,
			String imagemSecundaria, Boolean ativo, LocalDate dataCadastro, LocalDate dataAtualizacao,
			StatusPublicacao status, Pessoa pessoaInseriu, Pessoa revisor, List<Favorito> favoritos) {
		super();
		this.id = id;
		this.nome = nome;
		this.subTitulo = subTitulo;
		this.conteudo = conteudo;
		this.imagemPrimaria = imagemPrimaria;
		this.imagemSecundaria = imagemSecundaria;
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


	public String getConteudo() {
		return conteudo;
	}


	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}


	public String getImagemPrimaria() {
		return imagemPrimaria;
	}


	public void setImagemPrimaria(String imagemPrimaria) {
		this.imagemPrimaria = imagemPrimaria;
	}


	public String getImagemSecundaria() {
		return imagemSecundaria;
	}


	public void setImagemSecundaria(String imagemSecundaria) {
		this.imagemSecundaria = imagemSecundaria;
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
