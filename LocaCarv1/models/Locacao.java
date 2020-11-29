package LocaCarv1.models;

import java.util.ArrayList;
import java.util.Objects;

public class Locacao {
    private static int idLocacao;
    private static int idCliente;
    private static String dataDeDevolucao;
    private static String dataDeLocacao;
    private static Cliente cliente;
    VeiculoLeve veiculosLeve;

    private static ArrayList<VeiculosLocados> veiculosLocados = new ArrayList<>();

    public static ArrayList<Locacao> locacoes = new ArrayList<>();

    public Locacao() {
    }

    public Locacao(int idLocacao, int idCliente, String dataDeLocacao, String dataDeDevolucao) {
        Locacao.idLocacao = idLocacao;
        Locacao.idCliente = idCliente;
        Locacao.dataDeLocacao = dataDeLocacao;
        Locacao.dataDeDevolucao = dataDeDevolucao;

        locacoes.add(this);
    }

    // ======== SETS ========
    public void setIdLocacao(int idLocacao) {
        Locacao.idLocacao = idLocacao;

    }

    public void setCliente(Cliente cliente) {
        Locacao.cliente = cliente;
    }

    public void setIdCliente(int idCliente) {
        Locacao.idCliente = idCliente;

    }

    // public void setVeiculosLocados(ArrayList<VeiculosLocados> veiculosLocados) {
    // Locacao.veiculosLocados = veiculosLocados;
    // }

    // public void setDataDeLocacao(String dataDeLocacao) {
    //     Locacao.dataDeLocacao = dataDeLocacao;

    // }

    // public void setDataDeDevolucao(String dataDeDevolucao) {
    //     Locacao.dataDeDevolucao = dataDeDevolucao;

    // }

    // ======== GETS ========
    public static int getIdLocacao() {
        return Locacao.idLocacao;

    }

    // public ArrayList<VeiculoLeve> getVeiculoLeve() {
    // return Locacao.veiculosLeves;
    // }
    // public ArrayList<VeiculosLocados> getVeiculosLocados() {
    // return Locacao.veiculosLocados;
    // }

    public static int getIdCliente() {
        return idCliente;

    }

    // public static String getDataDeLocacao() {
    //     return Locacao.dataDeLocacao;

    // }

    // public static String getDataDeDevolucao() {
    //     return Locacao.dataDeDevolucao;

    // }

    public Cliente getCliente() {
        return Locacao.cliente;
    }

    // ====== MÉTODOS ======
    public int qtdVeiculosLocados() {
        return locacoes.size();
    }

    public int qtdDiasLocados() {
        int diasLocados = libs.Data.diffDays(getDataDeLocacao(), getDataDeDevolucao());
        return diasLocados;
    }

    public double valorTotalLocacao() {
        double total = 0;
        for (VeiculosLocados veiculosLocados : veiculosLocados) {
            total += veiculosLeve.getValorLocacao()
                    + veiculosLeve.getValorLocacao();

        }
        return total;
    }

    // ====== HASH ======
    @Override
    public int hashCode() {
        return Objects.hash(idCliente, idLocacao);
    }

    // ====== EQUALS ======
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Locacao)) {
            return false;
        }
        Locacao locacao = (Locacao) o;

        return Objects.equals(idCliente, Locacao.idCliente) && Objects.equals(idLocacao, Locacao.idLocacao)
                && Objects.equals(dataDeLocacao, Locacao.dataDeLocacao)
                && Objects.equals(dataDeLocacao, Locacao.dataDeLocacao);
    }

    // ====== IMPRESSÃO ======
    @Override
    public String toString() {
        String print = "";
            print = "           |--------Lista de Alugueis--------|" + "\n"
                    + "I.D. Locacao      :                       " + getIdLocacao() + "\n"
                    + "I.D. Cliente      :                       " + getIdCliente() + "\n"
                    + "Data de Locação   :                       " + getDataDeLocacao() + "\n"
                    + "Data de Devolução :                       " + getDataDeDevolucao() + "\n"
                    + "Total de dias     :                       " + qtdDiasLocados() + "\n"
                    + "\n|-----------------------------------------------------------|\n";
      
            return print;
    }

	public void setDataDeDevolucao(String dataDeDevolucao) {
        Locacao.dataDeDevolucao = dataDeDevolucao;
	}

	public void setDataDeLocacao(String dataDeLocacao) {
        Locacao.dataDeLocacao = dataDeLocacao;
    }
    
    public static String getDataDeLocacao() {
        return Locacao.dataDeLocacao;

    }

    public static String getDataDeDevolucao() {
        return Locacao.dataDeDevolucao;

    }


}
