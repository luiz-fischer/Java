package Zoo;

public class Mamifero extends Animal {
    private String alimento;

 /**
 * 
 * @param nome Valor para o nome do objeto Mamífero.
 * @param comprimento Valor para o comprimento do objeto Mamífero.
 * @param qtdPatas Quantidade de patas do objeto Mamífero.
 * @param cor Valor para a cor do objeto Mamífero.
 * @param ambiente Valor para o ambiente que habita o objeto Mamífero.
 * @param alimento Valor para o alimento para o objeto Mamífero.
 */
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

// ======== Métodos ========
    @Override
    public void darComida() {
        System.out.println("Nhac Nhac!");
    }
    @Override
    public void respiracao() {
        System.out.println("Respira com Ar!");
    }

// ======== Impressão ========
    @Override
    public String toString() {
        String print = "\n\n========== Mamíferos ==========" + "\n";
            print += super.toString();
            print += "Alimentação:  " + getAlimento() + "\n";
        return print;
    }
    
}
