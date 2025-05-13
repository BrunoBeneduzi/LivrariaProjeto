package com.livraria.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.livraria.dto.AutorCadastroDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "autores")
public class AutorModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nomeCompleto", nullable = false, unique = true)
	private String nomeCompleto;
	
	@Column(name = "dataDeNascimento", nullable = false)
	private LocalDate dataDeNascimento;
	
	@Column(name = "nacionalidade", nullable = false)
	private String nacionalidade;
	
	@ManyToMany(mappedBy = "autores")
	@JsonIgnore
	private List<LivroModel> livros = new ArrayList<>();
	
	
	public AutorModel() {}
	
	public AutorModel(AutorCadastroDto dto) {
		this.nomeCompleto = dto.nomeCompleto().toUpperCase().trim();
		this.dataDeNascimento = dto.dataDeNascimento();
		this.nacionalidade = dto.nacionalidade().toUpperCase().trim();
	}


	public String getNomeCompleto() {
		return nomeCompleto;
	}


	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}


	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}


	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}


	public String getNacionalidade() {
		return nacionalidade;
	}


	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	public List<LivroModel> getLivros() {
		return livros;
	}

	public void setLivros(List<LivroModel> livros) {
		this.livros = livros;
	}

	@Override
	public String toString() {
		return "AutorModel [nomeCompleto=" + nomeCompleto + ", dataDeNascimento=" + dataDeNascimento
				+ ", nacionalidade=" + nacionalidade + "]";
	}

	
	
}