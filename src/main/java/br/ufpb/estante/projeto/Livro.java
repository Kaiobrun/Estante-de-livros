package br.ufpb.estante.projeto;
import java.util.Objects;

public class Livro {

    private String titulo;
    private String autor;
    private String genero;
    private int quantidadePaginas;
    private String status; // "Lido", "Lendo", "Não lido", etc.


    public Livro(String titulo, String autor, String genero, int quantidadePaginas, String status) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.quantidadePaginas = quantidadePaginas;
        this.status = status; // Status padrão
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getQuantidadePaginas() {
        return quantidadePaginas;
    }
    public void setQuantidadePaginas(int quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Livro de título " + "'" +titulo + "'" + " do autor: " + autor + ", de genero: " + genero + ", com " + quantidadePaginas +" páginas, com status: " + status + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return quantidadePaginas == livro.quantidadePaginas && Objects.equals(titulo, livro.titulo) && Objects.equals(autor, livro.autor) && Objects.equals(genero, livro.genero) && Objects.equals(status, livro.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, genero, quantidadePaginas, status);
    }
}