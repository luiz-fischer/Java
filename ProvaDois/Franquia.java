package Avaliacao.ProvaDois;


import java.util.ArrayList;

public class Franquia {
    int idFranquia;
    String nome;
    String apelido;
    String dataDeCriacao;   
    ArrayList<Heroi> herois;

    public static ArrayList<Franquia> franquias = new ArrayList<>();

    /**
     * 
     * @param idFranquia
     * @param nome
     * @param apelido
     * @param dataDeCriacao
     */
    public Franquia(int idFranquia, String nome, String apelido, String dataDeCriacao) {
        this.idFranquia = idFranquia;
        this.nome = nome;
        this.apelido = apelido;
        this.dataDeCriacao = dataDeCriacao;
        this.herois = new ArrayList<>();

        franquias.add(this);
    } 

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
