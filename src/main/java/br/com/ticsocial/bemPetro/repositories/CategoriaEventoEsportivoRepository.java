package br.com.ticsocial.bemPetro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ticsocial.bemPetro.models.CategoriaEventoEsportivo;

public interface CategoriaEventoEsportivoRepository extends JpaRepository<CategoriaEventoEsportivo, Integer> {

	Optional<CategoriaEventoEsportivo> findByNome(String nome);

}
