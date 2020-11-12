package Zoo;

public class Ovelha extends Animal  {
    private String corDaLa;

    /**
     * 
     * @param corDaLa     Valor para a corDaLa do objeto Ovelha.
     * @param nome        Valor para o nome do objeto Ovelha.
     * @param comprimento Valor para o comprimento do objeto Ovelha.
     * @param qtdPatas    Quantidade de patas do objeto Ovelha.
     * @param cor         Valor para a cor do objeto Ovelha.
     * @param ambiente    Valor para o ambiente que habita o objeto Ovelha.
     * @param escamas     Valor true ou false para a característica do objeto
     *                    Ovelha.
     */
    public Ovelha(String corDaLa, String nome, double comprimento, int qtdPatas, String cor, String ambiente,
            String alimento) {
        super(nome, comprimento, qtdPatas, cor, ambiente);
        this.corDaLa = corDaLa;
    }

    // ======== SETS ========
    public void setCorDaLa(String corDaLa) {
        this.corDaLa = corDaLa;
    }

    // ======== GETS ========
    public String getCorDaLa() {
        return this.corDaLa;
    }

    @Override
    public void emitirSom() {
        System.out.println("Bééééé");
    }

    // ======== Impressão ========
    @Override
    public String toString() {
        String print = "\n\n========== Ovelha ==========" + "\n";
        print += super.toString();
        print += "Cor da Lã: " + this.corDaLa;
        return print;
    }

}
