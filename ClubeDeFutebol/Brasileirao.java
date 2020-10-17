package ClubeDeFutebol;

public class Brasileirao {
    public static void main(String[] args) {

        // Criacao dos Times.
        Time jec = new Time(1, "Joinville Esporte Clube", "J.E.C.", "Vermelho e Branco", 1975, 125446.54);
        Time mogiMirim = new Time(1, "Mogi Mirim Esporte Clube", "M.M.E.C.", "Vermelho e Branco", 1932, 445132.55);
        Time saoPaulo = new Time(3, "São Paulo Futebol Clube", "S.P.F.C.", "Vermelho Branco e Preto", 1930, 2659887.99);

        // Criação dos Técnicos
        Tecnico tecnico1 = new Tecnico(1, "Mourinho", "Retranca", mogiMirim);
        Tecnico tecnico2 = new Tecnico(2, "Joaozinho", "Pra Cima", saoPaulo);
        Tecnico tecnico3 = new Tecnico(3, "Pedrinho", "Posse de Bola", jec);

        // Criacao do Jogador
        // Jogador do JEC
        Jogador jogador1 = new Jogador(1, "Alison Henrique Mira", "01 de Dezembro de 1995", "ATA", 1500, jec);
        Jogador jogador2 = new Jogador(2, "Matheus Paqueta", "12 de março de 1995", "ATA", 2750.99, jec);
        Jogador jogador3 = new Jogador(3, "Romário de Souza ", "20 de Setembro de 1993", "ATA", 2500, jec);
        Jogador jogador4 = new Jogador(4, "Wellington Aleixo", "05 de Janeiro de 1985", "MEI", 1999.99, jec);
        
        // Jogador do Mogi-Mirim
        Jogador jogador5 = new Jogador(5, "Osmar Aparecido", "27 de Março de 1980", "ATA", 150, mogiMirim);
        Jogador jogador6 = new Jogador(6, "Stefano Sean de Sousa", "18 de Setembro de 1998", "MEI", 300, mogiMirim);
        Jogador jogador7 = new Jogador(7, "Eder Luís de Carvalho", "14 de Maio de 1984", "DEF", 100, mogiMirim);
        Jogador jogador8 = new Jogador(8, "Fabricio Vasconcelos", "14 de Setembro de 1992", "ATA", 100, mogiMirim);

        // Jogador do São-Paulo
        Jogador jogador9 = new Jogador(9, "Daniel Alves", "06 de Maio de 1983", "MEI", 80000, saoPaulo);
        Jogador jogador10 = new Jogador(10, "Alexandre Pato", "02 de Setembro de 1989", "ATA", 100000, saoPaulo);
        Jogador jogador11 = new Jogador(11, "Anderson Hernanes", "29 de Maio de 1985", "MEI", 75000, saoPaulo);
        Jogador jogador12 = new Jogador(12, "Diego Costa", "07 de Julho de 1999", "DEF", 25000, saoPaulo);

        // Criacao dos jogos
        new Jogo(1, "16/06/2020", "Estádio Cícero Pompeu de Toledo", saoPaulo, mogiMirim);
        new Jogo(2, "05/07/2020", "Estádio Vail Chaves", mogiMirim, saoPaulo);
        new Jogo(3, "22/06/2020", "Arena Joinville", jec, mogiMirim);
        new Jogo(4, "09/07/2020", "Estádio Vail Chaves", mogiMirim, jec);
        new Jogo(5, "05/08/2020", "Estádio Cícero Pompeu de Toledo", saoPaulo, jec);
        new Jogo(6, "25/08/2020", "Arena Joinville", jec, saoPaulo);

        System.out.println(jec);
        System.out.println(mogiMirim);
        System.out.println(saoPaulo);

    }
}
