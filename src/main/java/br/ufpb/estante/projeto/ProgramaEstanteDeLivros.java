package br.ufpb.estante.projeto;
import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class ProgramaEstanteDeLivros {
    public static void main(String[] args){
        Estante estante = new EstanteList();
        boolean continuar = true;
        while (continuar){
            String opcao = JOptionPane.showInputDialog("Digite uma opção: \n1.Adicionar livro\n2.Remover livro\n3.Pesquisar livro pelo autor\n4.Pesquisar livro pelo gênero\n5.Pesquisar livro pelo título\n6.Pesquisar livro por Status\n7.Alterar Status do livro\n8.Ver livros da estante\n9.Salvar Dados\n10.RecuperarDados\n11.Sair");
            if(opcao.equals("1")){
                String titulo = JOptionPane.showInputDialog("Digite o título do livro: ");
                String autor = JOptionPane.showInputDialog("Digite o autor: ");
                String genero = JOptionPane.showInputDialog("Digite o gênero: ");
                String status = JOptionPane.showInputDialog("Digite o Status: ");
                String paginas = JOptionPane.showInputDialog("Digite quantas páginas: ");
                int pag = Integer.parseInt(paginas);
                Livro livro = new Livro(titulo, autor, genero, pag, status);
                estante.adicionarLivro(livro);
                JOptionPane.showMessageDialog(null, "Livro adicionado com sucesso.");
            } else if(opcao.equals("2")){
                String titulo = JOptionPane.showInputDialog("Digite o título do livro a ser removido: ");
                String autor = JOptionPane.showInputDialog("Digite o autor do livro a ser removido: ");
                estante.removerLivro(titulo, autor);
                JOptionPane.showMessageDialog(null, "Livro removido com sucesso!");
            } else if(opcao.equals("3")){  // Pesquisar livro pelo autor
                String livrosDoAutor = JOptionPane.showInputDialog("Digite o autor a pesquisar: ");
                try {
                    List<Livro> livrosAutor = estante.pesquisarLivrosDoAutor(livrosDoAutor);
                    String resultado = "Livros encontrados: \n";
                    for (Livro livro : livrosAutor) {
                        resultado += livro.toString()+ "\n";
                    }
                    JOptionPane.showMessageDialog(null, resultado);
                } catch (AutorInexistenteException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } else if (opcao.equals("4")) {  // Pesquisar livro pelo gênero
                String genero = JOptionPane.showInputDialog("Digite o gênero a pesquisar: ");
                try {
                    List<Livro> livrosGenero = estante.pesquisarLivroPorGenero(genero);
                    String resultado = "Livros encontrados: \n";
                    for (Livro livro : livrosGenero) {
                        resultado += livro.toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, resultado);
                } catch (GeneroInexistenteException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } else if (opcao.equals("5")) {  // Pesquisar livro pelo título
                String titulo = JOptionPane.showInputDialog("Digite o título a pesquisar: ");
                try {
                    List<Livro> livrosTitulo = estante.pesquisarLivroPorTitulo(titulo);
                    String resultado = "Livros encontrados: \n";
                    for (Livro livro : livrosTitulo) {
                        resultado += livro.toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, resultado);
                } catch (TituloInexistenteException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } else if (opcao.equals("6")) {  // Pesquisar livro por status
                String status = JOptionPane.showInputDialog("Digite o status a pesquisar: ");
                List<Livro> livrosStatus = estante.pesquisarLivrosPorStatus(status);
                if (livrosStatus.size() == 0) {  // Verifica se a lista está vazia
                    JOptionPane.showMessageDialog(null, "Nenhum livro encontrado com o status informado.");
                } else {
                    String resultado = "Livros encontrados: \n";
                    for (Livro livro : livrosStatus) {
                        resultado += livro.toString()+ "\n";
                    }
                    JOptionPane.showMessageDialog(null, resultado);
                }
            } else if (opcao.equals("7")) {  // Alterar status do livro
                String titulo = JOptionPane.showInputDialog("Digite o título do livro: ");
                String autor = JOptionPane.showInputDialog("Digite o autor do livro: ");
                String novoStatus = JOptionPane.showInputDialog("Digite o novo status do livro: ");
                boolean sucesso = estante.alterarStatusLivro(autor, titulo, novoStatus);
                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Status alterado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Livro não encontrado para alterar o status.");
                }
            } else if (opcao.equals("8")) {  // Ver todos os livros da estante
                List<Livro> todosLivros = estante.getLivros();
                if (todosLivros.size() == 0) {  
                    JOptionPane.showMessageDialog(null, "Não há livros na estante.");
                } else {
                    String resultado = "Livros na estante: \n";
                    for (Livro livro : todosLivros) {
                        resultado += "Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor() + ", Gênero: " + livro.getGenero() + ", Status: " + livro.getStatus() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, resultado);
                }
            } else if (opcao.equals("9")) {  // Salvar dados
                try {
                    estante.salvarDados();
                    JOptionPane.showMessageDialog(null, "Dados salvos com sucesso.");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar os dados: " + e.getMessage());
                }
            } else if (opcao.equals("10")) {  // Recuperar dados
                try {
                    estante.recuperarDados();
                    JOptionPane.showMessageDialog(null, "Dados recuperados com sucesso.");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao recuperar os dados: " + e.getMessage());
                }
            } else if (opcao.equals("11")) {  // Sair
                continuar = false;
                JOptionPane.showMessageDialog(null, "Programa encerrado.");
            }
        }
    }
}

