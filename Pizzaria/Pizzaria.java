package Pizzaria;

public class Pizzaria {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1, "José da Silva");
        Cliente cliente2 = new Cliente(2, "Pedro Alves");
        // Cliente cliente3 = new Cliente(3, "Pedro Alves", 2);

        Produto calabresa = new Produto("Calabresa","Calabresa, Mussarela, Molho de Tomate e Oregano");
        Produto mussarela = new Produto("Mussarela", "Molho de Tomate, Mussarela");
        Produto frangoBacon = new Produto("Frango com Bacon", "Frango desfiado, Bacon, Mussarela, Molho de Tomate e Oregano");

        Pedido pedido1 = new Pedido(cliente1, calabresa);
        Pedido pedido2 = new Pedido(cliente2, mussarela);
        Pedido pedido3 = new Pedido(cliente1, frangoBacon);
        Pedido pedido4 = new Pedido(cliente2, frangoBacon);

         
        
        System.out.println(pedido1);
        // System.out.println(cliente1);
        System.out.println(pedido2);
        System.out.println(pedido3);
        System.out.println(pedido4);

        
    }
    
}