package br.com.ticsocial.bemPetro.dtos;

public class ModalidadeContratacaoDTO {
	private String modalidade;
	
	
	public ModalidadeContratacaoDTO() {
		super();
	}

	public ModalidadeContratacaoDTO(String modalidade) {
		super();
		this.modalidade = modalidade;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
}
