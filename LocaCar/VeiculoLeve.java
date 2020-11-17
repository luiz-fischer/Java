package LocaCar;

import java.util.ArrayList;

public class VeiculoLeve extends Veiculo implements BaseVeiculo {
    protected int idVeiculoLeve;
    protected static String cor;
    ArrayList<VeiculosLocados> VeiculosLocados;

    public static ArrayList<VeiculoLeve> veiculosLeves = new ArrayList<>();

    public VeiculoLeve() {
        this(0, cor, "", "", 0, 0f);
    }

    public VeiculoLeve(int idVeiculoLeve, String cor, String marca, String modelo, int ano, double valorLocacao) {
        super(marca, modelo, ano, valorLocacao);
        this.idVeiculoLeve = idVeiculoLeve;
        VeiculoLeve.cor = cor;

        this.VeiculosLocados = new ArrayList<>();

        veiculosLeves.add(this);
    }

     // ======== SETS ========
     public void setIdVeiculoLeve(int idVeiculoLeve) {
        this.idVeiculoLeve = idVeiculoLeve;

    }
    public void setCor(String cor) {
        VeiculoLeve.cor = cor;

    }

    // ======== GETS ========
    public int getIdVeiculoLeve() {
        return this.idVeiculoLeve;

    }
    public String getCor() {
        return VeiculoLeve.cor;

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
        String print = seloDaEmpresa() + "\n\n\n" +
                    super.toString() + "\n" +
                    "=> Modelo Leve =======>" + "\n" +
                    "   ====> Cor: " + getCor() + "\n";
        return print;
    }

}