package ClubeDeFutebol;

// ======== Classe Técnico ========
public class Tecnico {
    private int id;
    private String nome;
    private String estiloJogo;
    private Time time;

    // ======== Construtor para a Classe Tecnico ========
    public Tecnico(int id, String nome, String estiloJogo, Time time) {
        this.id = id;
        this.nome = nome;
        this.estiloJogo = estiloJogo;

        time.setTecnico(this);
    }

    // ======== SETS ========
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstiloJogo(String estiloJogo) {
        this.estiloJogo = estiloJogo;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    // ======== GETS ========
    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEstiloJogo() {
        return this.estiloJogo;
    }

    public Time getTime() {
        return this.time;
    }

    // ======= Impressão =======
    @Override
    public String toString() {
        return "Nome: " + getNome() + "\nEstilo de Jogo: " + this.getEstiloJogo() + "\n";
    }

    // ======== Metodo equals para comparação de propriedades ========
    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof Tecnico))
            return false;

        Tecnico tecnico = (Tecnico) object;

        return this.getId() == tecnico.getId();
    }

}
