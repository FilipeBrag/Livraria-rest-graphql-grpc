package com.livraria.grpc.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidade JPA simplificada para o módulo gRPC.
 * Usamos um modelo mais simples para focar na demonstração do protocolo,
 * não na complexidade do domínio.
 */
@Data
@Entity
@Table(name = "livro_grpc")
public class LivroGrpc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private Double preco;
    private Integer anoPublicacao;
}
