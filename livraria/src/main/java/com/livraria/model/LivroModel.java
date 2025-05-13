package com.livraria.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.livraria.dto.LivroCadastroDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "livros")
public class LivroModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "titulo", nullable = false)
	private String titulo;
	
	@Column(name = "editora", nullable = false)
	private String editora;
	
	@Column(name = "dataDepublicacao", nullable = false)
	private LocalDate dataPublicacao;
	
	@Enumerated(EnumType.STRING)
	private GeneroLivro genero;
	
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal preco;
	
	@Column(nullable = false)
	private Boolean disponivel;
	 
	
	@ManyToMany
	@JoinTable(name = "livro_autor", joinColumns = @JoinColumn(name = "livro_id"), inverseJoinColumns = @JoinColumn(name ="autor_id"))
	private List<AutorModel> autores = new ArrayList<>();

	
	public LivroModel() {}
	
	
	public LivroModel(LivroCadastroDto dto) {
		this.titulo = dto.titulo().toUpperCase().trim();
		this.editora = dto.editora().toUpperCase().trim();
		this.dataPublicacao = dto.dataDePublicacao();
		this.genero = dto.genero();
		this.preco = dto.preco();
		this.disponivel = dto.disponivel();
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public GeneroLivro getGenero() {
		return genero;
	}

	public void setGenero(GeneroLivro genero) {
		this.genero = genero;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}

	public List<AutorModel> getAutores() {
		return autores;
	}

	public void setAutores(List<AutorModel> autores) {
		this.autores = autores;
	}
	
	public void setAutores(AutorModel autores) {
		this.autores.add(autores);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "LivroModel [id=" + id + ", titulo=" + titulo + ", editora=" + editora + ", dataPublicacao="
				+ dataPublicacao + ", genero=" + genero + ", preco=" + preco + ", disponivel=" + disponivel + "]";
	}
	
}