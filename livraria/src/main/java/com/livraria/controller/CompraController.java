package com.livraria.controller;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livraria.dto.CompraDto;
import com.livraria.dto.CompraRespostaDto;
import com.livraria.model.LivroModel;
import com.livraria.repository.LivroRepository;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    public ResponseEntity<?> realizarCompra(@RequestBody CompraDto compraDto) {
        Optional<LivroModel> livroOptional = livroRepository.findById(compraDto.livroId());
        
        if (livroOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Livro não encontrado.");
        }

        LivroModel livro = livroOptional.get();

        if (livro.getDisponivel()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Livro não está disponível para venda.");
        }

        BigDecimal precoFinal = livro.getPreco();
        
        if (compraDto.estudante()) {
            precoFinal = precoFinal.divide(BigDecimal.valueOf(2));
        }

    

       CompraRespostaDto resposta = new CompraRespostaDto(livro.getTitulo(),livro.getPreco(),compraDto.estudante(),precoFinal);

        return ResponseEntity.ok(resposta);
    }
}
