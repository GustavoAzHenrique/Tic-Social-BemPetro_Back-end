package br.com.ticsocial.bemPetro.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TermoUso {
	
	@Id
	@Column(name = "tuo_cd_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "tuo_tx_titulo")
	private String titulo;
	
	@Column(name = "tuo_tx_subtitulo")
	private String subtitulo;
	
	@Column(name = "tuo_tx_descricao")
	private String descricao;
	
	@Column(name = "tuo_bl_ativo")
	private Boolean ativo;

	@Column(name = "tuo_dt_cadastro")
	private LocalDate dataCadastro;

	@Column(name = "tuo_dt_atualizacao")
	private LocalDate dataAtualizacao;
	
	
	public TermoUso() {
		super();
	}

	public TermoUso(Integer id, String titulo, String subtitulo, String descricao, Boolean ativo,
			LocalDate dataCadastro, LocalDate dataAtualizacao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.descricao = descricao;
		this.ativo = ativo;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
}
