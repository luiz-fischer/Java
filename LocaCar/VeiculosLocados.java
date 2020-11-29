package LocaCar;

import java.util.ArrayList;
 
public class VeiculosLocados {
    protected int idVeiculoLocado;
    protected int idLocacao;
    protected int idVeiculoLeve;
    protected int idVeiculoPesado;
    Locacao locacao;
    VeiculoLeve veiculoLeve;
    VeiculoPesado veiculoPesado;
    ArrayList<VeiculosLocados> locacoes;
    

    public static ArrayList<VeiculosLocados> veiculosLocados = new ArrayList<>();

    public VeiculosLocados() {
    }

    // public VeiculosLocados(int idVeiculoLocado, Locacao locacao, VeiculoLeve veiculoLeve) {
    //     this.idLocacao = locacao.idLocacao;
    //     this.idVeiculoLeve = veiculoLeve.idVeiculoLeve;
    //     this.idVeiculoLocado = idVeiculoLocado;
    //     this.locacao = locacao;
    //     this.locacoes = new ArrayList<>();

    //     // locacao.veiculosLocados.add(this);
    //     // veiculoLeve.veiculosLocados.add(this);
    //     locacoes.add(this);

    //     veiculosLocados.add(this);

    // }

    public VeiculosLocados(int idVeiculoLocado, int idLocacao, int idVeiculoLeve) {
        this.idVeiculoLocado = idVeiculoLocado;
        this.idVeiculoLeve = veiculoLeve.idVeiculoLeve;
        this.idLocacao = idLocacao;
        this.idVeiculoLeve = idVeiculoLeve;
        this.locacoes = new ArrayList<>();

        locacoes.add(this);
        veiculosLocados.add(this);
    }


    // public VeiculosLocados(int idVeiculoLocado, int idLocacao, int idVeiculoLeve, int idVeiculoPesado) {
    //     this.idVeiculoLocado = idVeiculoLocado;
    //     this.idLocacao = idLocacao;
    //     this.idVeiculoLeve = idVeiculoLeve;
    //     this.idVeiculoPesado = idVeiculoPesado;

    //     locacao.veiculosLocados.add(this);
    //     veiculosLocados.add(this);
    // }

    
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
    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }
    // public void setVeiculoLeve(VeiculoLeve veiculoleve) {
    //     this.veiculoLeve = veiculoleve;
    // }
   

    // ======== GETS ========
    public int getIdVeiculoLocado() {
        return this.idVeiculoLeve;
    }
    public Locacao getLocacao() {
        return this.locacao;
    }
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
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof VeiculosLocados))
            return false;

        VeiculosLocados veiculosLocados = (VeiculosLocados) object;

        return idLocacao == veiculosLocados.idLocacao;
    }
   

    @Override
	public int hashCode() {
	    return (int) idVeiculoLocado * 7;
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
