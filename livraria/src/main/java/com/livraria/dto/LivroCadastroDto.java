package com.livraria.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.livraria.model.GeneroLivro;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public record LivroCadastroDto(
		@NotBlank(message = "O título é obrigatório")
		String titulo, 
		@NotBlank(message = "A editora é obrigatória")
		String editora, 
		@NotNull(message = "A data de publicação é obrigatória")
	    @PastOrPresent(message = "A data de publicação não pode estar no futuro")
		LocalDate dataDePublicacao, 
		@NotNull(message = "O gênero do livro é obrigatório")
	    GeneroLivro genero,
		@NotNull(message = "O preço é obrigatório")
	    @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que zero")
		BigDecimal preco, 
		@NotNull(message = "O campo 'comprado' deve ser informado")
		Boolean disponivel, 
		@NotNull(message = "A lista de autores não pode ser nula")
	    @Size(min = 1, message = "O livro deve ter pelo menos um autor")
	    @Valid 
		List<AutorCadastroDto> autores) {

}
