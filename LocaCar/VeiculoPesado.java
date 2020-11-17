package LocaCar;

import java.util.ArrayList;

public class VeiculoPesado extends Veiculo implements BaseVeiculo {
    protected int idVeiculoPesado;
    protected String restricao;
    ArrayList<VeiculosLocados> VeiculosLocados;

    public static ArrayList<VeiculoPesado> veiculosPesados = new ArrayList<>();

    public VeiculoPesado() {
        this(0, "", "", "", 0, 0f);
    }

    public VeiculoPesado(int idVeiculoPesado, String restricao, String marca, String modelo, int ano, double valorLocacao) {
        super(marca, modelo, ano, valorLocacao);
        this.idVeiculoPesado = idVeiculoPesado;
        this.restricao = restricao;
        
        this.VeiculosLocados = new ArrayList<>();

        veiculosPesados.add(this);
    }


     // ======== SETS ========
     public void setIdVeiculoPesado(int idVeiculoPesado) {
        this.idVeiculoPesado = idVeiculoPesado;

    }
    public void setRestricao(String restricao) {
        this.restricao = restricao;

    }

    // ======== GETS ========
    public int getIdVeiculoPesado() {
        return this.idVeiculoPesado;

    }
    public String getRestricao() {
        return this.restricao;

    }

    // ====== EQUALS ====== 
    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof VeiculoPesado))
            return false;

        VeiculoPesado veiculoPesado = (VeiculoPesado) object;

        return idVeiculoPesado == veiculoPesado.idVeiculoPesado;
    }

    // ====== IMPRESSÃO ====== 
    @Override
    public String toString() {
        String print = seloDaEmpresa() + "\n\n\n" +
                    super.toString() + "\n" +
                    "=> Modelo Pesado =======>" + this.getModelo() + "\n" +
                    "   ====> Restrição: " + getRestricao() + "\n";
        return print;
    }

}