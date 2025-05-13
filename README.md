Livraria: Implementar a API com armazenamento em um banco de dados para gerenciar


livros à venda. Os livros possuem título, gênero literário, um ou mais autores, editora, data


de publicação, preço e se ainda estão disponíveis para venda; Os autores possuem nome,


sobrenome, data de nascimento e nacionalidade. A API deve englobar:


5.1. Criação de livros: Deverá receber todas as informações do livro e seu(s) o(s)
autor(es), e se os mesmos já existem com o mesmo nome e sobrenome, não
devem ser duplicados.


5.2. Alteração: permite editar as propriedades do livro, exceto se foi vendido ou não;

5.3. Exclusão de livros: Se o livro não existe deve retornar um erro e se excluir
corretamente, retornar apenas ok.


5.4. Listagem dos livros: permite filtrar por parte do título, gênero literário, autor e/ou se
está vendido ou não. A lista de retorno deve contar apenas o ID do livro, título,
preço, gênero, se está disponível para venda e o nome e sobrenome do(s) autor(es)
em um único campo.


5.5. Compra: deverá receber o nome e sobrenome do comprador, forma de
pagamento(pix, crédito ou débito), se é estudante e livro desejado. Se for estudante,
terá 50% de desconto. O retorno deve ser as informações do livro comprado e o
preço pago. Se o livro não estiver à venda, deve retornar uma mensagem de erro.
