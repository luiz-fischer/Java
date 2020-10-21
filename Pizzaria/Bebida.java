package Pizzaria;

public class Bebida {
    private int id;
    private String nome;
    private Bebida bebida;

    /**
     * 
     * @param id
     * @param nome
     */
    public Bebida(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // SETS
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    // GETS
    public int getId() {
        return this.id;
    }
    public String getNome() {
        return this.nome;
    }
    public Bebida getBebida() {
        return this.bebida;
    }

    // ======== Impressão ========
    @Override
    public String toString() {
        String print = "Bebida: " + getNome(); 
        return print;
    }

    // ======== Método equals para comparação de propriedades ========
    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof Bebida))
            return false;

        Bebida bebida = (Bebida) object;

        return this.getId() == bebida.getId();
    }
    
}
