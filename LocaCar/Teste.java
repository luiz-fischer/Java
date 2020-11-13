package LocaCar;

public class Teste {
    public static void main(String[] args) {
        VeiculoLeve teste1 = new VeiculoLeve(1, "Azul", "marca", "modelo", 1987, 100.89);
        VeiculoPesado teste2 = new VeiculoPesado(1, "Restrição", "Volvo", "sei lá", 2020, 1500.99);
        Cliente cliente1 = new Cliente(1, "Joao Pedro", "10/10/1985", "26647393", 7);

        Locacao locacao1 = new Locacao(1, 1, 13/11/2020, 20/11/2020, cliente1);

        VeiculosLocados locados = new VeiculosLocados(locacao1, teste1, teste2);


        System.out.println(teste1);
        System.out.println(teste2);
        System.out.println(teste1.seloDaEmpresa());
        // System.out.println(locacao1);
        System.out.println("Clientes");
        for (Cliente cliente : Cliente.clientes) {
            cliente.imprimirLocacoes();
            
        }
a        for (Locacao locacao : Locacao.locacoes) {
            locacao.imprimirValorTotal();
        }
    }
}
