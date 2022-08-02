package br.com.ticsocial.bemPetro.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Municipio {
	
	@Id
	@Column(name = "mun_ibge_cd_id")
	private Integer id;
	
	@Column(name = "mun_tx_nome")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "uf_ibge_cd_id")
	private Uf uf;
	
	@OneToMany(mappedBy = "municipio")
	private List<Endereco> enderecos;
	
	
	public Municipio() {
		super();
	}

	public Municipio(Integer id, String nome, Uf uf) {
		super();
		this.id = id;
		this.nome = nome;
		this.uf = uf;
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

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}
}
