package br.com.ticsocial.bemPetro.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ticsocial.bemPetro.exceptions.EnderecoInexistenteException;
import br.com.ticsocial.bemPetro.models.Endereco;
import br.com.ticsocial.bemPetro.repositories.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    public void save(Endereco endereco) {
         enderecoRepository.save(endereco);
    }
    
    public Endereco atualizar(Endereco endereco, Integer id) throws EnderecoInexistenteException  {
        Optional<Endereco> optional = enderecoRepository.findById(id);
        
        if (optional.isEmpty()) {
            throw new EnderecoInexistenteException();
        }
        
        Endereco oldEndereco = optional.get();
        if (endereco.getLogradouro() != null && !endereco.getLogradouro().equals("")) {
            oldEndereco.setLogradouro(endereco.getLogradouro());
        }
        if (endereco.getNumero() != null) {
            oldEndereco.setNumero(endereco.getNumero());
        }
        if (endereco.getComplemento() != null && !endereco.getComplemento().equals("")) {
            oldEndereco.setComplemento(endereco.getComplemento());
        }
        if (endereco.getCep() != null && !endereco.getCep().equals("")) {
            oldEndereco.setCep(endereco.getCep());
        }
        if (endereco.getMunicipio() != null) {
            oldEndereco.setMunicipio(endereco.getMunicipio());
        }
        
        return enderecoRepository.save(oldEndereco);
	}
	
	public void deleteEnderecoById(Integer idEndereco) {
		enderecoRepository.deleteById(idEndereco);
	}
	
	public Endereco findEnderecoById(Integer id) {
		return enderecoRepository.findById(id).get();
	}
	
	public void delete(Endereco endereco) {
		enderecoRepository.delete(endereco);
	}
	






    

}
