package com.livraria.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.livraria.dto.LivroAtualizarDto;
import com.livraria.dto.LivroCadastroDto;
import com.livraria.model.LivroModel;
import com.livraria.repository.LivroRepository;
import com.livraria.service.LivroAtualizar;
import com.livraria.service.LivroCadastro;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {
	@Autowired
	private LivroCadastro livro;
	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private LivroAtualizar livroDto;
	
	@PostMapping
	public ResponseEntity<Void> criarLivro(@RequestBody @Valid LivroCadastroDto livroCadastroDto){
		
		this.livro.cadastrarLivroEautor(livroCadastroDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping
	public List<LivroModel> listarLivros( 
			@RequestParam(required = false) String titulo,
		    @RequestParam(required = false) String genero,
		    @RequestParam(required = false) String autor,
		    @RequestParam(required = false) Boolean disponivel) {
		
		if(titulo != null) {
			return this.livroRepository.buscarPorTitulo(titulo);
		}else if(genero != null){
			return this.livroRepository.buscarPorGenero(genero);
		}else if(disponivel != null) {
			return this.livroRepository.buscarPorStatusDeCompra(disponivel);
		}

		return null;
	    
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<LivroModel> editarLivro(@PathVariable Long id, @RequestBody LivroAtualizarDto dto) {
		
		
		return ResponseEntity.ok(this.livroDto.atualizar(id ,dto));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarLivro(@PathVariable Long id) {
	    if (!livroRepository.existsById(id)) {
	        return ResponseEntity.notFound().build();
	    }

	    livroRepository.deleteById(id);
	    return ResponseEntity.ok("OK"); 
	}

}