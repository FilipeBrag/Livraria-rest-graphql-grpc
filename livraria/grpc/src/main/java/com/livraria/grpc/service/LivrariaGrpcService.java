package com.livraria.grpc.service;

import com.livraria.grpc.model.LivroGrpc;
import com.livraria.grpc.proto.*;
import com.livraria.grpc.repository.LivroGrpcRepository;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@GrpcService
public class LivrariaGrpcService extends LivrariaServiceGrpc.LivrariaServiceImplBase {

    private final LivroGrpcRepository repository;

    public LivrariaGrpcService(LivroGrpcRepository repository) {
        this.repository = repository;
    }

    @Override
    public void buscarLivro(BuscarLivroRequest request,
                            StreamObserver<LivroResponse> responseObserver) {

        System.out.println("[UNARIO] Buscando livro id=" + request.getId());

        repository.findById(request.getId()).ifPresentOrElse(
            livro -> {
                responseObserver.onNext(toResponse(livro));
                responseObserver.onCompleted();
                System.out.println("[UNARIO] Enviado: " + livro.getTitulo());
            },
            () -> responseObserver.onError(
                Status.NOT_FOUND
                    .withDescription("Livro nao encontrado: id=" + request.getId())
                    .asRuntimeException()
            )
        );
    }

    @Override
    public void streamCatalogo(FiltroRequest request,
                               StreamObserver<LivroResponse> responseObserver) {

        String filtro = request.getAutor();
        System.out.println("[SERVER STREAM] Iniciando. Filtro: '"
            + (filtro.isEmpty() ? "todos" : filtro) + "'");

        List<LivroGrpc> livros = filtro.isEmpty()
            ? repository.findAll()
            : repository.findByAutorContainingIgnoreCase(filtro);

        for (LivroGrpc livro : livros) {
            System.out.println("[SERVER STREAM] Enviando: " + livro.getTitulo());
            responseObserver.onNext(toResponse(livro));
            try { Thread.sleep(600); } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        responseObserver.onCompleted();
        System.out.println("[SERVER STREAM] Concluido. Total: " + livros.size());
    }

    @Override
    public StreamObserver<AtualizarPrecoRequest> atualizarPrecos(
            StreamObserver<ResumoAtualizacao> responseObserver) {

        List<String> atualizados = new ArrayList<>();
        AtomicInteger contador = new AtomicInteger(0);

        return new StreamObserver<>() {
            @Override
            public void onNext(AtualizarPrecoRequest req) {
                System.out.println("[CLIENT STREAM] Recebendo: livro id=" + req.getId()
                    + " preco=R$" + req.getNovoPreco());
                repository.findById(req.getId()).ifPresent(livro -> {
                    livro.setPreco(req.getNovoPreco());
                    repository.save(livro);
                    atualizados.add(livro.getTitulo());
                    contador.incrementAndGet();
                });
            }
            @Override
            public void onError(Throwable t) {
                System.err.println("[CLIENT STREAM] Erro: " + t.getMessage());
            }
            @Override
            public void onCompleted() {
                System.out.println("[CLIENT STREAM] Lote concluido. "
                    + contador.get() + " atualizados.");
                responseObserver.onNext(
                    ResumoAtualizacao.newBuilder()
                        .setTotalAtualizados(contador.get())
                        .setMensagem("Atualizados: " + String.join(", ", atualizados))
                        .build()
                );
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<MonitorarRequest> monitorarPrecos(
            StreamObserver<PrecoUpdate> responseObserver) {

        System.out.println("[BIDIRECIONAL] Stream aberto.");

        return new StreamObserver<>() {
            @Override
            public void onNext(MonitorarRequest req) {
                System.out.println("[BIDIRECIONAL] Monitorando livro id=" + req.getLivroId());
                repository.findById(req.getLivroId()).ifPresent(livro -> {
                    responseObserver.onNext(
                        PrecoUpdate.newBuilder()
                            .setLivroId(livro.getId())
                            .setTitulo(livro.getTitulo())
                            .setPreco(livro.getPreco())
                            .build()
                    );
                    System.out.println("[BIDIRECIONAL] Enviado: "
                        + livro.getTitulo() + " R$" + livro.getPreco());
                });
            }
            @Override
            public void onError(Throwable t) {
                System.err.println("[BIDIRECIONAL] Erro: " + t.getMessage());
            }
            @Override
            public void onCompleted() {
                System.out.println("[BIDIRECIONAL] Encerrado pelo cliente.");
                responseObserver.onCompleted();
            }
        };
    }

    private LivroResponse toResponse(LivroGrpc livro) {
        return LivroResponse.newBuilder()
            .setId(livro.getId())
            .setTitulo(livro.getTitulo())
            .setAutor(livro.getAutor())
            .setPreco(livro.getPreco())
            .setAnoPublicacao(livro.getAnoPublicacao())
            .build();
    }
}
