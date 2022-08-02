package br.com.ticsocial.bemPetro.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.ticsocial.bemPetro.dtos.NoticiaDTO;
import br.com.ticsocial.bemPetro.dtos.NoticiaOutDTO;
import br.com.ticsocial.bemPetro.exceptions.PessoaInexistenteException;
import br.com.ticsocial.bemPetro.models.Noticia;
import br.com.ticsocial.bemPetro.services.PessoaService;

@Component
public class NoticiaMapper {
	@Autowired
	PessoaService pessoaService;

	public Noticia NoticiaDtoToNoticia(NoticiaDTO noticiaDTO) throws PessoaInexistenteException {
		Noticia noticia = new Noticia();

		noticia.setNome(noticiaDTO.getNome());
		noticia.setSubTitulo(noticiaDTO.getSubTitulo());
		noticia.setConteudo(noticiaDTO.getConteudo());
		noticia.setImagemPrimaria(noticiaDTO.getImagemPrimaria());
		noticia.setImagemSecundaria(noticiaDTO.getImagemSecundaria());

		return noticia;
	}
	
	public NoticiaOutDTO noticiaToNoticiaOutDto(Noticia noticia) {
		Integer userId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		NoticiaOutDTO dto = new NoticiaOutDTO();
		
		dto.setId(noticia.getId());
		dto.setNome(noticia.getNome());
		dto.setSubTitulo(noticia.getSubTitulo());
		dto.setConteudo(noticia.getConteudo());
		dto.setImagemPrimaria(noticia.getImagemPrimaria());
		dto.setImagemSecundaria(noticia.getImagemSecundaria());
		dto.setStatus(noticia.getStatus());
		dto.setDataCadastro(noticia.getDataCadastro());
		dto.setDataAtualizacao(noticia.getDataAtualizacao());
		dto.setIsFavorito(noticia.getFavoritos().stream().anyMatch(item -> item.getPessoa().getId() == userId && item.isAtivo() == true));
		
		return dto;
	}
}
