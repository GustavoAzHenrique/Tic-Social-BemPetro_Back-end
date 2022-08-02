package br.com.ticsocial.bemPetro.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.ticsocial.bemPetro.exceptions.AtivEconomicaExistenteException;
import br.com.ticsocial.bemPetro.exceptions.CnpjExistenteException;
import br.com.ticsocial.bemPetro.exceptions.EmailExistenteException;
import br.com.ticsocial.bemPetro.exceptions.PerfilPessoaExistenteException;
import br.com.ticsocial.bemPetro.exceptions.PerfilPessoaInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.PessoaInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.UfInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.ativEconomicaInexistenteException;

@RestControllerAdvice
public class ExceptionsController {
	
	@ExceptionHandler(AtivEconomicaExistenteException.class)
	public ResponseEntity<String> handleAtividadeExistente() {
		String msg = "Atividade econômica já existe";
		return ResponseEntity.badRequest().header("errorMsg", msg).build();
	}
	
	@ExceptionHandler(ativEconomicaInexistenteException.class)
	public ResponseEntity<String> handleAtividadeInexistente() {
		String msg = "Atividade econômica não existe";
		return ResponseEntity.badRequest().header("errorMsg", msg).build();
	}
	
	@ExceptionHandler(CnpjExistenteException.class)
	public ResponseEntity<String> handleCnpjExistente() {
		String msg = " CNPJ já existe";
		return ResponseEntity.badRequest().header("errorMsg", msg).build();
	}
	
	@ExceptionHandler(EmailExistenteException.class)
	public ResponseEntity<String> handleEmailExistente() {
		String msg = "Email já existe";
		return ResponseEntity.badRequest().header("errorMsg", msg).build();
	}
	
	@ExceptionHandler(PerfilPessoaExistenteException.class)
	public ResponseEntity<String> handlePerfilPessoaExistente() {
		String msg = "Perfil já existe";
		return ResponseEntity.badRequest().header("errorMsg", msg).build();
	}
	
	@ExceptionHandler(PerfilPessoaInexistenteException.class)
	public ResponseEntity<String> handlePerfilPessoaInexistente() {
		String msg = "Perfil não existe";
		return ResponseEntity.badRequest().header("errorMsg", msg).build();
	}
	
	@ExceptionHandler(PessoaInexistenteException.class)
	public ResponseEntity<String> handlePessoaInexistente() {
		String msg = "Pessoa não existe";
		return ResponseEntity.badRequest().header("errorMsg", msg).build();
	}
	
	@ExceptionHandler(UfInexistenteException.class)
	public ResponseEntity<String> handleUfInexistente() {
		String msg = "UF não existe";
		return ResponseEntity.badRequest().header("errorMsg", msg).build();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidacao(MethodArgumentNotValidException ex) {
		Map<String, String> errosMap = new HashMap<>();
		List<ObjectError> erros = ex.getBindingResult().getAllErrors();
		
		for(ObjectError erro : erros) {
			String atributo = ((FieldError) erro).getField();
			String msg = erro.getDefaultMessage();
			errosMap.put(atributo, msg);
		}
		
		return new ResponseEntity<Map<String, String>>(errosMap, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> handleConstraintViolationInexistente() {
		String msg = "campo inválido";
		return ResponseEntity.badRequest().header("errorMsg", msg).build();
	}
}
