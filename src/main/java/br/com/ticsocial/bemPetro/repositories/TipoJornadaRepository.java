package br.com.ticsocial.bemPetro.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ticsocial.bemPetro.models.TipoJornada;

public interface TipoJornadaRepository extends JpaRepository<TipoJornada, Integer>{

	@Query("SELECT t FROM TipoJornada t WHERE t.ativo = true")
	List<TipoJornada> findAllActive();
	
	@Query("SELECT t FROM TipoJornada t WHERE t.id = ?1 AND t.ativo = true")
	Optional<TipoJornada> findActiveById(Integer id);

	@Query("SELECT t FROM TipoJornada t WHERE t.tipo = ?1 AND t.ativo = true")
	Optional<TipoJornada> findActiveByTipo(String tipo);
}
