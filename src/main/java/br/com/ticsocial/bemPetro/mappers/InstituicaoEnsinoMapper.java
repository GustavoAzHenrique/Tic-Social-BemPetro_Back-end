package br.com.ticsocial.bemPetro.mappers;

import org.springframework.stereotype.Component;

import br.com.ticsocial.bemPetro.dtos.InstituicaoEnsinoDTO;
import br.com.ticsocial.bemPetro.models.InstituicaoEnsino;

@Component
public class InstituicaoEnsinoMapper {
    public InstituicaoEnsino InstEnsDtoToInstEns(InstituicaoEnsinoDTO dto) {
		InstituicaoEnsino instituicaoEnsino = new InstituicaoEnsino();
		
		instituicaoEnsino.setAtivo(true);
		instituicaoEnsino.setNome(dto.getNome());
	
		
		return instituicaoEnsino;
	}
}
