package br.com.ticsocial.bemPetro.mappers;

import org.springframework.stereotype.Component;

import br.com.ticsocial.bemPetro.dtos.PerfilPessoaDTO;
import br.com.ticsocial.bemPetro.models.PerfilPessoa;

@Component
public class PerfilPessoaMapper {
	public PerfilPessoa PerfilPessoaDtoToPerfilPessoa(PerfilPessoaDTO dto) {
		PerfilPessoa perfilPessoa = new PerfilPessoa();
		
		perfilPessoa.setAtivo(true);
		perfilPessoa.setPerfil(dto.getPerfil());
		
		return perfilPessoa;
	}
}
