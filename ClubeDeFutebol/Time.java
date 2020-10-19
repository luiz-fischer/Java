package ClubeDeFutebol;

import java.util.ArrayList;

// ======== Classe Time ========
public class Time {
    private int id;
    private String nome;
    private String sigla;
    private String descricaoEscudo;
    private int anoDeFundacao;
    private double rendaMedia;
    private ArrayList<Tecnico> tecnicos;
    private ArrayList<Jogador> jogadores;
    private ArrayList<Jogo> mandantes;
    private ArrayList<Jogo> visitantes;
    private Time time;

    /**
     * 
     * @param id              Id do Time
     * @param nome            Nome do Time
     * @param sigla           Sigla para o Time
     * @param descricaoEscudo Descrição do escudo
     * @param anoDeFundacao   Ano de fundação do Time
     * @param rendaMedia      Renda Média do Time
     */
    public Time(int id, String nome, String sigla, String descricaoEscudo, int anoDeFundacao, double rendaMedia) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.anoDeFundacao = anoDeFundacao;
        this.descricaoEscudo = descricaoEscudo;
        this.rendaMedia = rendaMedia;

        this.tecnicos = new ArrayList();
        this.jogadores = new ArrayList<>();
        this.mandantes = new ArrayList<>();
        this.visitantes = new ArrayList<>();

    }

    // ======== SETS ========
    public void setId(int id) {
        this.id = id;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setJogador(Jogador jogador) {
        this.jogadores.add(jogador);
        jogador.setTime(this);
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnicos.add(tecnico);
        tecnico.setTime(this);
    }

    public void setMandante(Jogo jogo) {
        this.mandantes.add(jogo);
    }

    public void setVisitante(Jogo jogo) {
        this.visitantes.add(jogo);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setDescricaoEscudo(String descricaoEscudo) {
        this.descricaoEscudo = descricaoEscudo;
    }

    public void setAnoDeFundacao(int anoDeFundacao) {
        this.anoDeFundacao = anoDeFundacao;
    }

    public void setRendaMedia(double rendaMedia) {
        this.rendaMedia = rendaMedia;
    }

    // ======== GETS ========
    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getSigla() {
        return this.sigla;
    }

    public String getDescricaoEscudo() {
        return this.descricaoEscudo;
    }

    public double getRendaMedia() {
        return this.rendaMedia;
    }

    public Time getTime() {
        return this.time;
    }

    public ArrayList<Jogador> getJogadores() {
        return this.jogadores;
    }

    public ArrayList<Tecnico> getTecnico() {
        return this.tecnicos;
    }

    public ArrayList<Jogo> getMandantes() {
        return this.mandantes;
    }

    public ArrayList<Jogo> getVisitantes() {
        return this.visitantes;
    }

    // ======== Metodo para impressão utilizando ToString ========
    @Override
    public String toString() {
        String print = "\n++++++ Clube: " + this.nome + " ++++++\n" + "\nSigla: " + this.sigla + "\nBrasão: "
                + this.descricaoEscudo + "\nFundado em: " + this.anoDeFundacao + "\nRenda Média: " + this.rendaMedia
                + "\n" + "\n ======= Técnico ======= " + "\n";
        for (Tecnico tecnico : tecnicos) {
            print += tecnico + "\n";
        }

        print += " ======= Jogadores ======= \n";
        for (Jogador jogador : jogadores) {
            print += jogador + "\n";
        }

        print += "\n ####### Jogos em Casa ####### \n";
        for (Jogo mandante : mandantes) {
            print += mandante + "\n";
        }

        print += "\n ####### Jogos Fora ####### " + "\n";
        for (Jogo visitante : visitantes) {
            print += visitante + "\n";
        }

        return print;
    }

    // ======== Metodo equals para comparação de propriedades ========
    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof Time))
            return false;

        Time time = (Time) object;

        return this.getId() == time.getId();
    }

}