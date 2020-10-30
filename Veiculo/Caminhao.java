package Veiculo;

public class Caminhao extends Veiculo {

    public Caminhao(String marca, String modelo, int ano) {
        super(marca, modelo, ano);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void buzinar() {
        System.out.println("FOM FOM");
    }
}