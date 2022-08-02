package br.com.ticsocial.bemPetro.dtos;

import javax.validation.constraints.NotNull;

public class NoticiaDTO {

	@NotNull
	private String nome;

	@NotNull
	private String subTitulo;

	@NotNull
	private String conteudo;

	@NotNull
	private String imagemPrimaria;

	private String imagemSecundaria;
	

	public NoticiaDTO() {
		super();
	}


	public NoticiaDTO(@NotNull String nome, @NotNull String subTitulo, @NotNull String conteudo,
			@NotNull String imagemPrimaria, String imagemSecundaria) {
		super();
		this.nome = nome;
		this.subTitulo = subTitulo;
		this.conteudo = conteudo;
		this.imagemPrimaria = imagemPrimaria;
		this.imagemSecundaria = imagemSecundaria;
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
}
