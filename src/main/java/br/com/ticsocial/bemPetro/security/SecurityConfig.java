package br.com.ticsocial.bemPetro.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	AuthService authService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	JwtUtil jwtUtil;
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors()
			.and()
			.csrf()
			.disable();
		
		http
			.authorizeRequests()
			.antMatchers("/swagger-ui/**", "/v3/api-docs/**", "/atividadeEconomica/**", "/grauInstrucao/**", "/instituicaoEnsino/**", "/perfilPessoa", "/recuperarSenha/**").permitAll()
			.antMatchers(HttpMethod.POST, "/pessoa/**", "/atividadeEconomica").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.addFilterBefore(new FilterChainExceptionHandler(), UsernamePasswordAuthenticationFilter.class)
			.addFilterBefore(new JWTAuthenticationFilter(authenticationManager(), jwtUtil), UsernamePasswordAuthenticationFilter.class)
			.addFilterBefore(new JWTAuthorizationFIlter(), UsernamePasswordAuthenticationFilter.class);

		http
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authService).passwordEncoder(bCryptPasswordEncoder);
	}
}
