package ProvaDois;

public class Princial {
    public static void main(String[] args) {
        // Criaçao das Franquias
        Franquia marvel = new Franquia(1, " Marvel Studios ", "Marvel ", "03/09/1980");
        Franquia dc = new Franquia(2, " DC Comics ", "DC ", "05/04/1975");
        
        // Criação dos Herois
        Heroi hulk = new Heroi(1, "Hulk Esmaga ", "USA", 1200, marvel);
        Heroi thor = new Heroi(2, "Thor ", "ValHala", 1300, marvel);
        Heroi batman = new Heroi(3, "Batman " , "Gothan", 14000, dc);
        Heroi flash = new Heroi(4, "Flash ", "MetroCity", 1000, dc);
        
        // Criação dos Filmes
        Filme vingadores = new Filme(1, "Marvel The Avengers ", "11/04/2012", 40000);
        vingadores.addHeroi(hulk);
        vingadores.addHeroi(thor);

        Filme ligaDaJustica = new Filme(2, "Liga da Justiça Contra o Mal ", "15/08/2015", 15000);
        ligaDaJustica.addHeroi(batman);
        ligaDaJustica.addHeroi(flash);

        // Impressão Franquias
        System.out.println("FRANQUIAS");
        for (Franquia franquia : Franquia.franquias) {
            franquia.imprimirFranquias();
        }

        // Impressão dos Herois
        System.out.println("HEROIS");
        for (Heroi heroi : Heroi.herois) {
            heroi.imprimirInvestimento();
            heroi.imprimirQrdFilmes();
        }
        
        System.out.println("FILMES");
        // Impressão dos Filmes
        for (Filme filme : Filme.filmes) {
            filme.imprimirInfoFilme();
            filme.imprimirValoresFilme();
        }



    }
    
    
}
