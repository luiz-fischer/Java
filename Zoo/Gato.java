package Zoo;

public class Gato extends Animal {
    protected String pelo;

    /**
     * 
     * @param pelo        Valor para o pelo do objeto Gato.
     * @param nome        Valor para o nome do objeto Gato.
     * @param comprimento Valor para o comprimento do objeto Gato.
     * @param qtdPatas    Quantidade de patas do objeto Gato.
     * @param cor         Valor para a cor do objeto Gato.
     * @param ambiente    Valor para o ambiente que habita o objeto Gato.
     * @param escamas     Valor true ou false para a característica do objeto Gato.
     */
    public Gato(String pelo, String nome, double comprimento, int qtdPatas, String cor, String ambiente,
            String alimento) {
        super(nome, comprimento, qtdPatas, cor, ambiente);
        this.pelo = pelo;
    }

    // ======== SETS ========
    public void setPelo(String pelo) {
        this.pelo = pelo;

    }

    // ======== GETS ========
    public String getPelo() {
        return this.pelo;

    }

    @Override
    public void emitirSom() {
        System.out.println("Miau Miau!");
    }

    // ======== Impressão ========
    @Override
    public String toString() {
        String print = "\n\n========== Gato ==========" + "\n";
        print += super.toString();
        print += "Tipo do Pelo: " + this.pelo;
        return print;
    }

}
