package com.livraria.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.livraria.dto.ListagemAutor;
import com.livraria.dto.LivroListagemDto;
import com.livraria.model.LivroModel;
import com.livraria.repository.LivroRepository;

@Service
public class LivroListagem {
	@Autowired
	private LivroRepository livroRepository;
	
	public List<LivroListagemDto> filtroLivros(String titulo, String genero, String autor, Boolean disponivel) {
		List<LivroModel> livrosLista = null;
		
		
		if(titulo != null) {
			livrosLista = this.livroRepository.buscarPorTitulo(titulo); 
			
			return livrosLista.stream()
			        .map(livro -> new LivroListagemDto(
			                livro.getId(),
			                livro.getTitulo(),
			                livro.getPreco(),
			                livro.getGenero().toString(),
			                livro.getDisponivel(),
			                livro.getAutores().stream()
			                    .map(a -> new ListagemAutor(a.getNomeCompleto()))
			                    .collect(Collectors.toList())
			            ))
			            .collect(Collectors.toList());

		}else if(genero != null){
			livrosLista = this.livroRepository.buscarPorGenero(genero);
			
			
			return livrosLista.stream()
			        .map(livro -> new LivroListagemDto(
			                livro.getId(),
			                livro.getTitulo(),
			                livro.getPreco(),
			                livro.getGenero().toString(),
			                livro.getDisponivel(),
			                livro.getAutores().stream()
			                    .map(a -> new ListagemAutor(a.getNomeCompleto()))
			                    .collect(Collectors.toList())
			            ))
			            .collect(Collectors.toList());
			
		}else if(disponivel != null) {
			
			livrosLista = this.livroRepository.buscarPorStatusDeCompra(disponivel);
			System.out.println(livrosLista);
			return livrosLista.stream()
			        .map(livro -> new LivroListagemDto(
			                livro.getId(),
			                livro.getTitulo(),
			                livro.getPreco(),
			                livro.getGenero().toString(),
			                livro.getDisponivel(),
			                livro.getAutores().stream()
			                    .map(a -> new ListagemAutor(a.getNomeCompleto()))
			                    .collect(Collectors.toList())
			            ))
			            .collect(Collectors.toList());
			
		}else if(autor != null) {
			livrosLista = this.livroRepository.buscarPorNomeCompletoAutor(autor);
			
			return livrosLista.stream()
			        .map(livro -> new LivroListagemDto(
			                livro.getId(),
			                livro.getTitulo(),
			                livro.getPreco(),
			                livro.getGenero().toString(),
			                livro.getDisponivel(),
			                livro.getAutores().stream()
			                    .map(a -> new ListagemAutor(a.getNomeCompleto()))
			                    .collect(Collectors.toList())
			            ))
			            .collect(Collectors.toList());
		}
		return null;
		
	}
}
