package br.com.ticsocial.bemPetro.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.ticsocial.bemPetro.exceptions.CnpjExistenteException;
import br.com.ticsocial.bemPetro.exceptions.EmailExistenteException;
import br.com.ticsocial.bemPetro.exceptions.EmailInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.PessoaInexistenteException;
import br.com.ticsocial.bemPetro.exceptions.TelefoneInexistenteException;
import br.com.ticsocial.bemPetro.models.Pessoa;
import br.com.ticsocial.bemPetro.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	TelefoneService telefoneService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public List<Pessoa> findAll(){
		return pessoaRepository.findAll();
	}
	
	public void verificaEmailExiste(String email) throws EmailExistenteException {
		Optional<Pessoa> optional = pessoaRepository.findByEmail(email);
		
		if(optional.isPresent()) {
			throw new EmailExistenteException();
		}
	}
	
	@Transactional
	public Pessoa findPessoaById(Integer id) throws PessoaInexistenteException {
		Optional<Pessoa> optional = pessoaRepository.findActiveById(id);
		
		if(optional.isEmpty()) {
			throw new PessoaInexistenteException();
		}
		
		return optional.get();
	}
	
	public Pessoa findPessoaByEmail(String email) {
		Optional<Pessoa> optional = pessoaRepository.findByEmail(email);
		
		if(optional.isEmpty()) {
			throw new UsernameNotFoundException("Usuario não encontrado");
		}
		
		return optional.get();
	}
	
	public Pessoa savePessoa(Pessoa pessoa) throws CnpjExistenteException, EmailExistenteException {
		Optional<Pessoa> optionalByCnpj = pessoaRepository.findByCnpj(pessoa.getCnpj());
		Optional<Pessoa> optionalByEmail = pessoaRepository.findByEmail(pessoa.getEmail());
		
		if(optionalByCnpj.isPresent())
			throw new CnpjExistenteException();
		
		if(optionalByEmail.isPresent())
			throw new EmailExistenteException();
		
		pessoa.setDataCadastro(LocalDate.now());
        return pessoaRepository.save(pessoa);
    }
	
	public Pessoa savePessoaFisica(Pessoa pessoa) throws EmailExistenteException {
		Optional<Pessoa> optionalByEmail = pessoaRepository.findByEmail(pessoa.getEmail());
		
		if(optionalByEmail.isPresent())
			throw new EmailExistenteException();
					
        return pessoaRepository.save(pessoa);
    }
	
	public Pessoa updatePessoaJuridica(Pessoa pessoaAtt, Integer id) throws PessoaInexistenteException, TelefoneInexistenteException, EmailExistenteException {
        Optional<Pessoa> optional = pessoaRepository.findActiveById(id);
        
        if (optional.isEmpty()) {
            throw new PessoaInexistenteException();
        }
        
        Pessoa oldPessoa = optional.get();
        if (pessoaAtt.getEmail() != null && !pessoaAtt.getEmail().equals("") && !pessoaAtt.getEmail().equals(oldPessoa.getEmail())) {
        	this.verificaEmailExiste(pessoaAtt.getEmail());
            oldPessoa.setEmail(pessoaAtt.getEmail());
        }
        if (pessoaAtt.getSenha() != null && !pessoaAtt.getSenha().equals("")) {
            oldPessoa.setSenha(pessoaAtt.getSenha());
        }
        if (pessoaAtt.getNomeFantasia() != null && !pessoaAtt.getNomeFantasia().equals("")) {
            oldPessoa.setNomeFantasia(pessoaAtt.getNomeFantasia());
        }
        if (pessoaAtt.getCnpj() != null && !pessoaAtt.getCnpj().equals("")) {
            oldPessoa.setCnpj(pessoaAtt.getCnpj());
        }
        if (pessoaAtt.getRazaoSocial() != null && !pessoaAtt.getRazaoSocial().equals("")) {
            oldPessoa.setRazaoSocial(pessoaAtt.getRazaoSocial());
        }
        if (pessoaAtt.getAtividadeEconomica() != null) {
            oldPessoa.setAtividadeEconomica(pessoaAtt.getAtividadeEconomica());
        }
        if (pessoaAtt.getPerfilPessoa() != null) {
            oldPessoa.setPerfilPessoa(pessoaAtt.getPerfilPessoa());
        }
        
        pessoaAtt.setDataAtualizacao(LocalDate.now());
        return pessoaRepository.save(oldPessoa);
	}
	
	public Pessoa updatePessoaFisica(Pessoa pessoaAtt, Integer id) throws PessoaInexistenteException, TelefoneInexistenteException, EmailExistenteException {
		Optional<Pessoa> optional = pessoaRepository.findById(id);
        
        if (optional.isEmpty()) {
            throw new PessoaInexistenteException();
        }
        
        Pessoa oldPessoa = optional.get();
        if (pessoaAtt.getEmail() != null && !pessoaAtt.getEmail().equals("") && !pessoaAtt.getEmail().equals(oldPessoa.getEmail())) {
        	this.verificaEmailExiste(pessoaAtt.getEmail());
            oldPessoa.setEmail(pessoaAtt.getEmail());
        }
        if (pessoaAtt.getSenha() != null && !pessoaAtt.getSenha().equals("")) {
            oldPessoa.setSenha(pessoaAtt.getSenha());
        }
        if (pessoaAtt.getDataNascimento() != null) {
            oldPessoa.setDataNascimento(pessoaAtt.getDataNascimento());
        }
        if (pessoaAtt.getNome() != null && !pessoaAtt.getNome().equals("")) {
            oldPessoa.setNome(pessoaAtt.getNome());
        }
        if (pessoaAtt.getInstituicaoEnsino() != null) {
            oldPessoa.setInstituicaoEnsino(pessoaAtt.getInstituicaoEnsino());
        }
        if (pessoaAtt.getGrauInstrucao() != null) {
            oldPessoa.setGrauInstrucao(pessoaAtt.getGrauInstrucao());
        }
        if (pessoaAtt.getPerfilPessoa() != null) {
            oldPessoa.setPerfilPessoa(pessoaAtt.getPerfilPessoa());
        }
        
        oldPessoa.setDataAtualizacao(LocalDate.now());
        return pessoaRepository.save(oldPessoa);
	}
	
	
	public void deletePessoa(Integer id) throws PessoaInexistenteException {
		Pessoa pessoa = this.findPessoaById(id);
		pessoa.setAtivo(false);

		pessoaRepository.save(pessoa);
	}
	
	public void alterarSenha(String email, String senha) throws EmailInexistenteException {
		Optional<Pessoa> optional = pessoaRepository.findByEmail(email);
		
		if(optional.isEmpty()) {
			throw new EmailInexistenteException();
		}
		
		Pessoa pessoa = optional.get();
		pessoa.setSenha(bCryptPasswordEncoder.encode(senha));
		pessoaRepository.save(pessoa);
	}
}
