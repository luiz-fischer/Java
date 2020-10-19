package Pizzaria;

public class Pedido {
    private int idPedido;
    Cliente cliente;
    Produto produto;
    private static int pedidoNumero = 0;

    public Pedido(Cliente cliente, Produto produto) {
        this.idPedido = pedidoNumero++;
        this.cliente = cliente;
        this.produto = produto;
       
    }

    // ======== SETS ========
    public void setId(int idPedido) {
        this.idPedido = idPedido;
    }
    public void setCliente(Cliente cliente) {
        cliente.setCliente(cliente);
    }
    public void setProduto(Produto produto) {
        produto.setProduto(this);
    }
    public void setPedido(Cliente cliente) {
        this.cliente = cliente;
    }

    // ======== GETS ========
    public int getIdPedido() {
        return this.idPedido;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    public Produto getProduto() {
        return this.produto;
    }
    public Cliente getPedido() {
        return this.cliente;
    }

    // ======== Impressão ========
    @Override
    public String toString() {
        String print = "-------Ordem de Serviço-------" + "\nPedido Número : " + getIdPedido() + "\n";
        print += getProduto() + "\n"; 
        print += getCliente()+ "\n";
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