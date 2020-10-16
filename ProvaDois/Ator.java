package ProvaDois;


public class Ator extends Pessoa {
    private int id;
    private int anoDeNascimento;

    public Ator() {

    }

    public Ator(int id,String nome, String localizacao, double precoCache, int anoDeNascimento) {
        this.id = id;
        this.anoDeNascimento = anoDeNascimento;
        this.nome = nome;
        this.localizacao = localizacao;
        this.precoCache = precoCache;
    }

    public String getNome() {
        return super.nome;
    }

    public void setNome() {
        super.nome = nome;
    }

    public String getLocalizacao() {
        return super.localizacao;
    }

    public void setLocalizacao() {
        super.localizacao = localizacao;
    }

    public double getPrecoCache() {
        return super.precoCache;
    }

    public void setPrecoCache() {
        super.precoCache = precoCache;
    }
    

    public int getId() {
        return this.id;
    }

    public void setId(int id) { 
        this.id = id;
    }

    public Ator id(int id) {
        this.setId(id);
        return this;
    }

    public int getAnoDeNascimento() {
        return this.anoDeNascimento;
    }

    public void setAnoDeNascimento(int anoDeNascimento) {
        this.anoDeNascimento = anoDeNascimento;
    }
    
    @Override
    public String toString() {
        return "teste" + super.nome;
    }
}
