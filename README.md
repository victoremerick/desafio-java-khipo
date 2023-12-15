# Desafio Backend | Java

Olá, candidato! Se você chegou até aqui, é porque demonstrou interesse em fazer parte do nosso time. Preparamos um desafio para entendermos um pouco mais sobre suas habilidades como desenvolvedor backend em Java.

## 🚀 Objetivo:

Desenvolver uma API em Java Spring Boot que implemente um sistema de gerenciamento de pedidos para um restaurante, integrando o RabbitMQ para lidar com tarefas assíncronas, como notificações de status do pedido.

## 📜 Requisitos:

### 1. Tecnologias:

- Java 11+
- Spring Boot
- Maven ou Gradle
- Banco de dados de sua escolha (H2, MySQL, PostgreSQL, etc.)
- Testes com JUnit e Mockito
- RabbitMQ
- Documentação da API com Swagger ou similar

### 2. Gerenciamento de Produtos:
- Criar, listar, atualizar e deletar produtos.
- Cada produto deve ter um nome, preço e uma categoria (bebida, entrada, prato principal, sobremesa).

### 3. Gerenciamento de Pedidos
- Criar e listar pedidos.
- Cada pedido deve conter um ou mais produtos e o valor total do pedido.
- Implementar a funcionalidade de adicionar produtos a um pedido.
- Publicar mensagens no RabbitMQ quando um pedido for criado ou atualizado.

### 4. Mensageria com RabbitMQ
- Configurar filas e trocas no RabbitMQ para gerenciar mensagens de pedidos.
- Implementar consumidores para processar mensagens de pedidos (e.g., notificações, atualização de status).

### 5. Validações e Erros:
- Implemente validações para garantir a integridade dos dados.
- Responda com mensagens de erro claras e status HTTP apropriados.

### 6. Autenticação
- Implementar autenticação básica ou JWT para proteger as rotas da API.

### 7. Testes
- Escrever testes unitários e de integração, incluindo testes para a lógica de mensageria.

### 8. Documentação
- Documentar todos os endpoints da API e o fluxo de mensageria com Swagger ou ferramenta similar.

## 🥇 Diferenciais:

- Paginação nos endpoints.
- Registro de logs.
- Dockerização da aplicação.
- Tratamento de erros e rejeições de mensagens no RabbitMQ.
  
## 🗳️ Instruções de Submissão:

1. Faça um fork deste repositório para sua conta pessoal do GitHub.
2. Commit e push suas mudanças para o seu fork.
3. Envie um e-mail para [pedro.miotti@khipo.com.br] com o link do repositório.

## 🧪 Avaliação:

- Estrutura do código e organização.
- Uso adequado das ferramentas e tecnologias.
- Implementação dos requisitos e regras de negócio.
- Integração e eficiência do uso do RabbitMQ.
- Design e usabilidade.
- Funcionalidades extras (diferenciais).

Boa sorte com o desafio! Estamos ansiosos para ver sua solução.
