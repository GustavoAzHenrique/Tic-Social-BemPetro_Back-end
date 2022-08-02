package br.com.ticsocial.bemPetro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ticsocial.bemPetro.models.StatusPublicacao;

public interface StatusPublicacaoRepository extends JpaRepository<StatusPublicacao, Integer>{

	Optional<StatusPublicacao> findByStatus(String status);
}
