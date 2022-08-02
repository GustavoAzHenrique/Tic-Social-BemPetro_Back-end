package br.com.ticsocial.bemPetro.dtos;

public class EnderecoDTO {
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String cep;
	private String municipio;
	private String uf;
	
	
	public EnderecoDTO() {
		super();
	}
	public EnderecoDTO(String logradouro, Integer numero, String complemento, String municipio, String cep, String uf) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.municipio = municipio;
		this.cep = cep;
		this.uf = uf;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
}
