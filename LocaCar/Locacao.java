package LocaCar;

import java.util.ArrayList;
import java.util.List;

public class Locacao {
    protected int idLocacao;
    protected static int idCliente;
    protected static String dataDeLocacao;
    protected static String dataDeDevolucao;
    static Cliente cliente;
    ArrayList<Locacao> veiculosLocados;

    public static ArrayList<Locacao> locacoes = new ArrayList<>();

    public Locacao() {

    }

    protected Locacao(int idLocacao, int idCliente, String dataDeLocacao, String dataDeDevolucao) {

        this.idLocacao = idLocacao;
        Locacao.idCliente = idCliente;
        Locacao.dataDeLocacao = dataDeLocacao;
        Locacao.dataDeDevolucao = dataDeDevolucao;

        this.veiculosLocados = new ArrayList<>();

        cliente.locacoes.add(this);

        locacoes.add(this);
    }

    // ======== SETS ========
    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;

    }

    public void setCliente(Cliente cliente) {
        Locacao.cliente = cliente;
    }

    public void setIdCliente(int idCliente) {
        Locacao.idCliente = idCliente;

    }

    public void setVeiculosLocados(ArrayList<Locacao> veiculosLocados) {
        this.veiculosLocados = veiculosLocados;
    }

    public void setDataDeLocacao(String dataDeLocacao) {
        Locacao.dataDeLocacao = dataDeLocacao;

    }

    public void setDataDeDevolucao(String dataDeDevolucao) {
        Locacao.dataDeDevolucao = dataDeDevolucao;

    }

    // ======== GETS ========
    public int getIdLocacao() {
        return this.idLocacao;

    }

    public ArrayList<Locacao> getVeiculosLocados() {
        return veiculosLocados;
    }

    public int getIdCliente() {
        return Locacao.idCliente;

    }

    public String getDataDeLocacao() {
        return Locacao.dataDeLocacao;

    }

    public String getDataDeDevolucao() {
        return Locacao.dataDeDevolucao;

    }

    public static Cliente getCliente() {
        return Locacao.cliente;
    }

    // ====== MÉTODOS ======
    public static double valorTotalLocacao() {
        double total = 0.0;
        total = qtdDiasLocados() * Veiculo.valorLocacao;
        
        return total;
    }

    public void imprimirValorTotal() {
        System.out.println("Valor Total das Locações: " + valorTotalLocacao());
    }

    public void qtdVeiculosLocados() {
        System.out.println("Veiculos Locados: " + locacoes.size());
    }

    public static int qtdDiasLocados() {
        int diasLocados = Data.diffDays(Locacao.dataDeLocacao, Locacao.dataDeDevolucao);
        return diasLocados;
    }

    // ====== EQUALS ======
    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof Locacao))
            return false;

        Locacao locacao = (Locacao) object;

        return idLocacao == locacao.idLocacao;
    }

    // ====== IMPRESSÃO ======
    @Override
    public String toString() {
        String print = "Classe Locacao" + "\n" +
                       "Data de Locação: " + getDataDeLocacao() + "\n" + 
                        "Data de Devolução: " + getDataDeDevolucao() + "\n" +
                         "Total de dias: " + qtdDiasLocados()
                + "\n" + "Valor Total da Locação: " + valorTotalLocacao();
        return print;
    }

}
