package br.com.ticsocial.bemPetro.security;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	//@Value("${jwt.secret}")
	private static String secret = "serratec";
	
	//@Value("${jwt.expiration}")
	private Long expiration = (long) 3600000;
	
	
	public String generateToken(String username, Authentication authResult) {
		List<String> authorities = new ArrayList<>();
		
		for(GrantedAuthority authority : authResult.getAuthorities()) {
			authorities.add(authority.toString());
		}
		
		return Jwts.builder()
				.setSubject(username)
				.claim("roles", authorities)
				.setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())
				.compact();
	}
	
	public static Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		
		if(token != null) {
			String user = Jwts.parser()
					.setSigningKey(secret.getBytes())
					.parseClaimsJws(token.replace("Bearer", ""))
					.getBody()
					.getSubject();
			
			List<?> authoList = (List<?>) Jwts.parser()
					.setSigningKey(secret.getBytes())
					.parseClaimsJws(token.replace("Bearer", ""))
					.getBody()
					.get("roles");

			
			List<SimpleGrantedAuthority> authorities = new ArrayList<>();
			
			for(Object autho : authoList) {
				authorities.add(new SimpleGrantedAuthority(autho.toString()));
			}
			
			
			if(user != null) {
				return new UsernamePasswordAuthenticationToken(user, null, authorities);
			}
		}
		
		return null;
		//Adicionar exception
	}
}
