package LocaCarv1.models;

import java.util.ArrayList;
import java.util.Objects;
 
public class VeiculosLocados {
    private int idVeiculoLocado;
    private int idLocacao;
    private int idVeiculoLeve;
    private int idVeiculoPesado;
    Locacao locacao;
    VeiculoLeve veiculoLeve;
    VeiculoPesado veiculoPesado;
    // ArrayList<VeiculosLocados> locacoes = new ArrayList<>();;

    public static ArrayList<VeiculosLocados> veiculosLocados = new ArrayList<>();

    public VeiculosLocados() {
    }

    public VeiculosLocados(int idVeiculoLocado, int idVeiculoLeve, int idVeiculoPesado) {
        this.idVeiculoLocado = idVeiculoLocado;
        this.idVeiculoLeve = idVeiculoLeve;
        this.idVeiculoPesado = idVeiculoPesado;

        veiculosLocados.add(this);

    }

    // ======== SETS ========
    public void setIdVeiculoLocado(int idVeiculoLocado) {
        this.idVeiculoLocado = idVeiculoLocado;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;

    }

    public void setIdVeiculoLeve(int idVeiculoLeve) {
        this.idVeiculoLeve = idVeiculoLeve;

    }

    public void setIdVeiculoPesado(int idVeiculoPesado) {
        this.idVeiculoPesado = idVeiculoPesado;
    }

    // public void setLocacao(Locacao locacao) {
    //     this.locacao = locacao;
    // }

    // public void setVeiculoLeve(VeiculoLeve veiculoleve) {
    //     this.veiculoLeve = veiculoleve;
    // }

    // ======== GETS ========
    public int getIdVeiculoLocado() {
        return this.idVeiculoLeve;
    }

    // public Locacao getLocacao() {
    //     return this.locacao;
    // }

    // public VeiculoLeve getVeiculoLeve() {
    //     return this.veiculoLeve;
    // }

    public int getIdLocacao() {
        return this.idLocacao;
    }

    public int getIdVeiculoLeve() {
        return idVeiculoLeve;
    }

    public int getIdVeiculoPesado() {
        return this.idVeiculoPesado;

    }

    // ====== EQUALS ======
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof VeiculosLocados)) {
            return false;
        }
        VeiculosLocados veiculosLocados = (VeiculosLocados) o;

        return Objects.equals(idVeiculoLocado, veiculosLocados.idVeiculoLocado) && Objects.equals(idLocacao, veiculosLocados.idLocacao) && Objects.equals(idVeiculoLeve, veiculosLocados.idVeiculoLeve) && Objects.equals(idVeiculoPesado, veiculosLocados.idVeiculoPesado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVeiculoLocado, idLocacao, idVeiculoLeve, idVeiculoPesado);
    }

    // ====== IMPRESSÃO ======
    @Override
    public String toString() {
        String print =  
                        "Veiculos locados"  + "\n" +
                        super.toString() + "\n" +
                       "ID locacao: " + getIdLocacao() + "\n" +
                           "veiculo Leve: " + getIdVeiculoLeve();
                       

        return print;
    }

}
