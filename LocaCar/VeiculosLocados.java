package LocaCar;

import java.util.ArrayList;
 
public class VeiculosLocados {
    protected int idLocacao;
    protected int idVeiculoLeve;
    protected int idVeiculoPesado;
    Locacao locacao;
    VeiculoLeve veiculoLeve;
    VeiculoPesado veiculoPesado;

    public static ArrayList<VeiculosLocados> veiculosLocados = new ArrayList<>();

    public VeiculosLocados(Locacao locacao, VeiculoLeve veiculoLeve, VeiculoPesado veiculoPesado) {
        this.idLocacao = locacao.idLocacao;
        this.idVeiculoLeve = veiculoLeve.idVeiculoLeve;
        this.idVeiculoPesado = veiculoPesado.idVeiculoPesado;
        this.locacao = locacao;
        this.veiculoLeve = veiculoLeve;
        this.veiculoPesado = veiculoPesado;

        veiculoPesado.VeiculosLocados.add(this);
        veiculoLeve.VeiculosLocados.add(this);
        locacao.veiculosLocados.add(this);
        veiculosLocados.add(this);
       
    }

    

    // ======== SETS ========
    // public void setIdLocacao(int idLocacao) {
    //     this.idLocacao = locacao.idLocacao;

    // }
    // public void setIdVeiculoLeve(int idVeiculoLeve) {
    //     this.idVeiculoLeve = veiculoLeve.idVeiculoLeve;

    // }
    // public void setIdveiculoPesado(int idVeiculoPesado) {
    //     this.idVeiculoPesado = veiculoPesado.idVeiculoPesado;

    // }
    public void setLocacao(Locacao locacao) {
        locacao.setLocacao(locacao);
    }
    public void setVeiculoLeve(VeiculoLeve veiculoLeve) {
        this.veiculoLeve = veiculoLeve;
    }
    public void setVeiculoPesado(VeiculoPesado veiculoPesado) {
        this.veiculoPesado = veiculoPesado;
    }

    // ======== GETS ========
    // public int getIdLocacao() {
    //     return this.idLocacao;

    // }
    // public int getIdVeiculoLeve() {
    //     return this.idVeiculoLeve;

    // }
    // public int getIdVeiculoPesado() {
    //     return this.idVeiculoPesado;

    // }
   public Locacao getLocacao() {
       return this.locacao;
   }
   public VeiculoLeve getVeiculoLeve() {
       return this.veiculoLeve;
   }
   public VeiculoPesado getVeiculoPesado() {
       return this.veiculoPesado;
   }
 
    // ====== EQUALS ====== 
    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof VeiculosLocados))
            return false;

        VeiculosLocados veiculosLocados = (VeiculosLocados) object;

        return idLocacao == veiculosLocados.idLocacao;
    }

    // ====== IMPRESSÃO ====== 
    @Override
    public String toString() {
        String print = "teste" ; 
        return print;
    }
    
}
