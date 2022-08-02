package br.com.ticsocial.bemPetro.dtos;

import java.time.LocalDate;
import java.util.List;

public class OportunidadeDTO {
	private String titulo;
	private String empresa;
	private String descricao;
	private String cargo;
	private String requisito;
	private LocalDate dataValidadeInicio;
	private LocalDate dataValidadeFim;
	private String beneficio;
	private Double salario;
	private Integer quantidadeVaga;
	private String modalidade;
	private String jornada;
	private String contatoNome;
	private List<TelefoneDTO> contatoTelefones;
	private String contatoEmail;
	private String municipio;
	private String uf;
	
	
	public OportunidadeDTO() {
		super();
	}


	public OportunidadeDTO(String titulo, String empresa, String descricao, String cargo, String requisito,
			LocalDate dataValidadeInicio, LocalDate dataValidadeFim, String beneficio, Double salario,
			Integer quantidadeVaga, String modalidade, String jornada, String contatoNome,
			List<TelefoneDTO> contatoTelefones, String contatoEmail, String municipio, String uf) {
		super();
		this.titulo = titulo;
		this.empresa = empresa;
		this.descricao = descricao;
		this.cargo = cargo;
		this.requisito = requisito;
		this.dataValidadeInicio = dataValidadeInicio;
		this.dataValidadeFim = dataValidadeFim;
		this.beneficio = beneficio;
		this.salario = salario;
		this.quantidadeVaga = quantidadeVaga;
		this.modalidade = modalidade;
		this.jornada = jornada;
		this.contatoNome = contatoNome;
		this.contatoTelefones = contatoTelefones;
		this.contatoEmail = contatoEmail;
		this.municipio = municipio;
		this.uf = uf;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getRequisito() {
		return requisito;
	}


	public void setRequisito(String requisito) {
		this.requisito = requisito;
	}


	public LocalDate getDataValidadeInicio() {
		return dataValidadeInicio;
	}


	public void setDataValidadeInicio(LocalDate dataValidadeInicio) {
		this.dataValidadeInicio = dataValidadeInicio;
	}


	public LocalDate getDataValidadeFim() {
		return dataValidadeFim;
	}


	public void setDataValidadeFim(LocalDate dataValidadeFim) {
		this.dataValidadeFim = dataValidadeFim;
	}


	public String getBeneficio() {
		return beneficio;
	}


	public void setBeneficio(String beneficio) {
		this.beneficio = beneficio;
	}


	public Double getSalario() {
		return salario;
	}


	public void setSalario(Double salario) {
		this.salario = salario;
	}


	public Integer getQuantidadeVaga() {
		return quantidadeVaga;
	}


	public void setQuantidadeVaga(Integer quantidadeVaga) {
		this.quantidadeVaga = quantidadeVaga;
	}


	public String getModalidade() {
		return modalidade;
	}


	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}


	public String getJornada() {
		return jornada;
	}


	public void setJornada(String jornada) {
		this.jornada = jornada;
	}


	public String getContatoNome() {
		return contatoNome;
	}


	public void setContatoNome(String contatoNome) {
		this.contatoNome = contatoNome;
	}


	public List<TelefoneDTO> getContatoTelefones() {
		return contatoTelefones;
	}


	public void setContatoTelefones(List<TelefoneDTO> contatoTelefones) {
		this.contatoTelefones = contatoTelefones;
	}


	public String getContatoEmail() {
		return contatoEmail;
	}


	public void setContatoEmail(String contatoEmail) {
		this.contatoEmail = contatoEmail;
	}


	public String getMunicipio() {
		return municipio;
	}


	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}
}
