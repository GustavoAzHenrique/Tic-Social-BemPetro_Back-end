package br.com.ticsocial.bemPetro.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.ticsocial.bemPetro.models.CategoriaEventoEsportivo;
import br.com.ticsocial.bemPetro.models.StatusPublicacao;
import br.com.ticsocial.bemPetro.models.TipoEvento;

public class EventoOutDTO {
	private Integer id;
	private String nome;
	private String subTitulo;
	private String descricao;
	private LocalDate dataEvento;
	private String imagem;
	private TipoEvento tipoEvento;
	private String organizador;
	private LocalDateTime horaInicio;
	private LocalDateTime horaTermino;
	private String local;
	private Double valorIngresso;
	private CategoriaEventoEsportivo categoriaEventoEsportivo;
	private StatusPublicacao status;
	private Boolean isFavorito;
	
	
	public EventoOutDTO() {
		super();
	}


	public EventoOutDTO(Integer id, String nome, String subTitulo, String descricao, LocalDate dataEvento,
			String imagem, TipoEvento tipoEvento, String organizador, LocalDateTime horaInicio,
			LocalDateTime horaTermino, String local, Double valorIngresso,
			CategoriaEventoEsportivo categoriaEventoEsportivo, StatusPublicacao status, Boolean isFavorito) {
		super();
		this.id = id;
		this.nome = nome;
		this.subTitulo = subTitulo;
		this.descricao = descricao;
		this.dataEvento = dataEvento;
		this.imagem = imagem;
		this.tipoEvento = tipoEvento;
		this.organizador = organizador;
		this.horaInicio = horaInicio;
		this.horaTermino = horaTermino;
		this.local = local;
		this.valorIngresso = valorIngresso;
		this.categoriaEventoEsportivo = categoriaEventoEsportivo;
		this.status = status;
		this.isFavorito = isFavorito;
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


	public String getSubTitulo() {
		return subTitulo;
	}


	public void setSubTitulo(String subTitulo) {
		this.subTitulo = subTitulo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public LocalDate getDataEvento() {
		return dataEvento;
	}


	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}


	public String getImagem() {
		return imagem;
	}


	public void setImagem(String imagem) {
		this.imagem = imagem;
	}


	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}


	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}


	public String getOrganizador() {
		return organizador;
	}


	public void setOrganizador(String organizador) {
		this.organizador = organizador;
	}


	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}


	public void setHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = horaInicio;
	}


	public LocalDateTime getHoraTermino() {
		return horaTermino;
	}


	public void setHoraTermino(LocalDateTime horaTermino) {
		this.horaTermino = horaTermino;
	}


	public String getLocal() {
		return local;
	}


	public void setLocal(String local) {
		this.local = local;
	}


	public Double getValorIngresso() {
		return valorIngresso;
	}


	public void setValorIngresso(Double valorIngresso) {
		this.valorIngresso = valorIngresso;
	}


	public CategoriaEventoEsportivo getCategoriaEventoEsportivo() {
		return categoriaEventoEsportivo;
	}


	public void setCategoriaEventoEsportivo(CategoriaEventoEsportivo categoriaEventoEsportivo) {
		this.categoriaEventoEsportivo = categoriaEventoEsportivo;
	}


	public StatusPublicacao getStatus() {
		return status;
	}


	public void setStatus(StatusPublicacao status) {
		this.status = status;
	}


	public Boolean getIsFavorito() {
		return isFavorito;
	}


	public void setIsFavorito(Boolean isFavorito) {
		this.isFavorito = isFavorito;
	}
}