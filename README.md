
# Estante de Livros

## Descrição

Este projeto Java implementa um sistema de gerenciamento de uma **Estante de Livros**. O sistema permite o cadastro, pesquisa, listagem e persistência de dados de livros, com tratamento de exceções específicas.

O projeto é orientado a objetos, modularizado e fácil de manter.

---

## Funcionalidades

* ✅ Adicionar novos livros.
* ✅ Pesquisar livros por título, autor e gênero.
* ✅ Listar todos os livros cadastrados.
* ✅ Persistir os dados utilizando serialização em arquivo (`livros.dat`).
* ✅ Tratamento de exceções personalizadas.

---

## Estrutura do Projeto

* **Livro.java**
  Classe que representa um livro com:

  * `titulo` (String)
  * `autor` (String)
  * `ano` (int)
  * `genero` (String)

* **Estante.java**
  Interface com as operações da estante:

  * `adicionarLivro()`
  * `buscarPorTitulo()`
  * `buscarPorAutor()`
  * `buscarPorGenero()`
  * `listarLivros()`

* **EstanteList.java**
  Implementação da interface `Estante` utilizando `ArrayList` para armazenar os livros.

* **GravaLivros.java**
  Classe auxiliar para:

  * Salvar livros no arquivo.
  * Carregar livros do arquivo.

* **ProgramaEstanteDeLivros.java**
  Classe principal com menu interativo em console.

* **Exceções Personalizadas**

  * `AutorInexistenteException.java`
  * `GeneroInexistenteException.java`
  * `TituloInexistenteException.java`

---

## Exemplo de Uso

Ao iniciar o programa, o usuário tem as seguintes opções:

```
1 - Adicionar livro
2 - Buscar por título
3 - Buscar por autor
4 - Buscar por gênero
5 - Listar livros
6 - Sair
```

---

## Como Executar

### Pré-requisitos

* Java 8 ou superior instalado na máquina.

### Compilação

No terminal, navegue até o diretório com os arquivos `.java` e execute:

```bash
javac *.java
```

### Execução

Após a compilação, execute:

```bash
java ProgramaEstanteDeLivros
```

---

## Persistência de Dados

* Os livros são armazenados no arquivo `livros.dat` usando **serialização**.
* Ao iniciar o programa, o arquivo é carregado automaticamente, se existir.

---

## Melhorias Futuras (Sugestões)

* Interface gráfica (ex.: JavaFX ou Swing).
* Suporte a múltiplas estantes.
* Gêneros pré-definidos com enum.
* Exportação/importação em formatos como CSV ou JSON.
* Testes unitários com JUnit.
* Melhor tratamento de entrada de dados inválidos.
* Separar persistência (DAO) da lógica de negócio.

---

## Autor

Projeto acadêmico de gerenciamento de estante de livros em Java.

