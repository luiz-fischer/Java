package Zoo;

public class Mamifero extends Animal {
    private String alimento;

    public Mamifero(
        String nome, 
        double comprimento, 
        int qtdPatas, 
        String cor,
        String ambiente,
        String alimento
    ) {
        super(nome, comprimento, qtdPatas, cor, ambiente);
        this.alimento = alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;

    }
    public String getAlimento() {
        return this.alimento;

    }

// ======== Impressão ========
  @Override
  public String toString() {
    String print = "\n\n========== Mamíferos ==========" + "\n" +
                   "Nome: " + getNome() + "\n" +
                   "Comprimento: " + getComprimento() +  "\n" +
                   "Quantidade de Patas:  " + getQtdPatas() + "\n" +
                   "Cor:  " + getCor() + "\n" +
                   "Ambiente:  " + getAmbiente() + "\n" +
                   "Alimentação:  " + getAlimento() + "\n";
    return print;
  }
    
}
