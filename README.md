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
# 📬 Exemplos de Requisições HTTP
➕ POST /livros – Exemplo de JSON para criação de livro:
## 📬 Exemplo de JSON para criação de livro

```json
{
  "titulo": "o hobbit",
  "editora": "estrela",
  "dataDePublicacao": "2000-10-21",
  "genero": "TERROR",
  "preco": 120.10,
  "disponivel": true,
  "autores": [
    {
      "nomeCompleto": "Bruno Beneduzi",
      "dataDeNascimento": "1999-01-21",
      "nacionalidade": "brasileiro"
    }
  ]
}
```
## 🔎 GET /livros – Filtro de livros com parâmetros opcionais
Este endpoint permite buscar livros cadastrados no sistema com base em filtros como autor, título, gênero e disponibilidade.

✅ Parâmetros disponíveis:
Parâmetro	Tipo	Descrição
autor	String	Nome ou sobrenome do autor a ser buscado.
titulo	String	Título (ou parte do título) do livro.
genero	String	Gênero literário a ser filtrado.
disponivel	Boolean	Indica se o livro está disponível para venda (true/false).

GET /livros?autor=bruno


GET /livros?titulo=o+senhor+dos+aneis


GET /livros?genero=terror


GET /livros?disponivel=false

🎭 Gêneros disponíveis para cadastro:
FICCAO_CIENTIFICA
FANTASIA,
ROMANCE,
TERROR,
SUSPENSE,
BIOGRAFIA,
AVENTURA,
DRAMA,
POESIA,
DIDATICO,
COMEDIA,
HISTORIA,
CIENCIA,
ESPIRITUALIDADE,
NEGOCIOS,
ECONOMIA,
TECNOLOGIA,
COMPUTACAO,
SAUDE,
EDUCACAO,
DIREITO,
MITOLOGIA

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

## 🔧 Como Rodar o Projeto
💻 IDE recomendada: Qualquer IDE que suporte Java. Eu recomendo o Eclipse para facilitar o processo, pois foi utilizado neste projeto.

1.1. Como baixar o Eclipse?

🗄️ Este projeto utiliza o banco de dados PostgreSQL, mas você pode usar outro banco de sua preferência. Caso queira usar o PostgreSQL, siga as instruções abaixo:

2.1. Link para baixar o PostgreSQL

2.2. Tutorial de como baixar o PostgreSQL

🌐 Para testar a API e fazer requisições HTTP, você pode usar ferramentas como Insomnia ou Postman.

3.1. [Site do Insomnia](https://insomnia.rest/download)

3.2. [Site do Postman ](https://www.postman.com/downloads/)

3.3. Ambas permitem enviar requisições GET, POST, PUT, DELETE e visualizar as respostas de forma simples.

### Configurar o banco de dados:

No arquivo `application.properties` (ou `application.yml`), configure o acesso ao PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/Lojalivraria
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

