package br.com.ticsocial.bemPetro.dtos;

import javax.validation.constraints.NotNull;

public class PerfilPessoaDTO {
	
	@NotNull
	private String perfil;
	
	
	public PerfilPessoaDTO() {
		super();
	}

	public PerfilPessoaDTO(String perfil) {
		super();
		this.perfil = perfil;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
}
