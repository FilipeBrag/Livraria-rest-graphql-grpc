package com.livraria.grpc.repository;

import com.livraria.grpc.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByIdioma(String idioma);
    List<Livro> findByPrecoLessThanEqual(Double preco);
}
