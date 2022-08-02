package br.com.ticsocial.bemPetro.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ticsocial.bemPetro.exceptions.PerfilPessoaExistenteException;
import br.com.ticsocial.bemPetro.exceptions.PerfilPessoaInexistenteException;
import br.com.ticsocial.bemPetro.models.PerfilPessoa;
import br.com.ticsocial.bemPetro.repositories.PerfilPessoaRepository;

@Service
public class PerfilPessoaService {
	
    @Autowired
	PerfilPessoaRepository perfilPessoaRepository;
    
    
    public List<PerfilPessoa> findAll() {
		return perfilPessoaRepository.findAll();
	}
	
	public PerfilPessoa save(PerfilPessoa perfilPessoa) throws PerfilPessoaExistenteException {
		Optional<PerfilPessoa> optional = perfilPessoaRepository.findByPerfil(perfilPessoa.getPerfil());
        
		if(optional.isPresent()) {
			throw new PerfilPessoaExistenteException();
		}
		
		perfilPessoa.setDataCadastro(LocalDate.now());
		return perfilPessoaRepository.save(perfilPessoa);
    }
	
	public PerfilPessoa findPerfilPessoaByPerfil(String perfil) throws PerfilPessoaInexistenteException {
		Optional<PerfilPessoa> optional = perfilPessoaRepository.findByPerfil(perfil);
		
		if(optional.isEmpty()) {
			throw new PerfilPessoaInexistenteException();
		}
		
		return optional.get();
	}
}