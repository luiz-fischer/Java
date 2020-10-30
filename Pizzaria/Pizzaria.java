package Pizzaria;

public class Pizzaria {
    public static void main(String[] args) {

        // Criação dos valores para a classe Cliente
        Cliente cliente1 = new Cliente(1, "José da Silva");
        Cliente cliente2 = new Cliente(2, "Pedro Alves");
        Cliente cliente3 = new Cliente(3, "Mariazinha ");

        // Criação dos valores para a classe Produto.
        Produto calabresa = new Produto(1, "Calabresa", "Calabresa, Mussarela, Molho de Tomate e Oregano");
        Produto mussarela = new Produto(2, "Mussarela", "Molho de Tomate, Mussarela");
        Produto frangoBacon = new Produto(3, "Frango com Bacon",
                "Frango desfiado, Bacon, Mussarela, Molho de Tomate e Oregano");
        // Criação dos valores para a classe bebida
        Bebida semBebida = new Bebida(1, null);
        Bebida bebida1 = new Bebida(2, "Coca Cola Lata 350ml");
        Bebida bebida2 = new Bebida(3, "Fanta Sabor Uva Lata 350ml");
        Bebida bebida3 = new Bebida(4, "Água Sem Gás 1,5L");

        // Criação dos valores para a classe Pedido.
        Pedido pedido1 = new Pedido(cliente1, calabresa, semBebida);
        Pedido pedido2 = new Pedido(cliente2, mussarela, bebida1);
        Pedido pedido3 = new Pedido(cliente1, frangoBacon, bebida2);
        Pedido pedido4 = new Pedido(cliente2, frangoBacon, bebida3);
        Pedido pedido5 = new Pedido(cliente3, calabresa, bebida1);

        // Impressão
        System.out.println(pedido1);
        System.out.println(pedido2);
        System.out.println(pedido3);
        System.out.println(pedido4);
        System.out.println(pedido5);

    }

}