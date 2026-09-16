# Livraria — Exemplo de requisições sincronas
## REST · GraphQL · gRPC — Java / Spring Boot

---

## Pre-requisitos
- Java 17+ (`java -version`)
- Maven 3.8+ (`mvn -version`)

---

## Estrutura
```
livraria/
├── rest/      → porta 8080
├── graphql/   → porta 8081
└── grpc/      → porta 9090
```

---

## REST — porta 8080
cd rest && mvn spring-boot:run

| Metodo | URL                    | Demonstra                              |
|--------|------------------------|----------------------------------------|
| GET    | /livros                | OVERFETCHING — todos os campos voltam  |
| GET    | /livros/1              | UNDERFETCHING — sem avaliacoes         |
| GET    | /livros/1/avaliacoes   | 2a requisicao necessaria               |
| POST   | /livros                | Criar livro                            |
| PUT    | /livros/1              | Atualizar livro                        |
| DELETE | /livros/1              | Remover livro                          |

# Overfetching — campos desnecessarios voltam
curl http://localhost:8080/livros | python3 -m json.tool

# Underfetching — 1a requisicao (sem avaliacoes)
curl http://localhost:8080/livros/1 | python3 -m json.tool

# 2a requisicao necessaria
curl http://localhost:8080/livros/1/avaliacoes | python3 -m json.tool

---

## GraphQL — porta 8081

cd graphql && mvn spring-boot:run

Abra: http://localhost:8081/graphiql

# Sem overfetching — so os campos pedidos
query {
  livros { titulo preco }
}

# Sem underfetching — tudo em 1 requisicao
query {
  livro(id: "1") {
    titulo
    preco
    autor { nome }
    avaliacoes { nota comentario avaliador }
  }
}

# Mutation com retorno seletivo
mutation {
  criarLivro(input: {
    titulo: "Clean Architecture"
    isbn: "978-0134494166"
    preco: 95.00
    autorId: "1"
  }) { id titulo preco }
}

---

## gRPC — porta 9090
cd grpc && mvn spring-boot:run

O servidor sobe e o cliente de demo executa automaticamente.
Observe os 4 tipos de comunicacao nos logs do terminal.

---

## Comparativo rapido

| Operacao        | REST            | GraphQL            | gRPC               |
|-----------------|-----------------|--------------------|--------------------|
| Overfetching    | SIM             | NAO                | NAO                |
| Underfetching   | SIM             | NAO                | NAO                |
| Streaming       | Nao nativo      | Subscription (WS)  | Nativo (4 tipos)   |
| Formato         | JSON texto      | JSON texto         | Protobuf binario   |
| Browser         | Sim             | Sim                | Parcial (gRPC-Web) |
