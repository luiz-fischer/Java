package LocaCarv1.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
 
public class VeiculosLocados {
    private int idVeiculoLocado;
    private int idLocacao;
    private int idVeiculoLeve;
    private int idVeiculoPesado;
    private int getInt;
    private String getString;
    Locacao locacao;
    VeiculoLeve veiculoLeve;
    VeiculoPesado veiculoPesado;
    private List<Cliente> cliente = new ArrayList<>();

    public static ArrayList<VeiculosLocados> veiculosLocados = new ArrayList<>();


    public VeiculosLocados() {
    }

    public VeiculosLocados(int idLocacao, int idVeiculoLocado, int idVeiculoLeve, int idVeiculoPesado) {
        this.idLocacao = idLocacao;
        this.idVeiculoLocado = idVeiculoLocado;
        this.idVeiculoLeve = idVeiculoLeve;
        this.idVeiculoPesado = idVeiculoPesado;

        veiculosLocados.add(this);

    }

    public VeiculosLocados(VeiculosLocados veiculosLocados2, VeiculoLeve veiculoLeve2) {
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
    public String getString() {
        return this.getString;
    }
    public int getInt() {
        return this.getInt;
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
    public List<Cliente> getListaCliente() {
        return cliente;
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

        return
            Objects.equals(idVeiculoLocado, veiculosLocados.idVeiculoLocado) && 
            Objects.equals(idLocacao, veiculosLocados.idLocacao) && 
            Objects.equals(idVeiculoLeve, veiculosLocados.idVeiculoLeve) && 
            Objects.equals(idVeiculoPesado, veiculosLocados.idVeiculoPesado
        );
    }

    // ====== HASH ======
    @Override
    public int hashCode() {
        return Objects.hash(idLocacao, idVeiculoLocado, idVeiculoPesado, idVeiculoLeve);
    }


    // ====== IMPRESSÃO ======
    @Override
    public String toString() {
        String print =  
                       "\n|---------------     Dados do Cliente        ---------------|" + "\n\n" +
                       "I.D. da Locação         :               " + getIdLocacao() + "\n" +
                       "I.D. Veículo Leve       :               " + getIdVeiculoLeve() + "\n" +
                       "Valor Total da Locação  :               " + Locacao.valorTotalLocacao() + "\n" +
                       "\n|---------------------------------------------------------------|\n";
                       

        return print;
    }

	// public void addLocacao(Locacao locacao) {
    //     this.locacao.add(veiculosLocados);
	// }

	public void addVeiculoLeve(VeiculoLeve veiculosLeve) {
	}

	public void addVeiculoPesado(VeiculoPesado veiculosPesado) {
	}

    // public void addHeroi(Heroi heroi) {
    //     HeroiFilme heroiFilme = new HeroiFilme(this, heroi);
    //     heroi.filmes.add(heroiFilme);
    //     this.herois.add(heroiFilme); 
                        
    // }   




}
