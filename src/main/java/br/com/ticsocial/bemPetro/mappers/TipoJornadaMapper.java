package br.com.ticsocial.bemPetro.mappers;

import org.springframework.stereotype.Component;

import br.com.ticsocial.bemPetro.dtos.TipoJornadaDTO;
import br.com.ticsocial.bemPetro.models.TipoJornada;

@Component
public class TipoJornadaMapper {
	
	public TipoJornada tipoJornadaDtoToTipoJornada(TipoJornadaDTO dto) {
		TipoJornada tipoJornada = new TipoJornada();
		
		tipoJornada.setTipo(dto.getTipo());
		
		return tipoJornada;
	}
}
