package ProvaDois;

import java.util.ArrayList;

public class Heroi extends Pessoa{
    public int idHeroi;
    public int idFranquia;
    Franquia franquia;
    ArrayList<HeroiFilme> filmes;  
    
    public static ArrayList<Heroi> herois = new ArrayList<>();

    /**
     * 
     * @param idHeroi
     * @param nome
     * @param localizacao
     * @param precoCache
     * @param franquia
     */
    public Heroi(int idHeroi, String nome, String localizacao, int precoCache, Franquia franquia) {
        this.idHeroi = idHeroi;
        super.nome = nome;
        super.localizacao = localizacao;
        super.precoCache = precoCache;
        this.franquia = franquia;
        
        this.filmes = new ArrayList<>();

        franquia.herois.add(this);

        herois.add(this);
        
    }  
           
    public double qtdInvestimento() {
       double investimento = this.precoCache * this.filmes.size();
       
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
