package com.livraria.dto;

import java.math.BigDecimal;

public record LivroListagemDto(Long id, String titulo, BigDecimal preco, String genero, Boolean disponivel) {


}