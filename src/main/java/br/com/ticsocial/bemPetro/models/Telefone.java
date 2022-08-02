package br.com.ticsocial.bemPetro.models;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Telefone {
	
	@Id
	@Column(name = "tel_cd_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "tel_nu_ddd")
	private Integer ddd;
	
	@Column(name = "tel_nu_numero")
	private Integer numero;
	
	@Column(name = "tel_bl_ativo")
	private Boolean ativo;
	
	@Column(name = "tel_dt_cadastro")
	private LocalDate dt_cadastro;

	@Column(name = "tel_dt_atualizacao")
	private LocalDate dt_atualizacao;

	@ManyToOne
	@JoinColumn(name = "pss_cd_id", referencedColumnName = "pss_cd_id")
	@JsonIgnore
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "opn_cd_id", referencedColumnName = "opn_cd_id")
	@JsonIgnore
	private Oportunidade oportunidade;
	

	public Telefone() {
		super();
	}


	public Telefone(Integer id, Integer ddd, Integer numero, Boolean ativo, LocalDate dt_cadastro,
			LocalDate dt_atualizacao, Pessoa pessoa, Oportunidade oportunidade) {
		super();
		this.id = id;
		this.ddd = ddd;
		this.numero = numero;
		this.ativo = ativo;
		this.dt_cadastro = dt_cadastro;
		this.dt_atualizacao = dt_atualizacao;
		this.pessoa = pessoa;
		this.oportunidade = oportunidade;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getDdd() {
		return ddd;
	}


	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public Boolean getAtivo() {
		return ativo;
	}


	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}


	public LocalDate getDt_cadastro() {
		return dt_cadastro;
	}


	public void setDt_cadastro(LocalDate dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}


	public LocalDate getDt_atualizacao() {
		return dt_atualizacao;
	}


	public void setDt_atualizacao(LocalDate dt_atualizacao) {
		this.dt_atualizacao = dt_atualizacao;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public Oportunidade getOportunidade() {
		return oportunidade;
	}


	public void setOportunidade(Oportunidade oportunidade) {
		this.oportunidade = oportunidade;
	}
}
