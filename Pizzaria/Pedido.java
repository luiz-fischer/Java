package Pizzaria;

import java.util.ArrayList;

public class Pedido {
    private int id;
    private Cliente cliente;
    private ArrayList<Produto> produtos;
    private Pedido pedido;

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;

        this.produtos = new ArrayList<>();

        cliente.setPedido(this);
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    public void setProduto(Produto produto) {
        this.produtos.add(produto);
        produto.setPedido(this);
    }

    public int getId() {
        return this.id;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    public Pedido getPedido() {
        return this.pedido;
    }
    public ArrayList<Produto> getProduto() {
        return this.produtos;
    }
    // ======== Impressão ========
    @Override
    public String toString() {
        String print = "\nPedido Número : "  + cliente.getPedidoNumero();
        print += "\n ======== SABORES ========" + "\n";
        for (Produto produto : produtos) {
            print += produto;
        }

        return print;
    }

    // ======== Método equals para comparação de propriedades ========
    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof Pedido))
            return false;

        Pedido pedido = (Pedido) object;

        return this.getId() == pedido.getId();
    }
}
