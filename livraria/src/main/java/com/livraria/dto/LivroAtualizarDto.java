package com.livraria.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import com.livraria.model.GeneroLivro;

public record LivroAtualizarDto(
		String titulo, 
		String editora, 
		LocalDate dataDePublicacao, 
	    GeneroLivro genero,
		BigDecimal preco) {
}