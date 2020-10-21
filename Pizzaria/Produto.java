package Pizzaria;

public class Produto {
    private int id;
    private String sabor;
    private String ingredientes;
    Pedido produto;

    /**
     * 
     * @param id           Valor de identeficação para cada Produto
     * @param sabor        Define o sabor de cada Produto
     * @param ingredientes Define os ingredientes
     */
    public Produto(int id, String sabor, String ingredientes) {
        this.id = id;
        this.ingredientes = ingredientes;
        this.sabor = sabor;

    }

    // ======= SETS =======
    public void setId(int id) {
        this.id = id;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public void setIngrediente(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setProduto(Pedido produto) {
        this.produto = produto;
    }


    // ======= GETS =======
    public int getId() {
        return this.id;
    }

    public String getSabor() {
        return this.sabor;
    }

    public String getIngredientes() {
        return this.ingredientes;
    }

    // ======== Impressão ========
    @Override
    public String toString() {
        String print = "Sabor: " + this.sabor + "\nIngredientes: " + getIngredientes();
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