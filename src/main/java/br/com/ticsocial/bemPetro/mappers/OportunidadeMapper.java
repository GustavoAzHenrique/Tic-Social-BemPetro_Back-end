package br.com.ticsocial.bemPetro.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.ticsocial.bemPetro.dtos.OportunidadeDTO;
import br.com.ticsocial.bemPetro.dtos.OportunidadeOutDTO;
import br.com.ticsocial.bemPetro.dtos.TelefoneDTO;
import br.com.ticsocial.bemPetro.exceptions.JornadaInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.ModalidadeInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.PessoaInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.UfInexistenteException;
import br.com.ticsocial.bemPetro.models.Oportunidade;
import br.com.ticsocial.bemPetro.models.Telefone;
import br.com.ticsocial.bemPetro.models.Uf;
import br.com.ticsocial.bemPetro.services.ModalidadeContratacaoService;
import br.com.ticsocial.bemPetro.services.MunicipioService;
import br.com.ticsocial.bemPetro.services.PessoaService;
import br.com.ticsocial.bemPetro.services.TipoJornadaService;
import br.com.ticsocial.bemPetro.services.UfService;

@Component
public class OportunidadeMapper {
	
	@Autowired
	ModalidadeContratacaoService modalidadeContratacaoService;
	
	@Autowired
	TipoJornadaService tipoJornadaService;
	
	@Autowired
	MunicipioService municipioService;
	
	@Autowired
	UfService ufService;
	
	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	TelefoneMapper telefoneMapper;
	
	
	public Oportunidade oportunidadeDtoToOportunidade(OportunidadeDTO dto) throws ModalidadeInexistenteException, JornadaInexistenteException, UfInexistenteException, PessoaInexistenteException {
		Oportunidade oportunidade = new Oportunidade();
		Uf uf = ufService.findUfBySigla(dto.getUf());
		
		oportunidade.setTitulo(dto.getTitulo());
		oportunidade.setEmpresa(dto.getEmpresa());
		oportunidade.setDescricao(dto.getDescricao());
		oportunidade.setCargo(dto.getCargo());
		oportunidade.setRequisito(dto.getRequisito());
		oportunidade.setDataValidadeInicio(dto.getDataValidadeInicio());
		oportunidade.setDataValidadeFim(dto.getDataValidadeFim());
		oportunidade.setBeneficio(dto.getBeneficio());
		oportunidade.setSalario(dto.getSalario());
		oportunidade.setQuantidadeVaga(dto.getQuantidadeVaga());
		oportunidade.setModalidade(modalidadeContratacaoService.findByModalidade(dto.getModalidade()));
		oportunidade.setJornada(tipoJornadaService.findByTipo(dto.getJornada()));
		oportunidade.setContatoNome(dto.getContatoNome());
		oportunidade.setContatoEmail(dto.getContatoEmail());
		oportunidade.setMunicipio(municipioService.findMunicipioByNome(dto.getMunicipio(), uf));
		
		if (dto.getContatoTelefones() != null) {
			List<Telefone> telefones = new ArrayList<>();
			for (TelefoneDTO telefoneDTO : dto.getContatoTelefones()) {
				Telefone telefone = telefoneMapper.telefoneDtoToTelefone(telefoneDTO);
				telefone.setOportunidade(oportunidade);

				telefones.add(telefone);
			}
			oportunidade.setContatoTelefones(telefones);
		}
		
		return oportunidade;
	}
	
	public OportunidadeOutDTO oportunidadeToOportunidadeOutDto(Oportunidade oportunidade) {
		Integer userId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		OportunidadeOutDTO dto = new OportunidadeOutDTO();
		
		dto.setId(oportunidade.getId());
		dto.setEmpresa(oportunidade.getEmpresa());
		dto.setTitulo(oportunidade.getTitulo());
		dto.setDescricao(oportunidade.getDescricao());
		dto.setCargo(oportunidade.getCargo());
		dto.setRequisito(oportunidade.getRequisito());
		dto.setSalario(oportunidade.getSalario());
		dto.setBeneficio(oportunidade.getBeneficio());
		dto.setQuantidadeVaga(oportunidade.getQuantidadeVaga());
		dto.setDataValidadeInicio(oportunidade.getDataValidadeInicio());
		dto.setDataValidadeFim(oportunidade.getDataValidadeFim());
		dto.setContatoNome(oportunidade.getContatoNome());
		dto.setContatoTelefones(oportunidade.getContatoTelefones());
		dto.setContatoEmail(oportunidade.getContatoEmail());
		dto.setMunicipio(oportunidade.getMunicipio());
		dto.setModalidade(oportunidade.getModalidade());
		dto.setJornada(oportunidade.getJornada());
		dto.setStatus(oportunidade.getStatus());
		dto.setIsFavorito(oportunidade.getFavoritos().stream().anyMatch(item -> item.getPessoa().getId() == userId && item.isAtivo() == true));
		
		return dto;
	}
}
