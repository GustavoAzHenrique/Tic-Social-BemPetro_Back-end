package br.com.ticsocial.bemPetro.mappers;

import org.springframework.stereotype.Component;

import br.com.ticsocial.bemPetro.dtos.TelefoneDTO;
import br.com.ticsocial.bemPetro.models.Telefone;

@Component
public class TelefoneMapper {
	public Telefone telefoneDtoToTelefone(TelefoneDTO telefoneDTO) {
		Telefone telefone = new Telefone();
		
		telefone.setAtivo(true);
		telefone.setDdd(telefoneDTO.getDdd());
		telefone.setNumero(telefoneDTO.getNumero());
		
		return telefone;
	}
}
