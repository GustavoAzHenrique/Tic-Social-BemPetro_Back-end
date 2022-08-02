package br.com.ticsocial.bemPetro.mappers;

import org.springframework.stereotype.Component;

import br.com.ticsocial.bemPetro.dtos.ModalidadeContratacaoDTO;
import br.com.ticsocial.bemPetro.models.ModalidadeContratacao;

@Component
public class ModalidadeContratacaoMapper {
	
	public ModalidadeContratacao ModContDtoToModCont(ModalidadeContratacaoDTO dto) {
		ModalidadeContratacao modalidadeContratacao = new ModalidadeContratacao();
		
		modalidadeContratacao.setModalidade(dto.getModalidade());
		
		return modalidadeContratacao;
	}
}
