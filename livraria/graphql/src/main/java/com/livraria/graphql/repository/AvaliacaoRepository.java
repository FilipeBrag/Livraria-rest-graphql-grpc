package com.livraria.graphql.repository;

import com.livraria.graphql.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    List<Avaliacao> findByLivroId(Long livroId);
}
