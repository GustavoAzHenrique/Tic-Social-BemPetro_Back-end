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
public class ModalidadeContratacao {
	
	@Id
	@Column(name = "mct_cd_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "mct_tx_modalidade")
	private String modalidade;
	
	@Column(name = "mct_bl_ativo")
	private boolean ativo;
	
	@Column(name = "mct_dt_cadastro")
	private LocalDate dataCadastro;

    @Column(name = "mct_dt_atualizacao")
	private LocalDate dataAtualizacao;
    
    @JsonIgnore
    @OneToMany(mappedBy = "modalidade")
    private List<Oportunidade> oportunidades;
    
    
	public ModalidadeContratacao() {
		super();
	}

	public ModalidadeContratacao(Integer id, String modalidade, boolean ativo, LocalDate dataCadastro,
			LocalDate dataAtualizacao, List<Oportunidade> oportunidades) {
		super();
		this.id = id;
		this.modalidade = modalidade;
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

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean b) {
		this.ativo = b;
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
