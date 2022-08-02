package br.com.ticsocial.bemPetro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ticsocial.bemPetro.models.TipoEvento;

public interface TipoEventoRepository extends JpaRepository<TipoEvento, Integer> {

	Optional<TipoEvento> findByTipo(String tipo);
}
