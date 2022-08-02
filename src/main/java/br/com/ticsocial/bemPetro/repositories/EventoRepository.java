package br.com.ticsocial.bemPetro.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ticsocial.bemPetro.models.Evento;
import br.com.ticsocial.bemPetro.models.Pessoa;

public interface EventoRepository  extends JpaRepository<Evento, Integer> {
	Optional<Evento> findByNome(String nome);
	
	@Query("SELECT e FROM Evento e WHERE e.ativo = true AND e.status.status = 'aprovado'")
	List<Evento> findAllActive();
	
	@Query("SELECT e FROM Evento e WHERE e.ativo = true AND e.pessoaInseriu = ?1")
	List<Evento> findAll(Pessoa pessoa);

	@Query("SELECT e FROM Evento e WHERE e.id = ?1 AND e.ativo = true")
	Optional<Evento> findActiveById(Integer id);

	@Query("SELECT e FROM Evento e WHERE e.ativo = true AND e.status.status = 'pendente'")
	List<Evento> findAllPending();

	@Query("SELECT e FROM Evento e WHERE e.ativo = true AND e.status.status = 'aprovado' AND e.pessoaInseriu = ?1")
	List<Evento> findAllApproved(Pessoa pessoa);
	
	@Query("SELECT e FROM Evento e WHERE e.ativo = true AND e.status.status = 'reprovado' AND e.pessoaInseriu = ?1")
	List<Evento> findAllDisapproved(Pessoa pessoa);
	
	@Query("SELECT e FROM Evento e WHERE e.id = ?1 AND e.ativo = true")
	Optional<Evento> findById(Integer id);
}
