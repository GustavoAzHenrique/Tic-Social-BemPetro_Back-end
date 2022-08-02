package br.com.ticsocial.bemPetro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ticsocial.bemPetro.models.Uf;

public interface UfRepository extends JpaRepository<Uf, Integer>{

	Optional<Uf> findBySigla(String sigla);
}
