package br.com.ticsocial.bemPetro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ticsocial.bemPetro.models.Municipio;
import br.com.ticsocial.bemPetro.models.Uf;
import br.com.ticsocial.bemPetro.repositories.MunicipioRepository;
import br.com.ticsocial.bemPetro.repositories.PessoaRepository;

@Service
public class MunicipioService {
		
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	MunicipioRepository municipioRepository;
	
	
	public List<Municipio> findAllMunicipio() {
		return municipioRepository.findAll();
	}
	
	public void deleteMunicipioById(Integer idMunicipio) {
		municipioRepository.deleteById(idMunicipio);
	}
	
	public Municipio findMunicipioById(Integer id) {
		return municipioRepository.findById(id).get();
	}
	
	public Municipio findMunicipioByNome(String nome, Uf uf) {
		return municipioRepository.findByNome(nome, uf, uf.getSigla()).get();
	}
//	public Municipio findMunicipioByNome(String nome) {
//		return municipioRepository.findByNome(nome);
//	}
	
	public void save(Municipio municipio) {
         municipioRepository.save(municipio);
    }
    
	/*
	public Municipio saveEndereco(Integer idCliente, String cep, String numero, String complemento) {
		String limpezaCep = cep.replaceAll("[.-]", "");


		if (!enderecoRepository.existsById(idCliente)) {
			throw new NoSuchElementFoundException("O cliente de id = " + idCliente + " não foi encontrado.");
		}

	
		if (limpezaCep.length() != 8) {
			throw new EnderecoException("O CEP informado é inválido. O CEP deve conter 8 números.");
	}


		if (numero == null) {
			numero = "s/n";
		}

		if (complemento == null) {
			complemento = "";
		}

		Endereco endereco = cepDTOParaEndereco(consultarEnderecoPorCep(limpezaCep));
		endereco.setNumero(numero);
		endereco.setComplemento(complemento);
		endereco.setCep(limpezaCep);

		Pessoa pessoa = clienteRepository.findById(idCliente).get();
		cliente.setEndereco(endereco);
		cliente.getEndereco().setIdEndereco(endereco.getIdEndereco());

		return novoEndereco;
	}*/
}
