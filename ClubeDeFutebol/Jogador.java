package ClubeDeFutebol;

// ======== Classe Jogador ========
public class Jogador {
    private int id;
    private String nome;
    private String dataDeNascimento;
    private String posicao;
    private double salario;
    private Time time;

    /**
     * 
     * @param id               Id para o Jogador
     * @param nome             Nome do Jogador
     * @param dataDeNascimento Data de Nascimento do Jogador
     * @param posicao          Posição do Jogador
     * @param salario          Salário do Jogador
     * @param time             Time do jogador
     */
    public Jogador(int id, String nome, String dataDeNascimento, String posicao, double salario, Time time) {
        this.id = id;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.posicao = posicao;
        this.salario = salario;

        time.setJogador(this);

    }

    // ======== SETS ========
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public void setSalario(double salario) {
        this.salario = salario;
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

    public String getDataDeNascimento() {
        return this.dataDeNascimento;
    }

    public String getPosicao() {
        return this.posicao;
    }

    public String getSalario() {
        return String.format("R$ %.2f", this.salario);
    }

    public Time getTime() {
        return this.time;
    }

    // ======== Impressão ========
    @Override
    public String toString() {
        return "(" + this.posicao + ") " + this.getNome() + ". " + this.getSalario();
    }

    // ======== Método equals para comparação de propriedades ========
    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof Jogador))
            return false;

        Jogador jogador = (Jogador) object;

        return this.getId() == jogador.getId();
    }

}