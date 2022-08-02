package br.com.ticsocial.bemPetro.mappers;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import br.com.ticsocial.bemPetro.dtos.AtividadeEconomicaDTO;
import br.com.ticsocial.bemPetro.models.AtividadeEconomica;

@Component
public class AtividadeEconomicaMapper {
	public AtividadeEconomica AtiEcoDtoToAtiEco(AtividadeEconomicaDTO dto) {
		AtividadeEconomica atividadeEconomica = new AtividadeEconomica();
		
		atividadeEconomica.setAtivo(true);
		atividadeEconomica.setCodigo(dto.getCodigo());
		atividadeEconomica.setNome(dto.getNome());
		
		if(atividadeEconomica.getDataCadastro()==null) {
			atividadeEconomica.setDataCadastro(LocalDate.now());
		}else {
			atividadeEconomica.setDataAtualizacao(LocalDate.now());
		}
		
		return atividadeEconomica;
	}
}
