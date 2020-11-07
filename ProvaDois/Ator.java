package ProvaDois;

import java.util.ArrayList;

public class Ator extends Pessoa {
    protected int id;
    protected int nivelFama;
  
    
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
        
        
    }

    // ======= SETS =======
    public void setId(int id) { 
        this.id = id;
    }

    public void setNivelFama(int nivelFama) {
        this.nivelFama = nivelFama;
    }

    // ======= GETS =======
    public int getId() {
        return this.id;
    }

    public int getNivelFama() {
        return this.nivelFama;
    }
    
    // ======== Impressão ========
    @Override
    public String toString() {
        String print = super.toString() + "\n" +
                    "========== Famômetro ==========" + "\n" +
                    "Nível da Fama: " + getNivelFama() + "\n";
        return print;
    }
}
