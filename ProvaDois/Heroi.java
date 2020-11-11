package ProvaDois;

import java.util.ArrayList;

public class Heroi extends Pessoa {
    protected int idHeroi;
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
    public Heroi(
        int idHeroi, 
        String nome, 
        String localizacao,
        double precoCache,
        int anoDeNascimento,
        Franquia franquia
    ) {
        super(nome, localizacao, precoCache, anoDeNascimento);
        this.idHeroi = idHeroi;

        this.franquia = franquia;
        this.filmes = new ArrayList<>();

        franquia.herois.add(this);
        // herois.add(this);

    }

  

    // ====== SETS ======
    public void setIdHeroi(int idHeroi) {
        this.idHeroi = idHeroi;
    }
    public void setFranquia(Franquia franquia) {
        this.franquia = franquia;
    }
    public void setFilme(Filme filme) {
        this.filmes.add(filme);
    }

    // ====== GETS ======
    public int getIdHeroi() {
        return this.idHeroi;
    }
    public Franquia getFranquia() {
        return this.franquia;
    }

    public ArrayList<HeroiFilme> getFilmes() {
        return this.filmes;
    }
   
    public double qtdInvestimento() {
       double investimento = super.getPrecoCache() * this.filmes.size();
       
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

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof Heroi))
            return false;

        Heroi heroi = (Heroi) object;

        return idHeroi == heroi.idHeroi;
    }

     @Override
     public String toString() {
         String print = super.toString() + "\n" +
                    "========== Dados Heroi ==========" + "\n" +
                    "Franquia: " + this.franquia.nome + "\n" +
                    "Quantidade de Filmes: " + this.filmes.size() + "\n" +
                    "Investimento: " + this.qtdInvestimento();
         return print;
     }
    
}
