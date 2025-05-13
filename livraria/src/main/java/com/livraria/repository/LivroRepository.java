package com.livraria.repository;


import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.livraria.dto.LivroListagemDto;
import com.livraria.model.LivroModel;

public interface LivroRepository extends JpaRepository<LivroModel, Long>{

	Optional<LivroModel> findFirstByTitulo(String titulo);
	
	Optional<LivroModel> findByTitulo(String titulo);
	
	
	@Query(value = "SELECT livros.id, livros.titulo, livros.preco, livros.genero, livros.comprado FROM livros WHERE LOWER(livros.titulo) LIKE LOWER(CONCAT('%', :titulo, '%'))", nativeQuery = true)
	List<LivroListagemDto> filtraPorTituloDoLivro(@Param("titulo") String titulo);

	@Query("SELECT l FROM LivroModel l JOIN FETCH l.autores a WHERE LOWER(l.titulo) LIKE LOWER(CONCAT('%', :titulo, '%'))")
	List<LivroModel> buscarPorTitulo(@Param("titulo") String titulo);
	
	@Query("SELECT l FROM LivroModel l JOIN FETCH l.autores a WHERE LOWER(l.genero) LIKE LOWER(CONCAT('%', :genero, '%'))")
	List<LivroModel> buscarPorGenero(@Param("genero") String genero);
	
	@Query("SELECT l FROM LivroModel l WHERE l.disponivel = :status")
	List<LivroModel> buscarPorStatusDeCompra(@Param("status") Boolean status);


}