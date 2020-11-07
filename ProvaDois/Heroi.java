package ProvaDois;

import java.util.ArrayList;

public class Heroi extends Pessoa {
    protected int idHeroi;
    protected int idFranquia;
    Franquia franquia;
    ArrayList<HeroiFilme> filmes;
    

    public static ArrayList<Heroi> herois = new ArrayList<>();

    /**
     * 
     * @param idHeroi     Valor para o idHeroi do Objeto Heroi.
     * @param nome        Valor para o nome do Objeto Heroi.
     * @param localizacao Valor para o localizacao do Objeto Heroi.
     * @param precoCache  Valor para o precoCache do Objeto Heroi.
     * @param franquia    Valor para o franquia do Objeto Heroi.
     */
    public Heroi(int idHeroi, String nome, String localizacao, double precoCache, int anoDeNascimento,
            Franquia franquia) {
        super(nome, localizacao, precoCache, anoDeNascimento);
        this.idHeroi = idHeroi;

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
