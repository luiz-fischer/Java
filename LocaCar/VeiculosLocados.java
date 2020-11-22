package LocaCar;

import java.util.ArrayList;
import java.util.List;
 
public class VeiculosLocados  extends Locacao {
    protected int idVeiculoLocado;
    protected int idLocacao;
    protected int idVeiculoLeve;
    protected int idVeiculoPesado;
    Locacao locacao;
    VeiculoLeve veiculoLeve;
    VeiculoPesado veiculoPesado;

    public ArrayList<VeiculosLocados> veiculosLocados = new ArrayList<>();

    public VeiculosLocados() {
    }

    public VeiculosLocados(Locacao locacao) {
        this.idLocacao = locacao.getIdLocacao();
        this.locacao = locacao;

        this.veiculosLocados.add(this);

        veiculosLocados.add(this);
    }
 

    

    
    // ======== SETS ========
    // public void setIdLocacao(int idLocacao) {
    //     this.idLocacao = idLocacao;

    // }
    // public void setIdCliente(int idCliente) {
    //     this.idCliente = idCliente;
    // }

    // public void setIdVeiculoLeve(int idVeiculoLeve) {
    //     this.idVeiculoLeve = VeiculoLeve.idVeiculoLeve;

    // }

  
    
    public void setVeiculoLeve(VeiculoLeve veiculoLeve) {
        this.veiculoLeve = veiculoLeve;
        // veiculoLeve.setVeiculoLeve(idVeiculoLeve);
    }
    public void setIdveiculoPesado(int idVeiculoPesado) {
        this.idVeiculoPesado = veiculoPesado.idVeiculoPesado;

    }
   

    // ======== GETS ========
    public void addLocacao(Locacao locacao) {
        VeiculosLocados veiculosLocados = new VeiculosLocados(locacao);
        // locacao.veiculosLocados.add(veiculosLocados);
        // veiculoLeve.veiculosLocados.add(veiculosLocados);
        // VeiculoLeve.veiculosLeves.add(veiculosLocados);
        Locacao.locacoes.add(veiculosLocados);
    }   
    
 
    public int getIdLocacao() {
        return locacao.idLocacao;
    }
    public int getIdVeiculoLeve() {
        return this.idVeiculoLeve;
    }
    public int getIdVeiculoPesado() {
        return this.idVeiculoPesado;

    }

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
        String print =  
                        "Veiculos locados"  + "\n" +
                       "ID locacao: " + getIdLocacao() + "\n" +
                       "veiculo Leve: " + getIdVeiculoLeve();
                       

        return print;
    }

	public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
	}

}
