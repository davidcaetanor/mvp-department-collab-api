# Departments & Collaborators API

Projeto back-end desenvolvido para estudo e portfólio, simulando um sistema de **departamentos, gestores e colaboradores**.

O objetivo principal é praticar **Java com Spring Boot**, modelagem de dados, relacionamentos JPA e uso de **DTOs e Mappers** para evitar acoplamento entre camadas.

---

## Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Lombok
- Bean Validation

---

## Funcionalidades

- Cadastro de departamentos
- Associação de um gestor a um departamento (1:1)
- Cadastro de colaboradores
- Associação de colaboradores a departamentos (1:N)
- Uso de DTOs para entrada e saída de dados
- Mapeamento entre Model ↔ DTO

---

## Estrutura do projeto

- `controller` – Camada de entrada da API
- `service` – Regras de negócio
- `model` – Entidades JPA
- `dto` – Objetos de transferência de dados
- `mapper` – Conversão entre Model e DTO
- `repository` – Acesso ao banco de dados

---

## Como executar o projeto

1. Clone o repositório
2. Configure o banco PostgreSQL
3. Ajuste o `application.properties` com suas variaveis de ambiente
4. Execute a aplicação

---

## Objetivo do projeto

Projeto desenvolvido com foco em **aprendizado**, organização de código e boas práticas no desenvolvimento de APIs REST com Spring Boot.

