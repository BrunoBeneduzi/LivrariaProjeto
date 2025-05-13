package com.livraria.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.livraria.model.AutorModel;

public interface AutorRepository extends JpaRepository<AutorModel, Long>{

	Optional<AutorModel> findByNomeCompleto(String nomeCompleto);
}