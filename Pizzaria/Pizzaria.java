package Pizzaria;

public class Pizzaria {
    public static void main(String[] args) {
        
        Cliente cliente1 = new Cliente(1, "José da Silva", 1);

        Pedido pedido1 = new Pedido(1, cliente1);

        Produto calabresa = new Produto(1, "Calabresa", pedido1);
        

        System.out.println(cliente1);

        
    }
    
}
