package br.com.ticsocial.bemPetro.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AtividadeEconomica {
	
	@Id
	@Column(name = "ate_cd_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "ate_tx_atividade")
	private String nome;

    @Column(name = "ate_nu_atividade")
	private Integer codigo;

    @Column(name = "ate_bl_ativo")
	private Boolean ativo;

    @Column(name = "ate_dt_cadastro")
	private LocalDate dataCadastro;

    @Column(name = "ate_dt_atualizacao")
	private LocalDate dataAtualizacao;
    
    @OneToMany(mappedBy = "atividadeEconomica")
    private List<Pessoa> pessoa;
    
    
	public AtividadeEconomica() {
		super();
	}

	public AtividadeEconomica(Integer id, String nome, Integer codigo, Boolean ativo, LocalDate dataCadastro,
			LocalDate dataAtualizacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
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

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
