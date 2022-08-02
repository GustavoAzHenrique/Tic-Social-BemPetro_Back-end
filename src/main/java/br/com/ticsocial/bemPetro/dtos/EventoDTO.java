package br.com.ticsocial.bemPetro.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

public class EventoDTO {

	@NotNull
	private String nome;

	@NotNull
	private String subTitulo;

	@NotNull
	private LocalDate dataEvento;

	@NotNull
	private String descricao;

	private String imagem;

	@NotNull
	private String tipoEvento;

	@NotNull
	private String organizador;

	@NotNull
	private LocalDateTime horaInicio;

	@NotNull
	private LocalDateTime horaTermino;

	@NotNull
	private String local;

	@NotNull
	private Double valorIngresso;

	private String categoriaEventoEsportivo;


	public EventoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EventoDTO(@NotNull String nome, @NotNull String subTitulo, @NotNull LocalDate dataEvento,
			@NotNull String descricao, String imagem, @NotNull String tipoEvento, @NotNull String organizador,
			@NotNull LocalDateTime horaInicio, @NotNull LocalDateTime horaTermino, @NotNull String local,
			@NotNull Double valorIngresso, @NotNull String categoriaEventoEsportivo) {
		super();
		this.nome = nome;
		this.subTitulo = subTitulo;
		this.dataEvento = dataEvento;
		this.descricao = descricao;
		this.imagem = imagem;
		this.tipoEvento = tipoEvento;
		this.organizador = organizador;
		this.horaInicio = horaInicio;
		this.horaTermino = horaTermino;
		this.local = local;
		this.valorIngresso = valorIngresso;
		this.categoriaEventoEsportivo = categoriaEventoEsportivo;
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


	public LocalDate getDataEvento() {
		return dataEvento;
	}


	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getImagem() {
		return imagem;
	}


	public void setImagem(String imagem) {
		this.imagem = imagem;
	}


	public String getTipoEvento() {
		return tipoEvento;
	}


	public void setTipoEvento(String tipoEvento) {
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


	public String getCategoriaEventoEsportivo() {
		return categoriaEventoEsportivo;
	}


	public void setCategoriaEventoEsportivo(String categoriaEventoEsportivo) {
		this.categoriaEventoEsportivo = categoriaEventoEsportivo;
	}
}
