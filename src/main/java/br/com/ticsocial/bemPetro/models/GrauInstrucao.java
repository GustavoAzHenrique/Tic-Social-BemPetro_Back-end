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
public class GrauInstrucao {
	@Id
    @Column(name = "gre_cd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "gre_tx_grau")
    private String grau;

    @Column(name = "gre_bl_ativo")
    private Boolean ativo;

    @Column(name = "gre_dt_cadastro")
    private LocalDate dataCadastro;

    @Column(name = "gre_dt_atualizacao")
    private LocalDate dataAtualizacao;

    @JsonIgnore
    @OneToMany(mappedBy = "grauInstrucao")
    private List<Pessoa> pessoa;
    
	public GrauInstrucao() {
		super();
	}

	public GrauInstrucao(Integer id, String grau, Boolean ativo, LocalDate dataCadastro, LocalDate dataAtualizacao,
			List<Pessoa> pessoa) {
		super();
		this.id = id;
		this.grau = grau;
		this.ativo = ativo;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
		this.pessoa = pessoa;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGrau() {
		return grau;
	}

	public void setGrau(String grau) {
		this.grau = grau;
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

	public List<Pessoa> getPessoa() {
		return pessoa;
	}

	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}
    
    
}
