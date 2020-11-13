package ProvaDois;

public class Princial {
    public static void main(String[] args) {
        // Criaçao das Franquias
        Franquia marvel = new Franquia(1, " Marvel Studios ", "Marvel ", "03/09/1980");
        Franquia dc = new Franquia(2, " DC Comics ", "DC ", "05/04/1975");

        // Criação dos Herois
        Heroi hulk = new Heroi(1, "Hulk Esmaga ", "USA", 1200, 1987, marvel);
        Heroi thor = new Heroi(2, "Thor ", "ValHala", 1300, 1994, marvel);
        Heroi batman = new Heroi(3, "Batman ", "Gothan", 14000, 2000, dc);
        Heroi flash = new Heroi(4, "Flash ", "MetroCity", 1000, 2005, dc);

        // ATORES
        Ator atorHulk = new Ator(1, "Mark Alan Ruffalo", "Kenosha, Wisconsin", 50000, 1967, 7);

        Ator atorThor = new Ator(2, "Christopher Hemsworth", "Melbourne, Austrália", 100000, 1983, 8);

        Ator atorBatman = new Ator(3, "Christian Charles Philip Bale ", " Pembrokeshire, País de Gales,  Reino Unido", 100000, 1974, 9);

        Ator atorFlash = new Ator(4, "Ezra Miller", "Wyckoff, Nova Jersey, EUA", 20000, 1992, 5);

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

        System.out.println(atorHulk);
        System.out.println(atorThor);
        System.out.println(atorBatman);
        System.out.println(atorFlash);


    }

}
