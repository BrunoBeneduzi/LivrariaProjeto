# 📚 API de Livraria

Esta é uma API RESTful desenvolvida em **Java com Spring Boot** para gerenciar uma livraria. A aplicação permite o cadastro, listagem, edição, exclusão e compra de livros, com armazenamento dos dados em um banco **PostgreSQL**.

---

## 🚀 Funcionalidades

### 📖 Livros
- **Criar livro**: cadastra um novo livro com título, gênero, editora, data de publicação, preço e autores.  
  ➤ Autores com mesmo nome e sobrenome não são duplicados.

- **Editar livro**: permite alterar as informações do livro, **exceto o status de venda**.

- **Excluir livro**: remove um livro existente.  
  ➤ Retorna erro se o livro não for encontrado.

- **Listar livros**: exibe livros com os seguintes campos:
  - ID
  - Título
  - Gênero literário
  - Preço
  - Disponibilidade para venda
  - Nome e sobrenome dos autores (em um único campo)  
  ➤ Pode ser filtrado por título, gênero, autor e status de venda.

- **Comprar livro**: efetua a compra de um livro, recebendo:
  - Nome e sobrenome do comprador
  - Forma de pagamento: `pix`, `crédito`, ou `débito`
  - Se é estudante (desconto de 50%)
  - Livro desejado  
  ➤ Retorna informações do livro comprado e o valor final pago.  
  ➤ Caso o livro não esteja disponível, retorna uma mensagem de erro.

---

## 🧾 Tecnologias utilizadas

- ✅ Java 17+  
- ✅ Spring Boot  
- ✅ Spring Web  
- ✅ Spring Data JPA  
- ✅ Bean Validation  
- ✅ PostgreSQL  
- ✅ API RESTful

---

## ⚙️ Como executar o projeto

### Pré-requisitos:
- Java 17+
- PostgreSQL instalado e rodando
- Maven

### Configurar o banco de dados:

No arquivo `application.properties` (ou `application.yml`), configure o acesso ao PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/Lojalivraria
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true



