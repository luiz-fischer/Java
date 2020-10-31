package Zoo;

public class Animal {
    protected String nome;
    protected double comprimento;
    protected int qtdPatas;
    protected String cor;
    protected String ambiente;

    public Animal(
        String nome, 
        double comprimento, 
        int qtdPatas, 
        String cor,
        String ambiente
    ) {
        this.nome = nome;
        this.comprimento = comprimento;
        this.qtdPatas = qtdPatas;
        this.cor = cor;
        this.ambiente = ambiente;

    }

// ========== SETS ==========
    public void setNome(String nome) {
        this.nome = nome;

    }
    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;

    }
    public void setQtdPatas(int qtdPatas) {
        this.qtdPatas = qtdPatas;

    }
    public void setCor(String cor) {
        this.cor = cor;

    }
    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;

    }

// ========== GETS ==========
    public String getNome() {
        return this.nome;

    }
    public double getComprimento() {
        return this.comprimento;

    }
    public int getQtdPatas() {
        return this.qtdPatas;

    }
    public String getCor() {
        return this.cor;

    }
    public String getAmbiente() {
        return this.ambiente;

    }

// ======== Impressão ========
  @Override
  public String toString() {
    String print = "========== Animais ==========" + "\n" +
                   "Nome: " + getNome() + "\n" +
                   "Comprimento: " + getComprimento() +  "\n" +
                   "Quantidade de Patas:  " + getQtdPatas() + "\n" +
                   "Cor:  " + getCor() + "\n" +
                   "Ambiente:  " + getAmbiente() + "\n";
    return print;
  }
    
}
