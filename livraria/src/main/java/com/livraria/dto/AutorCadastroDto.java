package com.livraria.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record AutorCadastroDto(
		@NotBlank(message = "O nome completo é obrigatório")
		String nomeCompleto, 
	    @NotNull(message = "A data de nascimento é obrigatória")
	    @Past(message = "A data de nascimento deve estar no passado")
		LocalDate dataDeNascimento, 
		@NotBlank(message = "A nacionalidade é obrigatória")
		String nacionalidade) {

}