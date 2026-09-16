package com.livraria.graphql.controller;

import com.livraria.graphql.model.Autor;
import com.livraria.graphql.model.Avaliacao;
import com.livraria.graphql.model.Livro;
import com.livraria.graphql.repository.AutorRepository;
import com.livraria.graphql.repository.AvaliacaoRepository;
import com.livraria.graphql.repository.LivroRepository;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;


@Controller
public class LivrariaController {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;
    private final AvaliacaoRepository avaliacaoRepository;

    public LivrariaController(LivroRepository livroRepository,
                              AutorRepository autorRepository,
                              AvaliacaoRepository avaliacaoRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.avaliacaoRepository = avaliacaoRepository;
    }

    @QueryMapping
    public List<Livro> livros() {
        return livroRepository.findAll();
    }

    @QueryMapping
    public Livro livro(@Argument Long id) {
        return livroRepository.findById(id).orElse(null);
    }

    @QueryMapping
    public List<Autor> autores() {
        return autorRepository.findAll();
    }

    @QueryMapping
    public Autor autor(@Argument Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    @SchemaMapping(typeName = "Livro", field = "avaliacoes")
    public List<Avaliacao> avaliacoesDoLivro(Livro livro) {
        return avaliacaoRepository.findByLivroId(livro.getId());
    }

    @SchemaMapping(typeName = "Autor", field = "livros")
    public List<Livro> livrosDoAutor(Autor autor) {
        return livroRepository.findAll().stream()
                .filter(l -> l.getAutor().getId().equals(autor.getId()))
                .toList();
    }

    @MutationMapping
    public Livro criarLivro(@Argument Map<String, Object> input) {
        Livro livro = new Livro();
        livro.setTitulo((String) input.get("titulo"));
        livro.setIsbn((String) input.get("isbn"));
        livro.setSinopse((String) input.get("sinopse"));
        livro.setEditora((String) input.get("editora"));
        livro.setIdioma((String) input.get("idioma"));
        livro.setPreco(((Number) input.get("preco")).doubleValue());

        if (input.get("numPaginas") != null) {
            livro.setNumPaginas((Integer) input.get("numPaginas"));
        }
        if (input.get("anoPublicacao") != null) {
            livro.setAnoPublicacao((Integer) input.get("anoPublicacao"));
        }

        Long autorId = Long.parseLong(input.get("autorId").toString());
        Autor autor = autorRepository.findById(autorId)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado: " + autorId));
        livro.setAutor(autor);

        return livroRepository.save(livro);
    }

    @MutationMapping
    public Livro atualizarLivro(@Argument Long id,
                                @Argument Map<String, Object> input) {
        return livroRepository.findById(id).map(livro -> {
            if (input.get("titulo") != null) {
                livro.setTitulo((String) input.get("titulo"));
            }
            if (input.get("preco") != null) {
                livro.setPreco(((Number) input.get("preco")).doubleValue());
            }
            return livroRepository.save(livro);
        }).orElse(null);
    }

    @MutationMapping
    public String deletarLivro(@Argument Long id) {
        livroRepository.deleteById(id);
        return "Livro " + id + " deletado com sucesso";
    }

    @MutationMapping
    public Avaliacao criarAvaliacao(@Argument Map<String, Object> input) {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setNota((Integer) input.get("nota"));
        avaliacao.setComentario((String) input.get("comentario"));
        avaliacao.setAvaliador((String) input.get("avaliador"));

        Long livroId = Long.parseLong(input.get("livroId").toString());
        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado: " + livroId));
        avaliacao.setLivro(livro);

        return avaliacaoRepository.save(avaliacao);
    }
}
