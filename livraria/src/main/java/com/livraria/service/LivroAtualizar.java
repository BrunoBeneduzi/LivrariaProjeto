package com.livraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livraria.dto.LivroAtualizarDto;
import com.livraria.model.LivroModel;
import com.livraria.repository.LivroRepository;

@Service
public class LivroAtualizar {
@Autowired
private LivroRepository livroRepository;
	
	public LivroModel atualizar(Long id,LivroAtualizarDto dto) {
		LivroModel livro = this.livroRepository.findById(id).get();
		
		if(dto.titulo() != null) {
			livro.setTitulo(dto.titulo().toUpperCase());
		}
		if(dto.editora() != null) {
			livro.setEditora(dto.editora().toUpperCase());
		}
		if(dto.genero() != null) {
			livro.setGenero(dto.genero());
		}
		if(dto.dataDePublicacao() != null) {
			livro.setDataPublicacao(dto.dataDePublicacao());
		}
		if(dto.preco() != null) {
			livro.setPreco(dto.preco());
		}
		
		this.livroRepository.save(livro);
		
		return livro;
		
	}
}
