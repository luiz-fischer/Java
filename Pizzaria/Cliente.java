package Pizzaria;

import java.util.ArrayList;
public class Cliente {
    private int id;
    private String nome;
    private ArrayList<Pedido> clientes;
    private ArrayList<Pedido> produtos;
    private Cliente cliente;
    private Pedido pedido;

    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
        
        this.clientes = new ArrayList<>();
    }

    // ======== SETS ========
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
   
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // ======== GEST ========
    public int getId() {
        return this.id;
    }
    public String getNome() {
        return this.nome;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    public ArrayList<Pedido> getPedido() {
        return this.produtos;
    }
  

    // ======== Impressão ========
    @Override
    public String toString() {
        String print = "Cliente: " + getNome();
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