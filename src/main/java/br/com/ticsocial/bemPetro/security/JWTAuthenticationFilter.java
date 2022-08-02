package br.com.ticsocial.bemPetro.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.ticsocial.bemPetro.models.Pessoa;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private JwtUtil jwtUtil;
	private final AuthenticationManager authenticationManager;


	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
		super();
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}


	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		try {
			Pessoa pessoa = new ObjectMapper().readValue(request.getInputStream(), Pessoa.class);
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(pessoa.getEmail(), pessoa.getSenha(), new ArrayList<>());
			return authenticationManager.authenticate(authToken);
		}catch(IOException e) {
			throw new RuntimeException();
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		String username = ((UserSS) authResult.getPrincipal()).getUsername();
		String token = jwtUtil.generateToken(username, authResult);
		
		response.addHeader("token", token);
	}
}
