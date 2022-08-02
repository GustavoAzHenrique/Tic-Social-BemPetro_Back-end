package br.com.ticsocial.bemPetro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ticsocial.bemPetro.models.GrauInstrucao;

public interface GrauInstrucaoRepository extends JpaRepository<GrauInstrucao, Integer> {

	Optional<GrauInstrucao> findByGrau(String grau);
}
