package ProvaDois;

public class Pessoa {
    protected String nome;
    protected String localizacao;
    protected double precoCache;
    protected int anoDeNascimento;
    
    /**
     * 
     * @param nome Valor para o nome do objeto Pessoa.
     * @param localizacao Valor para o localizacao do objeto Pessoa.
     * @param precoCache Valor para o precoCache do objeto Pessoa.
     * @param anoDeNascimento Valor para o anoDeNascimento do objeto Pessoa.
     */
    public Pessoa(String nome, String localizacao, double precoCache, int anoDeNascimento) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.precoCache = precoCache;
        this.anoDeNascimento = anoDeNascimento;

    }

     // ======== SETS ========
     public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setPrecoCache(double precoCache) {
        this.precoCache = precoCache;
    }

    public void setAnoDeNascimento(int anoDeNascimento) {
        this.anoDeNascimento = anoDeNascimento;
    }

    // ======== GETS ========
    public String getNome() {
        return this.nome;
    }

    public String getLocalizacao() {
        return this.localizacao;
    }

    public double getPrecoCache() {
        return this.precoCache;
    }

    public int getAnoDeNascimento() {
        return this.anoDeNascimento;
    }

    // ======== Impressão ========
    @Override
    public String toString() {
        String print = "========== Dados Pessoais ==========" + "\n" + 
                    "Nome : " + this.nome + "\n" +
                    "Terra Natal : " + this.localizacao + "\n" +
                    "Preco do Cache : " + this.precoCache + "\n" +
                    "Ano de Nascimento: " + getAnoDeNascimento()  + "\n";
        return print;
    }

}
