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
public class Favorito {
	
	@Id
	@Column(name = "fvt_cd_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "evt_cd_id")
	private Evento evento;
	
	@ManyToOne
	@JoinColumn(name = "ntc_cd_id")
	private Noticia noticia;
	
	@ManyToOne
	@JoinColumn(name = "opn_cd_id")
	private Oportunidade oportunidade;
	
	@ManyToOne
	@JoinColumn(name = "pss_cd_id")
	private Pessoa pessoa;
	
	@Column(name = "fvt_bl_ativo")
	private boolean ativo;
	
	@Column(name = "fvt_dt_cadastro")
	private LocalDate dataCadastro;

	@Column(name = "fvt_dt_atualizacao")
	private LocalDate dataAtualizacao;
	
	
	public Favorito() {
		super();
	}

	public Favorito(Integer id, Evento evento, Noticia noticia, Oportunidade oportunidade, Pessoa pessoa, boolean ativo,
			LocalDate dataCadastro, LocalDate dataAtualizacao) {
		super();
		this.id = id;
		this.evento = evento;
		this.noticia = noticia;
		this.oportunidade = oportunidade;
		this.pessoa = pessoa;
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

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

	public Oportunidade getOportunidade() {
		return oportunidade;
	}

	public void setOportunidade(Oportunidade oportunidade) {
		this.oportunidade = oportunidade;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
}
