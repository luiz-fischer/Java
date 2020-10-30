package Veiculo;
public class Aplicacao {

    public static void main(String[] args) {

        System.out.println("Carro");
        Carro c = new Carro("XYZ", "ABC", 4545, false);
        // c.setQuatroPortas(true);
        c.imprimirDados();
        c.buzinar();

        System.out.println("Motocicleta");
        Veiculo m = new Motocicleta("QQQ", "ZZZ", 2017); // Perceba aqui o Polimorfismo ao criar um novo objeto
        m.imprimirDados();
        m.empinar();

        // System.out.println("Caminhão");
        // Caminhao cam = new Caminhao();
        // cam.buzinar();
        // cam.imprimirDados();
    }
}