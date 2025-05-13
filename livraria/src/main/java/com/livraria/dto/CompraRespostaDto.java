package com.livraria.dto;

import java.math.BigDecimal;
public record CompraRespostaDto(String titulo, BigDecimal precoOriginal, Boolean estudante, BigDecimal precoFinal) {
	
}
