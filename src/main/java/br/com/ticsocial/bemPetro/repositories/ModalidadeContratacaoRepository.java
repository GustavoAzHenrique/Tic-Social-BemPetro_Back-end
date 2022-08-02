package br.com.ticsocial.bemPetro.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ticsocial.bemPetro.models.ModalidadeContratacao;

public interface ModalidadeContratacaoRepository extends JpaRepository<ModalidadeContratacao, Integer>{

	Optional<ModalidadeContratacao> findByModalidade(String modalidade);

	@Query("SELECT m FROM ModalidadeContratacao m WHERE m.ativo = true")
	List<ModalidadeContratacao> findAllActive();
	
	@Query("SELECT m FROM ModalidadeContratacao m WHERE m.id = ?1 AND m.ativo = true")
	Optional<ModalidadeContratacao> findActiveById(Integer id);

	@Query("SELECT m FROM ModalidadeContratacao m WHERE m.modalidade = ?1 AND m.ativo = true")
	Optional<ModalidadeContratacao> findActiveByModalidade(String modalidade);
}
