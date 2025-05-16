package com.livraria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.livraria.dto.AutorCadastroDto;
import com.livraria.dto.LivroCadastroDto;
import com.livraria.model.AutorModel;
import com.livraria.model.LivroModel;
import com.livraria.repository.AutorRepository;
import com.livraria.repository.LivroRepository;

@Service
public class LivroCadastro {
	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private AutorRepository autorRepository;
	
	public void cadastrarLivroEautor(LivroCadastroDto dto) {
		
		if(verificaTitulo(dto)) {
			this.livroRepository.save(this.cadastrarLivroExistente(dto));
			
		}else if(this.verificaAutores(dto)) {
			
			List<AutorModel> autorLista = this.verificaSeAutorJaFoiCadastrado(dto);//se o autor já foi cadastrado, ele vai ser reaproveitado no novo livro, sem ser duplicado
			
			LivroModel livroLista = this.cadastrarLivroNovo(dto);
			
			livroLista.setAutores(autorLista);
			
			this.livroRepository.save(livroLista);
			
		}else {
			
			List<AutorModel> autorLista = this.cadastrarAutorNovo(dto);
			
			this.autorRepository.saveAll(autorLista);
		
			LivroModel livroLista = this.cadastrarLivroNovo(dto);
			
			livroLista.setAutores(autorLista);
			
			this.livroRepository.save(livroLista);	
		}
	}
	
	public Boolean verificaTitulo(LivroCadastroDto dto) {
		
		if(this.livroRepository.findFirstByTitulo(dto.titulo().toUpperCase()).isPresent()){
			return true;
		}
		return false;
	}
	
	public Boolean verificaAutores(LivroCadastroDto dto) {
		
		for(AutorCadastroDto autor : dto.autores()) {
			if(this.autorRepository.findByNomeCompleto(autor.nomeCompleto().toUpperCase()).isPresent()) {
				return true;
			}
		}
		
		return false;
	}
	
	public List<AutorModel> cadastrarAutorNovo(LivroCadastroDto dto) {
		List<AutorModel> autorNovo = new ArrayList<>();
		
		for(AutorCadastroDto autor: dto.autores()) {
			autorNovo.add(new AutorModel(autor));
		}
		return autorNovo;
	}
	
	
	public LivroModel cadastrarLivroNovo(LivroCadastroDto dto) {
		LivroModel livroNovo = new LivroModel(dto);
		
		return livroNovo;
	}
	
	public LivroModel cadastrarLivroExistente(LivroCadastroDto dto) {
		
		LivroModel livroLista = this.livroRepository.findFirstByTitulo(dto.titulo().toUpperCase()).get();
		
		LivroModel novoLivro = new LivroModel();
		
		novoLivro.setTitulo(livroLista.getTitulo());
		novoLivro.setDisponivel(dto.disponivel());
		novoLivro.setDataPublicacao(livroLista.getDataPublicacao());
		novoLivro.setEditora(livroLista.getEditora());
		novoLivro.setGenero(livroLista.getGenero());
		novoLivro.setPreco(livroLista.getPreco());
		novoLivro.setAutores(new ArrayList<>(livroLista.getAutores()));
		
		return novoLivro;
	}
	
	public List<AutorModel> verificaSeAutorJaFoiCadastrado(LivroCadastroDto dto) {
		List<AutorModel> autorLista = new ArrayList<>();
		
		for(AutorCadastroDto autorDto: dto.autores()) {
			Optional<AutorModel> autorExiste =  this.autorRepository.findByNomeCompleto(autorDto.nomeCompleto().toUpperCase());
			
			if(autorExiste.isPresent()) {
				autorLista.add(autorExiste.get());
			}else {
				autorLista.add(new AutorModel(autorDto));
			}	
		}
		
		return autorLista;
	}
}