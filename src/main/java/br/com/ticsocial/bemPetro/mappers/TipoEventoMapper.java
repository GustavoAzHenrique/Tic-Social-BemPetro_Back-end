package br.com.ticsocial.bemPetro.mappers;

import org.springframework.stereotype.Component;

import br.com.ticsocial.bemPetro.dtos.TipoEventoDTO;
import br.com.ticsocial.bemPetro.models.TipoEvento;
@Component
public class TipoEventoMapper {
	public TipoEvento TipoEventoDtoToTipoEvento(TipoEventoDTO dto) {
		TipoEvento tipoEvento = new TipoEvento();

		tipoEvento.setAtivo(true);
		tipoEvento.setTipo(dto.getTipo());

		return tipoEvento;
	}
}
