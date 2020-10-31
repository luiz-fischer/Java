package Zoo;

public class Peixe extends Animal {
    private boolean escamas;

    public Peixe(
        String nome, 
        double comprimento, 
        int qtdPatas, 
        String cor,
        String ambiente,
        boolean escamas
    ) {
        super(nome, comprimento, qtdPatas, cor, ambiente);
        this.escamas = escamas;
    }

    public void setEscamas(boolean escamas) {
        this.escamas = escamas;

    }
    public String isEscamas() {
        return this.escamas == true ? "Sim, tem!" : "Não possuí!";

    }

// ======== Impressão ========
  @Override
  public String toString() {
    String print = "\n\n========== Peixes ==========" + "\n";
           print += toString();
           print += "Tem escamas?:  " + isEscamas() + "\n";
    return print;
  }
    
}
