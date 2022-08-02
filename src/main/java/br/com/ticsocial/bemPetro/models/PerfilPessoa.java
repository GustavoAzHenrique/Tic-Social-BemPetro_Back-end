package br.com.ticsocial.bemPetro.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PerfilPessoa {
	@Id
	@Column(name = "pps_cd_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "pps_tx_perfil")
	private String perfil;

    @Column(name = "pps_bl_ativo")
	private Boolean ativo;

    @Column(name = "pps_dt_cadastro")
	private LocalDate dataCadastro;
	
	@Column(name = "pps_dt_atualizacao")
	private LocalDate dataAtualizacao;
	
	
	public PerfilPessoa() {
		super();
	}

	public PerfilPessoa(Integer id, String perfil, Boolean ativo, LocalDate dataCadastro, LocalDate dataAtualizacao) {
		super();
		this.id = id;
		this.perfil = perfil;
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

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
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
