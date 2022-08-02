package br.com.ticsocial.bemPetro.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.ticsocial.bemPetro.dtos.EventoDTO;
import br.com.ticsocial.bemPetro.dtos.EventoOutDTO;
import br.com.ticsocial.bemPetro.exceptions.CategoriaEventoEsportivoInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.PessoaInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.TipoEventoInexistenteException;
import br.com.ticsocial.bemPetro.models.Evento;
import br.com.ticsocial.bemPetro.services.CategoriaEventoEsportivoService;
import br.com.ticsocial.bemPetro.services.EventoService;
import br.com.ticsocial.bemPetro.services.PessoaService;
import br.com.ticsocial.bemPetro.services.TipoEventoService;

@Component
public class EventoMapper {

	@Autowired
	PessoaService pessoaService;

	@Autowired
	EventoService eventoService;

	@Autowired
	CategoriaEventoEsportivoService categoriaEventoEsportivoService;

	@Autowired
	TipoEventoService tipoEventoService;

	public Evento EventoDtoToEvento(EventoDTO eventoDTO) throws CategoriaEventoEsportivoInexistenteException,
			PessoaInexistenteException, TipoEventoInexistenteException {

		Evento evento = new Evento();

		evento.setNome(eventoDTO.getNome());
		evento.setSubTitulo(eventoDTO.getSubTitulo());
		evento.setDataEvento(eventoDTO.getDataEvento());
		evento.setDescricao(eventoDTO.getDescricao());
		evento.setImagem(eventoDTO.getImagem());
		evento.setTipoEvento(tipoEventoService.findByTipo(eventoDTO.getTipoEvento()));
		evento.setOrganizador(eventoDTO.getOrganizador());
		evento.setHoraInicio(eventoDTO.getHoraInicio());
		evento.setHoraTermino(eventoDTO.getHoraTermino());
		evento.setLocal(eventoDTO.getLocal());
		evento.setValorIngresso(eventoDTO.getValorIngresso());
		
		if(eventoDTO.getCategoriaEventoEsportivo() != null && !eventoDTO.getCategoriaEventoEsportivo().equals("")) {
			evento.setCategoriaEventoEsportivo(categoriaEventoEsportivoService.findByNome(eventoDTO.getCategoriaEventoEsportivo()));
		}
		
		return evento;
	}
	
	public EventoOutDTO eventoToEventoOutDto(Evento evento) {
		Integer userId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		EventoOutDTO dto = new EventoOutDTO();
		
		dto.setId(evento.getId());
		dto.setNome(evento.getNome());
		dto.setSubTitulo(evento.getSubTitulo());
		dto.setDescricao(evento.getDescricao());
		dto.setDataEvento(evento.getDataEvento());
		dto.setImagem(evento.getImagem());
		dto.setTipoEvento(evento.getTipoEvento());
		dto.setOrganizador(evento.getOrganizador());
		dto.setHoraInicio(evento.getHoraInicio());
		dto.setHoraTermino(evento.getHoraTermino());
		dto.setLocal(evento.getLocal());
		dto.setValorIngresso(evento.getValorIngresso());
		dto.setCategoriaEventoEsportivo(evento.getCategoriaEventoEsportivo());
		dto.setStatus(evento.getStatus());
		dto.setIsFavorito(evento.getFavoritos().stream().anyMatch(item -> item.getPessoa().getId() == userId && item.isAtivo() == true));
		
		return dto;
	}
}
