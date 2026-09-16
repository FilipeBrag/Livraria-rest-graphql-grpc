INSERT INTO autor (id, nome, nacionalidade, biografia) VALUES
(1, 'Robert C. Martin', 'Americano', 'Engenheiro de software, autor e palestrante. Conhecido como "Uncle Bob", é um dos signatários do Manifesto Ágil.'),
(2, 'Martin Fowler',    'Britânico',  'Autor e palestrante sobre design de software, padrões de projeto e metodologias ágeis. Trabalha na ThoughtWorks.'),
(3, 'Eric Evans',       'Americano', 'Consultor de software especialista em design orientado a domínio (DDD). Autor do livro seminal sobre o tema.');

INSERT INTO livro (id, titulo, isbn, sinopse, num_paginas, editora, idioma, ano_publicacao, preco, autor_id) VALUES
(1, 'Código Limpo',             '978-8576082675', 'Um guia de boas práticas para escrever código legível, manutenível e eficiente.',           431, 'Alta Books', 'Português', 2009, 89.90,  1),
(2, 'O Codificador Limpo',      '978-8576086475', 'Um código de conduta para programadores profissionais, abordando ética e responsabilidade.', 240, 'Alta Books', 'Português', 2012, 79.90,  1),
(3, 'Refatoração',              '978-8575227572', 'Técnicas para melhorar o design de código existente sem alterar seu comportamento externo.',  448, 'Bookman',   'Português', 2018, 99.90,  2),
(4, 'Padrões de Arquitetura',   '978-0321127426', 'Catálogo de padrões para construção de aplicações empresariais robustas e escaláveis.',      533, 'Addison',   'Inglês',    2002, 120.00, 2),
(5, 'Domain-Driven Design',     '978-0321125217', 'Abordagem para desenvolvimento de software complexo alinhado ao domínio do negócio.',        560, 'Addison',   'Inglês',    2003, 130.00, 3);

INSERT INTO avaliacao (id, nota, comentario, avaliador, livro_id) VALUES
(1,  5, 'Essencial para qualquer desenvolvedor. Mudou minha forma de escrever código.', 'Carlos S.',  1),
(2,  4, 'Muito bom, mas alguns exemplos ficaram datados. Vale muito a leitura.',        'Ana P.',     1),
(3,  5, 'Complementa perfeitamente o Código Limpo. Leitura obrigatória.',               'João M.',    2),
(4,  5, 'O melhor livro sobre refatoração que já li. Exemplos práticos e claros.',      'Mariana L.', 3),
(5,  3, 'Bom conteúdo, mas a linguagem é um pouco densa para iniciantes.',             'Pedro R.',   4),
(6,  5, 'Referência absoluta em DDD. Denso, mas cada página vale o esforço.',          'Lucas T.',   5),
(7,  4, 'Transformou minha visão sobre modelagem de domínio.',                          'Fernanda C.',5);
