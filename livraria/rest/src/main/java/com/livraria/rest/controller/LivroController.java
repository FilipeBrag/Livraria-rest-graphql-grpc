package com.livraria.rest.controller;

import com.livraria.rest.model.Avaliacao;
import com.livraria.rest.model.Livro;
import com.livraria.rest.repository.AvaliacaoRepository;
import com.livraria.rest.repository.LivroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository livroRepository;
    private final AvaliacaoRepository avaliacaoRepository;

    public LivroController(LivroRepository livroRepository,
                           AvaliacaoRepository avaliacaoRepository) {
        this.livroRepository = livroRepository;
        this.avaliacaoRepository = avaliacaoRepository;
    }

    @GetMapping
    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
        return livroRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/avaliacoes")
    public ResponseEntity<List<Avaliacao>> listarAvaliacoes(@PathVariable Long id) {
        return livroRepository.findById(id)
                .map(livro -> ResponseEntity.ok(avaliacaoRepository.findByLivroId(id)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Livro criar(@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id,
                                           @RequestBody Livro dados) {
        return livroRepository.findById(id).map(livro -> {
            livro.setTitulo(dados.getTitulo());
            livro.setPreco(dados.getPreco());
            return ResponseEntity.ok(livroRepository.save(livro));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletar(@PathVariable Long id) {
        return livroRepository.findById(id).map(livro -> {
            livroRepository.delete(livro);
            return ResponseEntity.ok(Map.of("mensagem", "Livro deletado com sucesso"));
        }).orElse(ResponseEntity.notFound().build());
    }
}
