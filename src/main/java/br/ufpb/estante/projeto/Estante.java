package br.ufpb.estante.projeto;

import java.io.IOException;
import java.util.List;

public interface Estante {
    boolean adicionarLivro(Livro livro);
    boolean removerLivro(String autor, String titulo);
    boolean alterarStatusLivro(String autor, String titulo, String novoStatus);
    List<Livro> pesquisarLivroPorGenero(String genero) throws GeneroInexistenteException;
    List<Livro> pesquisarLivroPorTitulo(String titulo) throws TituloInexistenteException;
    List<Livro> pesquisarLivrosDoAutor(String autor) throws AutorInexistenteException;
    List<Livro> pesquisarLivrosPorStatus(String status);
    List<Livro> getLivros();
    void salvarDados() throws IOException;
    void recuperarDados() throws IOException;
}
