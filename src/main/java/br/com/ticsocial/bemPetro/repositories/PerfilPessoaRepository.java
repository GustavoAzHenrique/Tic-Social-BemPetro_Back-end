package br.com.ticsocial.bemPetro.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ticsocial.bemPetro.models.PerfilPessoa;
public interface PerfilPessoaRepository extends JpaRepository<PerfilPessoa,Integer>{

	Optional<PerfilPessoa> findByPerfil(String perfil);
}
