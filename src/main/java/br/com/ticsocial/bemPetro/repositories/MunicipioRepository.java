package br.com.ticsocial.bemPetro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ticsocial.bemPetro.models.Municipio;
import br.com.ticsocial.bemPetro.models.Uf;

public interface MunicipioRepository extends JpaRepository<Municipio,Integer>{

	@Query("SELECT m FROM Municipio m, Uf u WHERE m.uf = ?2 AND m.nome = ?1 AND u.sigla = ?3")
	Optional<Municipio> findByNome(String nome, Uf uf, String ufSigla);
	
//	Optional<Municipio> findByNome(String nome);

}
