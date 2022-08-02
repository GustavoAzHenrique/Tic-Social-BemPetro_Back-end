package br.com.ticsocial.bemPetro.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ticsocial.bemPetro.models.Noticia;
import br.com.ticsocial.bemPetro.models.Pessoa;

public interface NoticiaRepository extends JpaRepository<Noticia, Integer> {

    Optional<Noticia> findByNome(String nome);
    
    @Query("SELECT n FROM Noticia n WHERE n.ativo = true AND n.status.status = 'aprovado'")
	List<Noticia> findAllActive();
    
    @Query("SELECT n FROM Noticia n WHERE n.ativo = true AND n.pessoaInseriu = ?1")
	List<Noticia> findAll(Pessoa pessoa);

	@Query("SELECT n FROM Noticia n WHERE n.id = ?1 AND n.ativo = true")
	Optional<Noticia> findActiveById(Integer id);

	@Query("SELECT n FROM Noticia n WHERE n.ativo = true AND n.status.status = 'pendente'")
	List<Noticia> findAllPending();

	@Query("SELECT n FROM Noticia n WHERE n.ativo = true AND n.status.status = 'aprovado' AND n.pessoaInseriu = ?1")
	List<Noticia> findAllApproved(Pessoa pessoa);
	
	@Query("SELECT n FROM Noticia n WHERE n.ativo = true AND n.status.status = 'reprovado' AND n.pessoaInseriu = ?1")
	List<Noticia> findAllDisapproved(Pessoa pessoa);
	
	@Query("SELECT n FROM Noticia n WHERE n.id = ?1 AND n.ativo = true")
	Optional<Noticia> findById(Integer id);
}