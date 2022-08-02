package br.com.ticsocial.bemPetro.dtos;

import javax.validation.constraints.NotNull;

public class TipoEventoDTO {
	@NotNull
	private String tipo;

	public TipoEventoDTO(@NotNull String tipo) {
		super();
		this.tipo = tipo;
	}

	public TipoEventoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
