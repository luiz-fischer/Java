package LocaCarv1.models;

import java.util.ArrayList;

public class VeiculoPesado extends Veiculo implements BaseVeiculo {
    protected int idVeiculoPesado;
    protected String restricao;
    ArrayList<VeiculosLocados> veiculosLocados;
    Veiculo veiculo;

    public ArrayList<VeiculoPesado> veiculosPesados = new ArrayList<>();

    public VeiculoPesado() {

    }

    public VeiculoPesado(int idVeiculoPesado,int idVeiculo, String marca, String modelo, int ano,
            double valorLocacao, String restricao) {
        super(idVeiculo, marca, modelo, ano, valorLocacao);
        this.idVeiculoPesado = idVeiculoPesado;
        this.restricao = restricao;

        this.veiculosLocados = new ArrayList<>();

        veiculosPesados.add(this);
    }

    // ======== SETS ========
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

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

        return idVeiculoPesado == this.idVeiculoPesado;
    }

    // ====== IMPRESSÃO ====== 
    @Override
    public String toString() {
        String print = "\n\n" + seloDaEmpresa() + "\n\n" +
        "\n\n|---------------     Dados do Veículo        ---------------|" + "\n" + 
        "  => Ano             :                        " + super.getAno() + "\n" +
        "  ===> Marca         :                        " + super.getMarca() + "\n" +
        "  ====> Modelo       :                        " + super.getModelo() + "\n" +
        "  =====> Restrição   :                        " + this.getRestricao() + "\n" +
        "  =====> Valor Diária:                        " + super.getValorLocacao() + "\n" +
        "\n|-----------------------------------------------------------|\n";
        return print;
    }

    @Override
    public int qtdLocacaoRealizada() {
        // TODO Auto-generated method stub
        return 0;
    }




}