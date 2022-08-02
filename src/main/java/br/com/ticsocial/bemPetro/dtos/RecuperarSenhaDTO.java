package br.com.ticsocial.bemPetro.dtos;

import javax.validation.constraints.NotNull;

public class RecuperarSenhaDTO {
	
	@NotNull
	private String email;
	
	
	public RecuperarSenhaDTO() {
		super();
	}

	public RecuperarSenhaDTO(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
