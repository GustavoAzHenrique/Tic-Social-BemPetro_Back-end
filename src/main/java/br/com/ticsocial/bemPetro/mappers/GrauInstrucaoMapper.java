package br.com.ticsocial.bemPetro.mappers;

import org.springframework.stereotype.Component;

import br.com.ticsocial.bemPetro.dtos.GrauInstrucaoDTO;
import br.com.ticsocial.bemPetro.models.GrauInstrucao;

@Component
public class GrauInstrucaoMapper {
	public GrauInstrucao GrauInstrucaoDtoToGrauInstrucao(GrauInstrucaoDTO dto) {
		GrauInstrucao grauInstrucao = new GrauInstrucao();

		grauInstrucao.setAtivo(true);
		grauInstrucao.setGrau(dto.getGrau());


		return grauInstrucao;
	}
}
