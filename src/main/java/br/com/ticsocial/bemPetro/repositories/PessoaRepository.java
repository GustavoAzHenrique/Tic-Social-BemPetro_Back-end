package br.com.ticsocial.bemPetro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ticsocial.bemPetro.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

	Optional<Pessoa> findByCnpj(String cnpj);

	@Query("SELECT p FROM Pessoa p WHERE p.email = ?1 AND p.ativo = true")
	Optional<Pessoa> findByEmail(String email);

	@Query("SELECT p FROM Pessoa p WHERE p.id = ?1 AND p.ativo = true")
	Optional<Pessoa> findActiveById(Integer id);
}
