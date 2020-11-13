package ProvaDois;

import java.util.ArrayList;

public class Ator extends Pessoa implements Orcamento {
    protected int id;
    protected int nivelFama;
    ArrayList<Filme> filmes;
  
    
    /**
     * 
     * @param id Valor para o id do objeto Ator.
     * @param nome Valor para o nome do objeto Ator.
     * @param localizacao Valor para o localizacao do objeto Ator.
     * @param precoCache Valor para o precoCache do objeto Ator.
     * @param anoDeNascimento Valor para o anoDeNascimento do objeto Ator.
     * @param nivelFama Valor para o nivelFama do objeto Ator.
     */
    public Ator(
        int id,
        String nome, 
        String localizacao, 
        double precoCache,
        int anoDeNascimento, 
        int nivelFama
    ) {
        super(nome, localizacao, precoCache, anoDeNascimento);
        this.id = id;
        this.nivelFama = nivelFama;
        this.filmes = new ArrayList<>();
    }

    // ======= SETS =======
    public void setId(int id) { 
        this.id = id;
    }

    public void setNivelFama(int nivelFama) {
        this.nivelFama = nivelFama;
    }

    public void setFilme(Filme filme) {
        this.filmes.add(filme);
    }

    // ======= GETS =======
    public int getId() {
        return this.id;
    }

    public int getNivelFama() {
        return this.nivelFama;
    }

    public ArrayList<Filme> getFilmes() {
        return this.filmes;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof Ator))
            return false;

        Ator ator = (Ator) object;
        return id == ator.id;
    }
    
    public double qtdInvestimento() {
        double investimento = super.getPrecoCache() * this.filmes.size();

        return investimento;
    }

    // ======== Impressão ========
    @Override
    public String toString() {
        String print = super.toString() + "\n" +
                    "========== Famômetro ==========" + "\n" +
                    "Nível da Fama: " + getNivelFama() + "\n" + "\n" +
                    "Investimento: " + this.qtdInvestimento();
        return print;
    }

   
}
