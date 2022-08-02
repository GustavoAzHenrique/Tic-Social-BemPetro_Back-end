package br.com.ticsocial.bemPetro.dtos;

import javax.validation.constraints.NotNull;

public class GrauInstrucaoDTO {
	@NotNull
	private String grau;

	public GrauInstrucaoDTO(String grau) {
		super();
		this.grau = grau;
	}

	public GrauInstrucaoDTO() {
		super();
	}

	public String getGrau() {
		return grau;
	}

	public void setGrau(String grau) {
		this.grau = grau;
	}

}
