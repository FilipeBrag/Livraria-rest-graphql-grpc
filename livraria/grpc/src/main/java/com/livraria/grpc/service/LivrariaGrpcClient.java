package com.livraria.grpc.service;

import com.livraria.grpc.proto.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Component
public class LivrariaGrpcClient implements CommandLineRunner {

    @GrpcClient("livraria-grpc")
    private LivrariaServiceGrpc.LivrariaServiceBlockingStub blockingStub;

    @GrpcClient("livraria-grpc")
    private LivrariaServiceGrpc.LivrariaServiceStub asyncStub;

    @Override
    public void run(String... args) throws Exception {
        sep("DEMO gRPC — LIVRARIA");
        Thread.sleep(1200);

        demo1Unario();
        Thread.sleep(500);
        demo2ServerStreaming();
        Thread.sleep(500);
        demo3ClientStreaming();
        Thread.sleep(500);
        demo4Bidirecional();

        sep("DEMO CONCLUIDA");
    }

    private void demo1Unario() {
        sep("1. UNARIO — Buscar Livro por ID");
        System.out.println("Chamando: BuscarLivro(id=1)");
        System.out.println("Equivalente REST: GET /livros/1\n");

        LivroResponse r = blockingStub.buscarLivro(
            BuscarLivroRequest.newBuilder().setId(1L).build()
        );

        System.out.println("Resposta recebida:");
        System.out.println("  Titulo: " + r.getTitulo());
        System.out.println("  Autor:  " + r.getAutor());
        System.out.println("  Preco:  R$" + r.getPreco());
        System.out.println("  Ano:    " + r.getAnoPublicacao());
    }

    private void demo2ServerStreaming() throws InterruptedException {
        sep("2. SERVER STREAMING — Catalogo completo");
        System.out.println("Cada livro chega progressivamente do servidor:\n");

        CountDownLatch latch = new CountDownLatch(1);

        asyncStub.streamCatalogo(
            FiltroRequest.newBuilder().setAutor("").build(),
            new StreamObserver<>() {
                int count = 0;
                @Override public void onNext(LivroResponse l) {
                    System.out.println("  [" + (++count) + "] " + l.getTitulo()
                        + " — " + l.getAutor() + " — R$" + l.getPreco());
                }
                @Override public void onError(Throwable t) { latch.countDown(); }
                @Override public void onCompleted() {
                    System.out.println("\nStream concluido. " + count + " livros recebidos.");
                    latch.countDown();
                }
            }
        );
        latch.await(20, TimeUnit.SECONDS);
    }

    private void demo3ClientStreaming() throws InterruptedException {
        sep("3. CLIENT STREAMING — Atualizar precos em lote");

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<AtualizarPrecoRequest> req =
            asyncStub.atualizarPrecos(new StreamObserver<>() {
                @Override public void onNext(ResumoAtualizacao r) {
                    System.out.println("\nResumo do servidor:");
                    System.out.println("  Total: " + r.getTotalAtualizados());
                    System.out.println("  " + r.getMensagem());
                }
                @Override public void onError(Throwable t) { latch.countDown(); }
                @Override public void onCompleted() { latch.countDown(); }
            });

        long[][] updates = {{1L, 94}, {3L, 104}, {5L, 125}};
        for (long[] u : updates) {
            System.out.println("  -> Enviando: livro id=" + u[0] + " novo preco=R$" + u[1]);
            req.onNext(AtualizarPrecoRequest.newBuilder()
                .setId(u[0]).setNovoPreco(u[1]).build());
            Thread.sleep(300);
        }
        req.onCompleted();
        latch.await(10, TimeUnit.SECONDS);
    }

    private void demo4Bidirecional() throws InterruptedException {
        sep("4. BIDIRECIONAL — Monitorar precos");
        System.out.println("Cliente envia IDs, servidor responde com preco de cada um:\n");

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<MonitorarRequest> req =
            asyncStub.monitorarPrecos(new StreamObserver<>() {
                @Override public void onNext(PrecoUpdate u) {
                    System.out.println("  <- [servidor] " + u.getTitulo() + " R$" + u.getPreco());
                }
                @Override public void onError(Throwable t) { latch.countDown(); }
                @Override public void onCompleted() {
                    System.out.println("\nStream bidirecional encerrado.");
                    latch.countDown();
                }
            });

        long[] ids = {1L, 3L, 5L};
        for (long id : ids) {
            System.out.println("  -> [cliente] Monitorando id=" + id);
            req.onNext(MonitorarRequest.newBuilder().setLivroId(id).build());
            Thread.sleep(400);
        }
        req.onCompleted();
        latch.await(10, TimeUnit.SECONDS);
    }

    private void sep(String t) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("  " + t);
        System.out.println("=".repeat(50));
    }
}
