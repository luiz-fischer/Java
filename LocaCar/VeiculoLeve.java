package LocaCar;

import java.util.ArrayList;

public class VeiculoLeve {
    protected int idVeiculoLeve;
    protected String cor;
    ArrayList<VeiculosLocados> VeiculosLocados;

    public static ArrayList<VeiculoLeve> veiculosLeves = new ArrayList<>();

    public VeiculoLeve(int idVeiculoLeve, String cor) {
        this.idVeiculoLeve = idVeiculoLeve;
        this.cor = cor;

        this.VeiculosLocados = new ArrayList<>();

        veiculosLeves.add(this);
    }

     // ======== SETS ========
     public void setIdVeiculoLeve(int idVeiculoLeve) {
        this.idVeiculoLeve = idVeiculoLeve;

    }
    public void setCor(String cor) {
        this.cor = cor;

    }

    // ======== GETS ========
    public int getIdVeiculoLeve() {
        return this.idVeiculoLeve;

    }
    public String getCor() {
        return this.cor;

    }

    // ====== EQUALS ====== 
    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof VeiculoLeve))
            return false;

        VeiculoLeve veiculoLeve = (VeiculoLeve) object;

        return idVeiculoLeve == veiculoLeve.idVeiculoLeve;
    }

    // ====== IMPRESSÃO ====== 
    @Override
    public String toString() {
        String print = "teste" ; 
        return print;
    }
}