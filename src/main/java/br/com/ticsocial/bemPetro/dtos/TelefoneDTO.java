package br.com.ticsocial.bemPetro.dtos;

public class TelefoneDTO {
	private Integer ddd;
	private Integer numero;

	public TelefoneDTO() {
		super();
	}

	public TelefoneDTO(Integer ddd, Integer numero) {
		super();
		this.ddd = ddd;
		this.numero = numero;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
}
