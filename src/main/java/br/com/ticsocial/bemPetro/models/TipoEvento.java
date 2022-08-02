package br.com.ticsocial.bemPetro.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TipoEvento {
	@Id
	@Column(name = "tvt_cd_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "tvt_tx_tipo")
	private String tipo;

	@Column(name = "tvt_bl_ativo")
	private Boolean ativo;

	@Column(name = "tvt_dt_cadastro")
	private LocalDate dataCadastro;

	@Column(name = "tvt_dt_atualizacao")
	private LocalDate dataAtualizacao;

	@JsonIgnore
	@OneToMany(mappedBy = "tipoEvento")
	private List<Evento> eventos;

	public TipoEvento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoEvento(Integer id, String tipo, Boolean ativo, LocalDate dataCadastro, LocalDate dataAtualizacao) {
		super();
		this.id = id;
		this.tipo = tipo;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
