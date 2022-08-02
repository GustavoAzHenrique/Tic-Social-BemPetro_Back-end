package br.com.ticsocial.bemPetro.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class InscricaoOportunidade {
	
	@Id
    @Column(name = "iod_cd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "pss_cd_id")
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "opn_cd_id")
	private Oportunidade oportunidade;
	
	@Column(name = "iod_bl_ativo")
	private boolean ativo;
	
	@Column(name = "iod_dt_inscricao")
	private LocalDate dataInscricao;
	
	
	public InscricaoOportunidade() {
		super();
	}

	public InscricaoOportunidade(Integer id, Pessoa pessoa, Oportunidade oportunidade, boolean ativo,
			LocalDate dataInscricao) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.oportunidade = oportunidade;
		this.ativo = ativo;
		this.dataInscricao = dataInscricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDate getDataInscricao() {
		return dataInscricao;
	}

	public void setDataInscricao(LocalDate dataInscricao) {
		this.dataInscricao = dataInscricao;
	}
}
