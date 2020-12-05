package LocaCarv1.views;

import LocaCarv1.models.Cliente;
import LocaCarv1.models.Locacao;
import LocaCarv1.models.VeiculoLeve;
import LocaCarv1.models.VeiculosLocados;

public class Teste {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(1, "nome", "10/10/2000", "123123");
        
        
        VeiculoLeve novo1 = new VeiculoLeve(1, 1, "cor", "marca", "modelo", 9999, 100.10);
        VeiculoLeve novo2 = new VeiculoLeve(2, 2, "cor", "marca", "modelo", 9999, 500.10);
        Locacao locacao2 = new Locacao(1, 2, "19/12/2020");
        // VeiculosLocados locados1 = new VeiculosLocados(1,1, 1, 0);
        // VeiculosLocados locados2 = new VeiculosLocados(1,1, 1, 0);
        // String data = "10/12/2020";
        // Libs.Data.convDataBanco(data);
        // System.out.println(data);
        // for (Locacao string : Locacao.locacoes) {
        //     System.out.println(string);
        //     string.getDataDeLocacao();
        // }
     
        // for (VeiculosLocados ng : VeiculosLocados.veiculosLocados) {
        //     System.out.println(ng);
        // }
        System.out.println(locacao2);
        System.out.println(novo1);
        // System.out.println(cliente);
        // LocalDate data3 = LocalDate.now(); // ou LocalDate.now() para a data3 atual
        // // somar 1 dia = 4 de abril de 2019
        // data3 = data3.plusDays(1);

        // System.out.println(data3);


        // Date a = new Date("2004/09/01");        
        // a.setDate(a.getDate() + 10);     
        

    }
}
