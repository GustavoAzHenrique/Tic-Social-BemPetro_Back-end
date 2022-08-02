package br.com.ticsocial.bemPetro.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ticsocial.bemPetro.models.Oportunidade;
import br.com.ticsocial.bemPetro.models.Pessoa;

public interface OportunidadeRepository extends JpaRepository<Oportunidade, Integer>{

	@Query("SELECT o FROM Oportunidade o WHERE o.ativo = true AND o.status.status = 'aprovado'")
	List<Oportunidade> findAllActive();
	
	@Query("SELECT o FROM Oportunidade o WHERE o.ativo = true AND o.pessoaInseriu = ?1")
	List<Oportunidade> findAll(Pessoa pessoa);

	@Query("SELECT o FROM Oportunidade o WHERE o.id = ?1 AND o.ativo = true")
	Optional<Oportunidade> findActiveById(Integer id);

	@Query("SELECT o FROM Oportunidade o WHERE o.ativo = true AND o.status.status = 'pendente'")
	List<Oportunidade> findAllPending();

	@Query("SELECT o FROM Oportunidade o WHERE o.ativo = true AND o.status.status = 'aprovado' AND o.pessoaInseriu = ?1")
	List<Oportunidade> findAllApproved(Pessoa pessoa);
	
	@Query("SELECT o FROM Oportunidade o WHERE o.ativo = true AND o.status.status = 'reprovado' AND o.pessoaInseriu = ?1")
	List<Oportunidade> findAllDisapproved(Pessoa pessoa);
	
	@Query("SELECT o FROM Oportunidade o WHERE o.id = ?1 AND o.ativo = true")
	Optional<Oportunidade> findById(Integer id);
}
