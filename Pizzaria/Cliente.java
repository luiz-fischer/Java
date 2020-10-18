package Pizzaria;

import java.util.ArrayList;

public class Cliente {
    private int id;
    private String nome;
    private int pedidoNumero;
    private ArrayList<Pedido> pedidos;
    private Cliente cliente;

    public Cliente(int id, String nome, int pedidoNumero) {
        this.id = id;
        this.nome = nome;
        this.pedidoNumero = pedidoNumero;

        this.pedidos = new ArrayList<>();
    }

    // ======== SETS ========
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPedidoNumero(int pedidoNumero) {
        this.pedidoNumero = pedidoNumero;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void setPedido(Pedido pedido) {
        this.pedidos.add(pedido);
        pedido.setCliente(this);
    }

    // ======== GEST ========
    public int getId() {
        return this.id;
    }
    public String getNome() {
        return this.nome;
    }
    public int getPedidoNumero() {
        return pedidoNumero;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    public ArrayList<Pedido> getPedido() {
        return this.pedidos;
    }

    // ======== Impressão ========
    @Override
    public String toString() {
        String print = " >>>>>>>> CLIENTE <<<<<<<<\n" + getNome();
        for (Pedido pedido : pedidos) {
            print += pedido ;
        }
        
        return print;
    }

    // ======== Método equals para comparação de propriedades ========
    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof Cliente))
            return false;

        Cliente cliente = (Cliente) object;

        return this.getId() == cliente.getId();
    }
}
