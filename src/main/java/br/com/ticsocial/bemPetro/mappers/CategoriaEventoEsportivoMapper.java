package br.com.ticsocial.bemPetro.mappers;

import org.springframework.stereotype.Component;

import br.com.ticsocial.bemPetro.dtos.CategoriaEventoEsportivoDTO;
import br.com.ticsocial.bemPetro.models.CategoriaEventoEsportivo;
@Component
public class CategoriaEventoEsportivoMapper {
	public CategoriaEventoEsportivo catEventoEsportDtoTocatEventoEsport(CategoriaEventoEsportivoDTO dto) {
		CategoriaEventoEsportivo categoriaEventoEsportivo = new CategoriaEventoEsportivo();

		categoriaEventoEsportivo.setAtivo(true);
		categoriaEventoEsportivo.setNome(dto.getNome());


		return categoriaEventoEsportivo;
	}
}
