package Veiculo;

public class Carro extends Veiculo {

    private boolean quatroPortas;
    
    public Carro(String marca, String modelo, int ano, boolean quatroPortas) {
        super(marca, modelo, ano);
        this.quatroPortas = quatroPortas;
    }

    public boolean isQuatroPortas() {
        return quatroPortas;
    }

    public void setQuatroPortas(boolean quatroPortas) {
        this.quatroPortas = quatroPortas;
    }

    @Override
    public void imprimirDados() {
        super.imprimirDados();
        System.out.println("Quatro portas: " + quatroPortas);
    }
}
