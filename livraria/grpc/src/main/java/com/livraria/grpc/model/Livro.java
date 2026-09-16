package com.livraria.grpc.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String isbn;

    @Column(length = 1000)
    private String sinopse;

    private Integer numPaginas;
    private String editora;
    private String idioma;
    private Integer anoPublicacao;
    private Double preco;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id")
    private Autor autor;
}
