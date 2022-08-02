package br.com.ticsocial.bemPetro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ticsocial.bemPetro.models.InscricaoOportunidade;
import br.com.ticsocial.bemPetro.models.Oportunidade;
import br.com.ticsocial.bemPetro.models.Pessoa;

public interface InscricaoOportunidadeRepository extends JpaRepository<InscricaoOportunidade, Integer>{

	@Query("SELECT i FROM InscricaoOportunidade i WHERE i.ativo = true AND i.pessoa = ?1 AND i.oportunidade = ?2")
	Optional<InscricaoOportunidade> findInscricao(Pessoa user, Oportunidade oportunidade);
}
