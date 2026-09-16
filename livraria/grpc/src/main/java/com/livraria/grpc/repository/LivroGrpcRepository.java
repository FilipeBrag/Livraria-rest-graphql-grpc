package com.livraria.grpc.repository;

import com.livraria.grpc.model.LivroGrpc;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivroGrpcRepository extends JpaRepository<LivroGrpc, Long> {
    List<LivroGrpc> findByAutorContainingIgnoreCase(String autor);
}
