package Veiculo;

public class Motocicleta extends Veiculo {

    public Motocicleta(String marca, String modelo, int ano) {
        super(marca, modelo, ano);
    }
    
    public void empinar() {
        System.out.println("UHU!");
    }
}