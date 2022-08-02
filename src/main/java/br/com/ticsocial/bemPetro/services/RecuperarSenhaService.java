package br.com.ticsocial.bemPetro.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ticsocial.bemPetro.config.MailConfig;
import br.com.ticsocial.bemPetro.dtos.RecuperarSenhaDTO;
import br.com.ticsocial.bemPetro.exceptions.EmailInexistenteException;

@Service
public class RecuperarSenhaService {
	
	@Autowired
	MailConfig mailConfig;
	
	@Autowired
	PessoaService pessoaService;
	
	
	public void recuperarSenha(RecuperarSenhaDTO dto) throws EmailInexistenteException {
		String subjectMsg = "Redefinição de senha - BemPetro";
		String senha = this.gerarSenha(16);
		String contentMsg = "Nova senha: " + senha;
		
		pessoaService.alterarSenha(dto.getEmail(), senha);
		mailConfig.sendEmail(dto.getEmail(), subjectMsg, contentMsg);
	}
	
	private String gerarSenha(Integer len) {
		Random rand = new Random();
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String senha = "";
		
		for(int i=0; i<len; i++) {
			senha += chars.charAt(rand.nextInt(chars.length()));
		}
		
		return senha;
	}
}
