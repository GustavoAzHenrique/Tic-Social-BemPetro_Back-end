package br.com.ticsocial.bemPetro.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ticsocial.bemPetro.models.Pessoa;
import br.com.ticsocial.bemPetro.services.PessoaService;

@Service
public class AuthService implements UserDetailsService{
	
	@Autowired
	PessoaService pessoaService;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Pessoa pessoa = pessoaService.findPessoaByEmail(username);
		return new UserSS(pessoa);
	}
}
