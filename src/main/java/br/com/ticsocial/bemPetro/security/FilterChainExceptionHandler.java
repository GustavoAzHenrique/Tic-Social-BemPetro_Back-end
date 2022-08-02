package br.com.ticsocial.bemPetro.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class FilterChainExceptionHandler extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException e) {
            System.out.println("mensagem de erro: " + e.getMessage());
            response.addHeader("errorMsg", "expired token");
            response.setStatus(401);
        }
	}

}
