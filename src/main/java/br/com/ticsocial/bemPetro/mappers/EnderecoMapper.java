package br.com.ticsocial.bemPetro.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ticsocial.bemPetro.dtos.EnderecoDTO;
import br.com.ticsocial.bemPetro.exceptions.UfInexistenteException;
import br.com.ticsocial.bemPetro.models.Endereco;
import br.com.ticsocial.bemPetro.models.Uf;
import br.com.ticsocial.bemPetro.services.MunicipioService;
import br.com.ticsocial.bemPetro.services.UfService;

@Component
public class EnderecoMapper {
	
	@Autowired
	MunicipioService municipioService;
	
	@Autowired
	UfService ufService;
	
	public Endereco enderecoDtoToEndereco(EnderecoDTO enderecoDTO) throws UfInexistenteException{
		Endereco endereco = new Endereco();
		Uf uf = ufService.findUfBySigla(enderecoDTO.getUf());
		
		endereco.setLogradouro(enderecoDTO.getLogradouro());
		endereco.setNumero(enderecoDTO.getNumero());
		endereco.setComplemento(enderecoDTO.getComplemento());
		endereco.setCep(enderecoDTO.getCep());
//		for (Municipio municipio : uf.getMunicipios()) {
//			if(municipio.getNome().equalsIgnoreCase(enderecoDTO.getMunicipio())) {
//				endereco.setMunicipio(municipio);
//
//			}
//			
//		}
//		if(endereco.getMunicipio().equals(null)) {
//			throw new MunicipioInexistenteException();
//		}
		if(enderecoDTO.getMunicipio() != null) {
			endereco.setMunicipio(municipioService.findMunicipioByNome(enderecoDTO.getMunicipio(), uf));
		}
		
		return endereco;
	}
}
