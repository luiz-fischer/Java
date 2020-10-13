package ProvaDois;

import java.util.ArrayList;

public class Franquia {
    int idFranquia;
    String nome;
    String apelido;
    String dataDeCriacao;   
    ArrayList<Heroi> herois;

    public static ArrayList<Franquia> franquias = new ArrayList<>();

    /**
     * Construtor do Objeto da Franquia
     * @param idFranquia Identificador unico da Franquia
     * @param nome Nome da Franquia
     * @param apelido Apelido da Franquia
     * @param dataDeCriacao Data de criação da Franquia
     */
    public Franquia(int idFranquia, String nome, String apelido, String dataDeCriacao) {
        this.idFranquia = idFranquia;
        this.nome = nome;
        this.apelido = apelido;
        this.dataDeCriacao = dataDeCriacao;
        this.herois = new ArrayList<>();

        franquias.add(this);
    } 

    public Franquia(int idFranquia, String nome) {
        this(idFranquia, nome, "", "");
    }

    /**
     * Imprimi os valores da Franquia
     */
    public void imprimirFranquias() {
        System.out.println(
            "* A Franquia " + 
            this.nome + 
            " tem "  + 
            this.herois.size() + 
            " Herois "
        );  
                        
    }
  
}
