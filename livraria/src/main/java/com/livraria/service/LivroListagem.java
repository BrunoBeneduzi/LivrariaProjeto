package com.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livraria.model.LivroModel;
import com.livraria.repository.LivroRepository;

@Service
public class LivroListagem {
	@Autowired
	private LivroRepository livroRepository;
	
	public List<LivroModel> filtroLivros(String titulo, String genero, String autor, Boolean disponivel) {
		
		if(titulo != null) {
			return this.livroRepository.buscarPorTitulo(titulo);
		}else if(genero != null){
			return this.livroRepository.buscarPorGenero(genero);
		}else if(disponivel != null) {
			return this.livroRepository.buscarPorStatusDeCompra(disponivel);
		}else if(autor != null) {
			return this.livroRepository.buscarPorNomeCompletoAutor(autor);
		}
		return null;
		
	}
}
