package Pizzaria;

public class Pizzaria {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1, "José da Silva");
        Cliente cliente2 = new Cliente(2, "Pedro Alves");
        // Cliente cliente3 = new Cliente(3, "Pedro Alves", 2);

        Pedido pedido1 = new Pedido(cliente1);
        Pedido pedido2 = new Pedido(cliente2);
        Pedido pedido3 = new Pedido(cliente1);
        // Pedido pedido3 = new Pedido(3, cliente2);

        Produto calabresa = new Produto(1, "Calabresa", pedido1);
        Produto mussarela = new Produto(2, "Mussarela", pedido2); 
        Produto calabresa = new Produto(1, "Calabresa", pedido3);       
        
        System.out.println(cliente1);
        System.out.println(cliente2);
        
    }
    
}