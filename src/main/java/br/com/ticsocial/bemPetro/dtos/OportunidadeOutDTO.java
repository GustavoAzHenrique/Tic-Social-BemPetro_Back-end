package br.com.ticsocial.bemPetro.dtos;

import java.time.LocalDate;
import java.util.List;

import br.com.ticsocial.bemPetro.models.ModalidadeContratacao;
import br.com.ticsocial.bemPetro.models.Municipio;
import br.com.ticsocial.bemPetro.models.StatusPublicacao;
import br.com.ticsocial.bemPetro.models.Telefone;
import br.com.ticsocial.bemPetro.models.TipoJornada;

public class OportunidadeOutDTO {
	private Integer id;
	private String empresa;
	private String titulo;
	private String descricao;
	private String cargo;
	private String requisito;
	private Double salario;
	private String beneficio;
	private Integer quantidadeVaga;
	private LocalDate dataValidadeInicio;
	private LocalDate dataValidadeFim;
	private String contatoNome;
	private List<Telefone> contatoTelefones;
	private String contatoEmail;
	private Municipio municipio;
	private ModalidadeContratacao modalidade;
	private TipoJornada jornada;
	private StatusPublicacao status;
	private Boolean isFavorito;
	
	
	public OportunidadeOutDTO() {
		super();
	}


	public OportunidadeOutDTO(Integer id, String empresa, String titulo, String descricao, String cargo,
			String requisito, Double salario, String beneficio, Integer quantidadeVaga, LocalDate dataValidadeInicio,
			LocalDate dataValidadeFim, String contatoNome, List<Telefone> contatoTelefones, String contatoEmail,
			Municipio municipio, ModalidadeContratacao modalidade, TipoJornada jornada, StatusPublicacao status,
			Boolean isFavorito) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.titulo = titulo;
		this.descricao = descricao;
		this.cargo = cargo;
		this.requisito = requisito;
		this.salario = salario;
		this.beneficio = beneficio;
		this.quantidadeVaga = quantidadeVaga;
		this.dataValidadeInicio = dataValidadeInicio;
		this.dataValidadeFim = dataValidadeFim;
		this.contatoNome = contatoNome;
		this.contatoTelefones = contatoTelefones;
		this.contatoEmail = contatoEmail;
		this.municipio = municipio;
		this.modalidade = modalidade;
		this.jornada = jornada;
		this.status = status;
		this.isFavorito = isFavorito;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
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


	public Double getSalario() {
		return salario;
	}


	public void setSalario(Double salario) {
		this.salario = salario;
	}


	public String getBeneficio() {
		return beneficio;
	}


	public void setBeneficio(String beneficio) {
		this.beneficio = beneficio;
	}


	public Integer getQuantidadeVaga() {
		return quantidadeVaga;
	}


	public void setQuantidadeVaga(Integer quantidadeVaga) {
		this.quantidadeVaga = quantidadeVaga;
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


	public String getContatoNome() {
		return contatoNome;
	}


	public void setContatoNome(String contatoNome) {
		this.contatoNome = contatoNome;
	}


	public List<Telefone> getContatoTelefones() {
		return contatoTelefones;
	}


	public void setContatoTelefones(List<Telefone> contatoTelefones) {
		this.contatoTelefones = contatoTelefones;
	}


	public String getContatoEmail() {
		return contatoEmail;
	}


	public void setContatoEmail(String contatoEmail) {
		this.contatoEmail = contatoEmail;
	}


	public Municipio getMunicipio() {
		return municipio;
	}


	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}


	public ModalidadeContratacao getModalidade() {
		return modalidade;
	}


	public void setModalidade(ModalidadeContratacao modalidade) {
		this.modalidade = modalidade;
	}


	public TipoJornada getJornada() {
		return jornada;
	}


	public void setJornada(TipoJornada jornada) {
		this.jornada = jornada;
	}


	public StatusPublicacao getStatus() {
		return status;
	}


	public void setStatus(StatusPublicacao status) {
		this.status = status;
	}


	public Boolean getIsFavorito() {
		return isFavorito;
	}


	public void setIsFavorito(Boolean isFavorito) {
		this.isFavorito = isFavorito;
	}
}
