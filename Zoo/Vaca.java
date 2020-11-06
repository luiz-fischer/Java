package Zoo;

public class Vaca extends Animal {
    protected String leite;
    /**
     * 
     * @param leite Valor para o leite do objeto Vaca.
     * @param nome Valor para o nome do objeto Vaca.
     * @param comprimento Valor para o comprimento do objeto Vaca.
     * @param qtdPatas Quantidade de patas do objeto Vaca.
     * @param cor Valor para a cor do objeto Vaca.
     * @param ambiente Valor para o ambiente que habita o objeto Vaca.
     * @param escamas Valor true ou false para a característica do objeto Vaca.
     */
    public Vaca(
        String leite,
        String nome, 
        double comprimento, 
        int qtdPatas, 
        String cor,
        String ambiente,
        String alimento
    ) {
        super(nome, comprimento, qtdPatas, cor, ambiente);
        this.leite = leite;
    }

    // ======== SETS ========
    public void setLeite(String leite) {
        this.leite = leite;

    }

    // ======== GETS ========
    public String getLeite() {
        return this.leite;

    }

    @Override
    public void emitirSom() {
        System.out.println("Múúúúu");
    }

    // ======== Impressão ========
    @Override
    public String toString() {
        String print = "\n\n========== Vaca ==========" + "\n";
            print += super.toString();
            print += "Tipo do Leite: " + this.leite;
        return print;
    }
    
}
