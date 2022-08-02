package br.com.ticsocial.bemPetro.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ticsocial.bemPetro.models.Evento;
import br.com.ticsocial.bemPetro.models.Favorito;
import br.com.ticsocial.bemPetro.models.Noticia;
import br.com.ticsocial.bemPetro.models.Oportunidade;
import br.com.ticsocial.bemPetro.models.Pessoa;

public interface FavoritoRepository extends JpaRepository<Favorito, Integer>{

	@Query("SELECT e FROM Favorito f, Evento e WHERE f.evento = e AND f.pessoa = ?1 AND f.ativo = true AND e.ativo = true")
	List<Evento> findAllEventos(Pessoa user);

	@Query("SELECT f FROM Favorito f WHERE f.ativo = true AND f.pessoa = ?1 AND f.evento = ?2")
	Optional<Favorito> findEventoFavorito(Pessoa user, Evento evento);

	@Query("SELECT n FROM Favorito f, Noticia n WHERE f.noticia = n AND f.pessoa = ?1 AND f.ativo = true AND n.ativo = true")
	List<Noticia> findAllNoticias(Pessoa user);

	@Query("SELECT f FROM Favorito f WHERE f.ativo = true AND f.pessoa = ?1 AND f.noticia = ?2")
	Optional<Favorito> findNoticiaFavorita(Pessoa user, Noticia noticia);

	@Query("SELECT o FROM Favorito f, Oportunidade o WHERE f.oportunidade = o AND f.pessoa = ?1 AND f.ativo = true AND o.ativo = true")
	List<Oportunidade> findAllOportunidades(Pessoa user);

	@Query("SELECT f FROM Favorito f WHERE f.ativo = true AND f.pessoa = ?1 AND f.oportunidade = ?2")
	Optional<Favorito> findOportunidadeFavorita(Pessoa user, Oportunidade oportunidade);
	

}
