package br.com.ticsocial.bemPetro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ticsocial.bemPetro.models.InstituicaoEnsino;

public interface InstituicaoEnsinoRepository extends JpaRepository<InstituicaoEnsino, Integer> {

    Optional<InstituicaoEnsino> findByNome(String nome);

}