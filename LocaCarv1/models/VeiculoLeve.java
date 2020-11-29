package LocaCarv1.models;

import java.util.ArrayList;
import java.util.Objects;

public class VeiculoLeve extends Veiculo implements BaseVeiculo {
    private int idVeiculoLeve;
    private String cor;
    Veiculo veiculo;
    ArrayList<VeiculosLocados> veiculosLocados;

    public ArrayList<VeiculoLeve> veiculosLeves = new ArrayList<VeiculoLeve>();

    public VeiculoLeve() {
    }

    public VeiculoLeve(int idVeiculo, int idVeiculoLeve, String cor, String marca, String modelo, int ano, double valorLocacao) {
        super(idVeiculo, marca, modelo, ano, valorLocacao);
        this.idVeiculoLeve = idVeiculoLeve;
        this.cor = cor;

        this.veiculosLocados = new ArrayList<>();

        veiculosLeves.add(this);
    }

   

    // ======== SETS ========
    public void setIdVeiculoLeve(int idVeiculoLeve) {
        this.idVeiculoLeve = idVeiculoLeve;

    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setVeiculosLocados(ArrayList<VeiculosLocados> veiculosLocados) {
        this.veiculosLocados = veiculosLocados;
    }

    // ======== GETS ========
    public int getIdVeiculoLeve() {
        return this.idVeiculoLeve;

    }
    // public int getIdVeiculo() {
    //     return getIdVeiculo();
    //    }
    public double getValorLocacao() {
        return this.valorLocacao;

    }
    public String getCor() {
        return this.cor;

    }
    public ArrayList<VeiculosLocados> getVeiculosLocados() {
        return this.veiculosLocados;
    }
    

    // ====== EQUALS ======
    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof VeiculoLeve))
            return false;

        VeiculoLeve veiculoLeve = (VeiculoLeve) object;

        return Objects.equals(idVeiculoLeve, this.idVeiculoLeve) && Objects.equals(marca, this.marca)&& Objects.equals(modelo, this.modelo)&& Objects.equals(cor, this.cor);
    }


    @Override
    public int hashCode() {
        return Objects.hash(idVeiculo, idVeiculoLeve, marca, modelo, cor);
    }

    // ====== IMPRESSÃO ====== 
    @Override
    public String toString() {
        String print = "\n\n" + seloDaEmpresa() + "\n\n" +
                       "\n\n|---------------     Dados do Veículo        ---------------|" + "\n" + 
                       "  => Ano             :                        " + super.getAno() + "\n" +
                       "  ==> Cor            :                        " + this.getCor() + "\n" +
                       "  ===> Marca         :                        " + super.getMarca() + "\n" +
                       "  ====> Modelo       :                        " + super.getModelo() + "\n" +
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