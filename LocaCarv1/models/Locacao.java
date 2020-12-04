package LocaCarv1.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Locacao {
    private int idLocacao;
    private int idCliente;
    private static String dataDeDevolucao;
    private static String dataDeLocacao;
    private Cliente cliente;
    VeiculoLeve veiculosLeve;
    VeiculoPesado veiculosPesado;
    public ArrayList<VeiculosLocados> veiculosLocados;

    public static ArrayList<Locacao> locacoes = new ArrayList<>();

    public Locacao() {
    }

    public Locacao(int idLocacao, int idCliente, String dataDeDevolucao

    ) {
        this.idLocacao = idLocacao;
        this.idCliente = idCliente;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formato.format(new Date());
        Locacao.dataDeLocacao = dataFormatada;
        Locacao.dataDeDevolucao = dataDeDevolucao;
        // this.cliente = cliente;

        locacoes.add(this);
    }

    // ======== SETS ========


    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;

    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;

    }

    public void setDataDeDevolucao(String dataDeDevolucao) {
        Locacao.dataDeDevolucao = dataDeDevolucao;
    }

    public void setDataDeLocacao(String dataDeLocacao) {
        Locacao.dataDeLocacao = dataDeLocacao;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVeiculosLocados(ArrayList<VeiculosLocados> veiculosLocados) {
        this.veiculosLocados = veiculosLocados;
    }

    // ======== GETS ========
    public int getIdLocacao() {
        return this.idLocacao;
    }

    public int getIdCliente() {
        return this.idCliente;
    }

    public static String getDataDeLocacao() {
        return Locacao.dataDeLocacao;
    }

    public static String getDataDeDevolucao() {
        return Locacao.dataDeDevolucao;

    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public static int totalDeDiasLocados() {
        int data = Libs.Data.diffDays(getDataDeLocacao(), getDataDeDevolucao());
        return data;
    }

    // public ArrayList<VeiculoLeve> getVeiculoLeve() {
    // return this.veiculosLeves;
    // }
    // public ArrayList<VeiculosLocados> getVeiculosLocados() {
    // return this.veiculosLocados;
    // }

    // ====== HASH ======
    @Override
    public int hashCode() {
        return Objects.hash(idCliente, idLocacao, dataDeLocacao, dataDeDevolucao);
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

        return Objects.equals(
            idCliente, this.idCliente) && 
            Objects.equals(idLocacao, this.idLocacao) && 
            Objects.equals(dataDeLocacao, Locacao.dataDeLocacao) && 
            Objects.equals(dataDeLocacao, Locacao.dataDeLocacao)
        ;
    }

    // ====== IMPRESSÃO ======
    @Override
    public String toString() {
        String print =  "           |--------Lista de Alugueis--------|" + "\n"
                        + "I.D. Locacao             :          " + getIdLocacao() + "\n"
                        + "I.D. Cliente             :          " + getIdCliente() + "\n"
                        + "Data de Locação          :          " + getDataDeLocacao() + "\n"
                        + "Data de Devolução        :          " + getDataDeDevolucao() + "\n"
                        + "Total de dias            :          " + totalDeDiasLocados() + "\n"
                        + "Valor Total das Locações :          " + valorTotalLocacao() + "\n"
                        + "\n|-----------------------------------------------------------|\n";
      
        return print;
    }

    // ====== MÉTODOS ======
    public int qtdVeiculosLocados() {
        return locacoes.size();
    }

    public static double valorTotalLocacao() {
        double total = 0;
        for (VeiculoLeve veiculoLeve : VeiculoLeve.veiculosLeves) {
            
                total += (veiculoLeve.getValorLocacao() * totalDeDiasLocados());
        }
        return total;
    }

    public Date setPlusDay(int x) {
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, x);
        dt = c.getTime();
        return dt;
    }

}
