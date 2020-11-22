package LocaCar;

import java.util.ArrayList;
import java.util.List;

public class VeiculoPesado extends Veiculo implements BaseVeiculo {
    protected int idVeiculoPesado;
    protected String restricao;
    ArrayList<VeiculosLocados> veiculosLocados;

    public static List<VeiculoPesado> veiculosPesados = new ArrayList<>();

    public VeiculoPesado() {
    }

    public VeiculoPesado(int idVeiculoPesado, String restricao, String marca, String modelo, int ano, double valorLocacao) {
        super(marca, modelo, ano, valorLocacao);
        this.idVeiculoPesado = idVeiculoPesado;
        this.restricao = restricao;
        
        this.veiculosLocados = new ArrayList<>();

        veiculosPesados.add(this);
    }


     // ======== SETS ========
     public void setIdVeiculoPesado(int idVeiculoPesado) {
        this.idVeiculoPesado = idVeiculoPesado;

    }
    public void setRestricao(String restricao) {
        this.restricao = restricao;

    }
    public void setVeiculosLocados(ArrayList<VeiculosLocados> veiculosLocados) {
        this.veiculosLocados = veiculosLocados;
    }

    // ======== GETS ========
    public int getIdVeiculoPesado() {
        return this.idVeiculoPesado;

    }
    public String getRestricao() {
        return this.restricao;

    }

    public ArrayList<VeiculosLocados> getVeiculosLocados() {
        return veiculosLocados;
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

    @Override
    public Veiculo getVeiculo(int id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}