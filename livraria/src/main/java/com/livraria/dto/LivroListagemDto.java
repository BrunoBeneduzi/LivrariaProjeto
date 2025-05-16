package com.livraria.dto;

import java.math.BigDecimal;
import java.util.List;


public record LivroListagemDto(Long id, String titulo, BigDecimal preco, String genero, Boolean disponivel, List<ListagemAutor> autor) {

	
}