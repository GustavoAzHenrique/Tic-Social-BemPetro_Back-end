package br.com.ticsocial.bemPetro.dtos;

import javax.validation.constraints.NotNull;

public class AtividadeEconomicaDTO {
	@NotNull
	private String nome;

	private Integer codigo;
	
	
	public AtividadeEconomicaDTO() {
		super();
	}
	public AtividadeEconomicaDTO(String nome, Integer codigo) {
		super();
		this.nome = nome;
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
}
