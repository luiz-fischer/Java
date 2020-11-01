package Zoo;

public class Peixe extends Animal {
    private boolean escamas;

/**
 * 
 * @param nome Valor para o nome do objeto Peixe.
 * @param comprimento Valor para o comprimento do objeto Peixe.
 * @param qtdPatas Quantidade de patas do objeto Peixe.
 * @param cor Valor para a cor do objeto Peixe.
 * @param ambiente Valor para o ambiente que habita o objeto Peixe.
 * @param escamas Valor true ou false para a característica do objeto Peixe.
 */
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
        return this.escamas == true ? "Sim, tem!" : "Não tem!";

    }

// ======== Métodos ========
    @Override
    public void darComida() {
        System.out.println("Glup Glup!");
    }
    @Override
    public void respiracao() {
        System.out.println("Respira com Água!");
    }

// ======== Impressão ========
  @Override
  public String toString() {
    String print = "\n\n========== Peixes ==========" + "\n";
           print += super.toString();
           print += "Tem escamas?:  " + isEscamas() + "\n";
    return print;
  }
    
}
