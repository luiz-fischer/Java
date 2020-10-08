package Avaliacao.ProvaDois;

import java.util.ArrayList;

public class Heroi {
    int idHeroi;
    int idFranquia;
    String nome;
    String localizacao;
    double preco;   
    Franquia franquia;
    ArrayList<HeroiFilme> filmes;  
    
    public static ArrayList<Heroi> herois = new ArrayList<>();

    /**
     * 
     * @param idHeroi
     * @param nome
     * @param localizacao
     * @param preco
     * @param franquia
     */
    public Heroi(int idHeroi, String nome, String localizacao, int preco, Franquia franquia) {
        this.idHeroi = idHeroi;
        this.nome = nome;
        this.localizacao = localizacao;
        this.preco = preco;
        
        this.filmes = new ArrayList<>();

        franquia.herois.add(this);

        herois.add(this);
        
    }  
           
    public double qtdInvestimento() {
       double investimento = this.preco * this.filmes.size();
       
       return investimento;
    }
    
    public void imprimirInvestimento() {
        System.out.println(
            "* O Heroi " + 
            this.nome + 
            " Rendimento de R$ " + 
            this.qtdInvestimento()
        );
    }

    public void imprimirQrdFilmes() {
        System.out.println(
            "* O Heroi " +
            this.nome + 
            " participou " + 
            this.filmes.size()
        );
    }
    
}
