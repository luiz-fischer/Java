package Pizzaria;

import java.util.ArrayList;

public class Pedido {
    private int idPedido;
    private Cliente cliente;
    private ArrayList<Produto> produtos;
    private Pedido pedido;
    private static int pedidoNumero = 0;

    public Pedido(Cliente cliente) {
        this.idPedido = pedidoNumero++;
        this.cliente = cliente;

        this.produtos = new ArrayList<>();

        cliente.setPedido(this);
    }

    public void setId(int iidPedidod) {
        this.idPedido = idPedido;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void setPedido(Pedido pedido) {
            
            for (int i = 1; i < produtos.size(); i++) {
                pedidoNumero++;
                this.pedido = pedido;
            }
    }
    public void setProduto(Produto produto) {
        this.produtos.add(produto);
        produto.setPedido(this);
    }

    public int getIdPedido() {
        return this.idPedido;
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
        String print = "\nPedido Número : "   + this.idPedido;
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

        return this.getIdPedido() == pedido.getIdPedido();
    }
}