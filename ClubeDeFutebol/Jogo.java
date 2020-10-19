package ClubeDeFutebol;

// ======== Classe Jogo ========
public class Jogo {
    private int idJogo;
    private String data;
    private String local;
    private Time mandante;
    private Time visitante;

    /**
     * 
     * @param idJogo    Id do Jogo.
     * @param data      Data do Jogo
     * @param local     Local do Jogo.
     * @param mandante  Mandante do Jogo
     * @param visitante Visitante do Jogo
     */
    public Jogo(int idJogo, String data, String local, Time mandante, Time visitante) {
        this.idJogo = idJogo;
        this.data = data;
        this.local = local;
        this.mandante = mandante;
        this.visitante = visitante;

        mandante.setMandante(this);
        visitante.setVisitante(this);
    }

    // ======== SETS ========
    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setMandante(Time mandante) {
        this.mandante = mandante;
    }

    public void setVisitante(Time visitante) {
        this.visitante = visitante;
    }

    // ======== GETS ========
    public int getIdJogo() {
        return this.idJogo;
    }

    public String getData() {
        return this.data;
    }

    public String getLocal() {
        return this.local;
    }

    public Time getMandante() {
        return this.mandante;
    }

    public Time getVisitante() {
        return this.visitante;
    }

    // ======= Impressão =======
    @Override
    public String toString() {
        return "[" + getData() + "]" + "-" + getLocal() + ": " + getMandante().getSigla() + " x "
                + getVisitante().getSigla();
    }

    // ======= Método equals para comparação de propriedades =======
    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof Jogo))
            return false;

        Jogo jogo = (Jogo) object;

        return this.getIdJogo() == jogo.getIdJogo();
    }

}
