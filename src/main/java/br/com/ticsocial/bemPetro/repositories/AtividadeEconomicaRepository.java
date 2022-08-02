package br.com.ticsocial.bemPetro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ticsocial.bemPetro.models.AtividadeEconomica;

public interface AtividadeEconomicaRepository extends JpaRepository<AtividadeEconomica, Integer> {

	Optional<AtividadeEconomica> findByNome(String nome);

}
