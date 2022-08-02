package br.com.ticsocial.bemPetro.dtos;

import javax.validation.constraints.NotNull;

public class CategoriaEventoEsportivoDTO {
	@NotNull
	private String nome;

	public CategoriaEventoEsportivoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoriaEventoEsportivoDTO(@NotNull String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
