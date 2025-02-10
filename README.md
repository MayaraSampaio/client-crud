# CRUD de Clientes - Spring Boot

## 📌 Desafio

Este projeto consiste no desenvolvimento de um **CRUD completo** para gerenciamento de clientes utilizando **Spring Boot**, seguindo os requisitos abaixo:

- Web Service REST com as seguintes operações:
  - **Busca paginada** de clientes.
  - **Busca por ID**.
  - **Inserção de um novo cliente**.
  - **Atualização** de um cliente existente.
  - **Exclusão** de um cliente.
- Banco de dados **H2** configurado para ambiente de testes.
- Uso do **Maven** como gerenciador de dependências.
- Implementação de **tratamento de exceções**:
  - **Id não encontrado** → retorna código `404`.
  - **Erro de validação** → retorna código `422` com mensagens customizadas.
- Seed inicial com pelo menos **10 clientes**.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.0**
- **Spring Data JPA**
- **Banco de Dados H2** (para testes)
- **Bean Validation** (para validação de campos)
- **Maven**

---

## 🛡️ Tratamento de Exceções

| Cenário | Código HTTP | Resposta |
|---------|------------|----------|
| Cliente não encontrado | `404 Not Found` | `{"error": "Cliente não encontrado"}` |
| Nome vazio | `422 Unprocessable Entity` | `{"error": "Nome não pode ser vazio"}` |
| Data de nascimento futura | `422 Unprocessable Entity` | `{"error": "A data de nascimento deve ser no passado ou presente"}` |

