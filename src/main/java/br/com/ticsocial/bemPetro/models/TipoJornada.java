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
public class TipoJornada {
	
	@Id
	@Column(name = "tjd_cd_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "tjd_tx_tipo")
	private String tipo;
	
	@Column(name = "tjd_bl_ativo")
	private boolean ativo;
	
	@Column(name = "tjd_dt_cadastro")
	private LocalDate dataCadastro;

    @Column(name = "tjd_dt_atualizacao")
	private LocalDate dataAtualizacao;
    
    @JsonIgnore
    @OneToMany(mappedBy = "jornada")
    private List<Oportunidade> oportunidades;
    
    
	public TipoJornada() {
		super();
	}

	public TipoJornada(Integer id, String tipo, boolean ativo, LocalDate dataCadastro, LocalDate dataAtualizacao,
			List<Oportunidade> oportunidades) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.ativo = ativo;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
		this.oportunidades = oportunidades;
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

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
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

	public List<Oportunidade> getOportunidades() {
		return oportunidades;
	}

	public void setOportunidades(List<Oportunidade> oportunidades) {
		this.oportunidades = oportunidades;
	}
}
