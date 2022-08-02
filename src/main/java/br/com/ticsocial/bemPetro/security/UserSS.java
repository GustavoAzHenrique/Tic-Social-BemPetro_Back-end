package br.com.ticsocial.bemPetro.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.ticsocial.bemPetro.models.PerfilPessoa;
import br.com.ticsocial.bemPetro.models.Pessoa;

public class UserSS implements UserDetails{
	
	private Pessoa pessoa;
	

	public UserSS(Pessoa pessoa) {
		super();
		this.pessoa = pessoa;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

		for(PerfilPessoa perfil: pessoa.getPerfilPessoa()) {
			authorities.add(new SimpleGrantedAuthority(perfil.getPerfil()));
		}
		
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.pessoa.getSenha();
	}

	@Override
	public String getUsername() {
		return this.pessoa.getId().toString();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
