package br.ufpb.estante.projeto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EstanteList implements Estante {
    private List<Livro> livros=new ArrayList<>();
    private GravaLivros gravador;

    // Adicionar um construtor que inicializa o gravador
    public EstanteList() {
        this.gravador = new GravaLivros();
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public boolean adicionarLivro(Livro novolivro){
        for (Livro l:livros){
            if(l.equals(novolivro)){
                return false;
            }
        }
        this.livros.add(novolivro);
        return true;

    }
    public boolean removerLivro(String autor, String titulo) {
        for (Livro l : livros) {
            if (l.getAutor().equalsIgnoreCase(autor) && l.getTitulo().equalsIgnoreCase(titulo)) {
                livros.remove(l);
                return true;
            }
        }return false;
    }

    public boolean alterarStatusLivro(String autor, String titulo, String novoStatus){
        for(Livro l:livros){
            if(l.getAutor().equalsIgnoreCase(autor)&&l.getTitulo().equalsIgnoreCase(titulo)){
                l.setStatus(novoStatus);
                return true;
            }
        }return false;

    }
    public List<Livro> pesquisarLivroPorGenero(String genero) throws GeneroInexistenteException{
        List<Livro> livrosPorGenero=new ArrayList<>();
        for(Livro l: livros){
            if(l.getGenero().equalsIgnoreCase(genero)){
                livrosPorGenero.add(l);
            }
        }if (livrosPorGenero.isEmpty()){
            throw new GeneroInexistenteException("Gênero não encontrado.");
        }
        return livrosPorGenero;
    }
    public List<Livro> pesquisarLivroPorTitulo(String titulo) throws TituloInexistenteException{
        List<Livro> livrosPorTitulo=new ArrayList<>();
        for(Livro l: livros){
            if(l.getTitulo().equalsIgnoreCase(titulo)){
                livrosPorTitulo.add(l);
            }
        }if(livrosPorTitulo.isEmpty()){
            throw new TituloInexistenteException("Título não encontrado.");
        }
        return livrosPorTitulo;
    }
    public List<Livro> pesquisarLivrosDoAutor(String autor) throws AutorInexistenteException{
        List<Livro> livrosDoAutor=new ArrayList<>();
        for(Livro l: livros) {
            if (l.getAutor().equalsIgnoreCase(autor)) {
                livrosDoAutor.add(l);
            }
        }
        if (livrosDoAutor.isEmpty()){
            throw new AutorInexistenteException("Autor não encontrado.");}

        return livrosDoAutor;
    }
    public List<Livro> pesquisarLivrosPorStatus(String status){
        List<Livro> livrosPorStatus=new ArrayList<>();
        for(Livro l: livros){
            if(l.getStatus().equalsIgnoreCase(status)){
                livrosPorStatus.add(l);
            }
        }return livrosPorStatus;
    }

    public void salvarDados() throws IOException {
        gravador.gravarLivros(this.livros);
    }

    public void recuperarDados() throws IOException {
        this.livros = gravador.recuperaEstante();
    }
}