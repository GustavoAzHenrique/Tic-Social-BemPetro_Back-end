package br.com.ticsocial.bemPetro.dtos;

public class TipoJornadaDTO {
	private String tipo;
	

	public TipoJornadaDTO() {
		super();
	}

	public TipoJornadaDTO(String tipo) {
		super();
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
