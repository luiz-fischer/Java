package LocaCar;


public class Teste {
    public static void main(String[] args) {


        Cliente cliente1 = new Cliente(1, "Joao Pedro", "10/10/1985", "26647393");
        Cliente cliente2 = new Cliente(2, "Luiz Otavio Fischer" , "10/12/1900", "123123");
        VeiculoLeve teste1 = new VeiculoLeve(1, "Azul ", "Ford", "Fiesta Hatch", 1987, 100.89);
        VeiculoLeve teste2 = new VeiculoLeve(2, "Preto ", "Fiat", "Uno Com escada em Cima", 1987, 200);
        // VeiculoPesado teste2 = new VeiculoPesado(1, "CATEGORIA AC", "Volvo ", "Scani", 2020, 1500.99);
        Locacao locacao1 = new Locacao(1, 1, "10/11/2020", "20/11/2020");
        Locacao locacao2 = new Locacao(2, 2, "20/11/2020", "20/12/2020");
        // Locacao locacao3 = new Locacao(3, 2, "20/10/2020", "27/10/2020");

        // VeiculosLocados locados = new VeiculosLocados(1, locacao2, teste1);
        VeiculosLocados locados2 = new VeiculosLocados(2, 2, 1);
        // VeiculosLocados locados3 = new VeiculosLocados(3, 3, 1);


        System.out.println(cliente1);
        // System.out.println(cliente2);
        System.out.println(locacao1);
        // System.out.println(teste1);
        // System.out.println(teste2);
        // System.out.println(teste1.seloDaEmpresa());
        // System.out.println("TESTE\n");
        // System.out.println(locados);
        // System.out.println(locados3);

        // for (VeiculosLocados s : VeiculosLocados.veiculosLocados) {
        //     System.out.println(s);

            // s.qtdVeiculosLocados();
        // }
    

    //     System.out.println("Clientes");
    //     for (Cliente cliente : Cliente.clientes) {
    //         System.out.println(cliente);
            
    //     }
    //   for (Locacao locacao : Locacao.locacoes) {
    //       System.out.println(locacao);
    //     }
    }

}
