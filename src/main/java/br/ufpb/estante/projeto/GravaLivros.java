package br.ufpb.estante.projeto;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class GravaLivros {

    private String arquivoEstante;

    public GravaLivros(String arquivoEstante) {
        this.arquivoEstante = arquivoEstante;
    }

    public GravaLivros (){
        this("estantes.txt");
    }

    public List<Livro> recuperaEstante() throws IOException{
        BufferedReader leitor = null;
        List<Livro> livrosLidos = new LinkedList<>();
        try{
            leitor = new BufferedReader(new FileReader(this.arquivoEstante));
            boolean acabou = false;
            while(!acabou){
                String linhaLida = leitor.readLine();
                if (linhaLida != null){
                    String [] dadosLivro = linhaLida.split("###");
                    Livro l = new Livro(dadosLivro[0], dadosLivro[1], dadosLivro[2], Integer.parseInt(dadosLivro[3]), dadosLivro[4]);
                    livrosLidos.add(l);
                }else{
                    acabou = true;
                }
            }
            return livrosLidos;
        }finally{
            leitor.close();
        }
    }

    public void gravarLivros(List<Livro> livros) throws IOException {
        BufferedWriter escritor = null;
        try {
            escritor = new BufferedWriter(new FileWriter(this.arquivoEstante));
            for (Livro l : livros) {
                escritor.write(l.getTitulo()+"###"+ l.getAutor()+"###"+l.getGenero()+"###"+l.getQuantidadePaginas()+"###"+l.getStatus()+"\n");
            }
        }finally {
            if (escritor != null) {
                escritor.close();
            }
        }
    }
}
