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
public class CategoriaEventoEsportivo {
	@Id
	@Column(name = "ces_cd_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "ces_tx_esporte")
	private String nome;

	@Column(name = "ces_bl_ativo")
	private Boolean ativo;

	@Column(name = "ces_dt_cadastro")
	private LocalDate dataCadastro;

	@Column(name = "ces_dt_atualizacao")
	private LocalDate dataAtualizacao;

	@JsonIgnore
	@OneToMany(mappedBy = "tipoEvento")
	private List<Evento> eventos;

	public CategoriaEventoEsportivo() {
		super();
	}

	public CategoriaEventoEsportivo(Integer id, String nome, Boolean ativo, LocalDate dataCadastro,
			LocalDate dataAtualizacao) {
		super();
		this.id = id;
		this.nome = nome;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
