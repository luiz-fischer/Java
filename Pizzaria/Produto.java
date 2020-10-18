package Pizzaria;

public class Produto {
    private int id;
    private String sabor;
    private Pedido pedido;

    public Produto(int id, String sabor, Pedido pedido) {
        this.id = id;
        this.sabor = sabor;
        this.pedido = pedido;
        
        pedido.setProduto(this);

    }

    // ======= SETS =======
    public void setId(int id) {
        this.id = id;
    }
    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    // ======= GETS =======
    public int getId() {
        return this.id;
    }
    public String getSabor() {
        return this.sabor;
    }
    public Pedido getPedido() {
        return this.pedido;
    }

    // ======== Impressão ========
    @Override
    public String toString() {
        String print = "\nSabor: "  + this.sabor;

        return print;
    }
    

    // ======== Método equals para comparação de propriedades ========
    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof Produto))
            return false;

        Produto produto = (Produto) object;

        return this.getId() == produto.getId();
    }
}