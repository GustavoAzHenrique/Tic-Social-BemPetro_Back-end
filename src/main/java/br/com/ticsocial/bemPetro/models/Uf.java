package br.com.ticsocial.bemPetro.models;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "uf")
public class Uf {
	
	@Id
	@Column(name = "uf_ibge_cd_id")
	private Integer id;
	
	@Column(name = "uf_tx_sigla")
	private String sigla;
	
	@Column(name = "uf_tx_estado")
	private String estado;
	
	@OneToMany(mappedBy = "uf")
	@JsonIgnore
	private List<Municipio> municipios;
	
	
	public Uf() {
		super();
	}

	public Uf(Integer id, String sigla, String estado, List<Municipio> municipios) {
		super();
		this.id = id;
		this.sigla = sigla;
		this.estado = estado;
		this.municipios = municipios;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}
}
