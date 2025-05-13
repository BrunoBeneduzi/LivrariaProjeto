package com.livraria.dto;

import com.livraria.model.FormaDePagamento;

public record CompraDto(String nomeCompleto, FormaDePagamento formaPagamento, Boolean estudante,Long livroId) {
	
}
