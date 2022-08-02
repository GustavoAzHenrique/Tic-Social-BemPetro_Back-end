package br.com.ticsocial.bemPetro.dtos;

import java.time.LocalDate;

import br.com.ticsocial.bemPetro.models.StatusPublicacao;

public class NoticiaOutDTO {
	private Integer id;
	private String nome;
	private String subTitulo;
	private String conteudo;
	private String imagemPrimaria;
	private String imagemSecundaria;
	private StatusPublicacao status;
	private LocalDate dataCadastro;
	private LocalDate dataAtualizacao;
	private Boolean isFavorito;
	
	
	public NoticiaOutDTO() {
		super();
	}


	public NoticiaOutDTO(Integer id, String nome, String subTitulo, String conteudo, String imagemPrimaria,
			String imagemSecundaria, StatusPublicacao status, LocalDate dataCadastro, LocalDate dataAtualizacao,
			Boolean isFavorito) {
		super();
		this.id = id;
		this.nome = nome;
		this.subTitulo = subTitulo;
		this.conteudo = conteudo;
		this.imagemPrimaria = imagemPrimaria;
		this.imagemSecundaria = imagemSecundaria;
		this.status = status;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
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


	public String getConteudo() {
		return conteudo;
	}


	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}


	public String getImagemPrimaria() {
		return imagemPrimaria;
	}


	public void setImagemPrimaria(String imagemPrimaria) {
		this.imagemPrimaria = imagemPrimaria;
	}


	public String getImagemSecundaria() {
		return imagemSecundaria;
	}


	public void setImagemSecundaria(String imagemSecundaria) {
		this.imagemSecundaria = imagemSecundaria;
	}


	public StatusPublicacao getStatus() {
		return status;
	}


	public void setStatus(StatusPublicacao status) {
		this.status = status;
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


	public Boolean getIsFavorito() {
		return isFavorito;
	}


	public void setIsFavorito(Boolean isFavorito) {
		this.isFavorito = isFavorito;
	}
}
