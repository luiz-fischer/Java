package ProvaDois;


import java.util.ArrayList;

public class Filme {
    int idFilme;
    String nome;
    String dataLancamento;
    double previsaoInvestimento;   
    ArrayList<HeroiFilme> herois;
    
    public static ArrayList<Filme> filmes = new ArrayList<>();

    /**
     * 
     * @param idFilme
     * @param nome
     * @param dataLancamento
     * @param previsaoInvestimento
     */
    public Filme (int idFilme, String nome, String dataLancamento, double previsaoInvestimento) {
        this.idFilme = idFilme;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.previsaoInvestimento = previsaoInvestimento;   
        this.herois = new ArrayList<>();

        filmes.add(this);
    }	

    public void addHeroi(Heroi heroi) {
        HeroiFilme heroiFilme = new HeroiFilme(this, heroi);
        heroi.filmes.add(heroiFilme);
        this.herois.add(heroiFilme); 
                        
    }   
    
    public void imprimirInfoFilme() {
        System.out.println(
            "* O Filme " 
            + this.nome + " tem " 
            + this.herois.size() +
            " Herois"
        );
    }
	public void imprimirValoresFilme() {
        double valorInvestido = this.totalInvestido();

        if (this.previsaoInvestimento > valorInvestido) {
            System.out.println(
                "Lucro de " +
                Math.abs(this.previsaoInvestimento - valorInvestido
            ));
        } else if (this.previsaoInvestimento == valorInvestido) {
            System.out.println(
                "Empatou " + 
                Math.abs(this.previsaoInvestimento - valorInvestido
            ));
        } else {
            System.out.println(
                " Prejuízo de " + 
                Math.abs(this.previsaoInvestimento - valorInvestido
            ));
        }
    }

    public double totalInvestido() {
        double total = 0;

        for (HeroiFilme heroiFilme : herois) {
            total += heroiFilme.heroi.precoCache;
        }
        return total;
    }

}
