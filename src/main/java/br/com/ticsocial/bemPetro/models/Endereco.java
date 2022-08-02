package br.com.ticsocial.bemPetro.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "endereco")
public class Endereco {
	
	@Id
	@Column(name = "end_cd_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "end_tx_logradouro")
	private String logradouro;
	
	@Column(name = "end_nu_logradouro_numero")
	private Integer numero;
	
	@Column(name = "end_tx_logradouro_complemento")
	private String complemento;
	
	@Column(name = "end_tx_cep")
	private String cep;
	
	@ManyToOne
	@JoinColumn(name = "mun_ibge_cd_id")
	private Municipio municipio;
	
	@ManyToOne
	@JoinColumn(name = "pss_cd_id")
	@JsonIgnore
	private Pessoa pessoa;
	
	
	public Endereco() {
		super();
	}


	public Endereco(Integer id, String logradouro, Integer numero, String complemento, String cep, Municipio municipio,
			Pessoa pessoa) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.municipio = municipio;
		this.pessoa = pessoa;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public Municipio getMunicipio() {
		return municipio;
	}


	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
