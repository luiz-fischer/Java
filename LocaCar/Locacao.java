package LocaCar;

import java.util.ArrayList;
import java.util.List;

public class Locacao {
    protected int idLocacao;
    protected int idCliente;
    protected String dataDeLocacao;
    protected String dataDeDevolucao;
    private Locacao locacao;
    Cliente cliente;
    ArrayList<VeiculosLocados> veiculosLocados;

    public static List<Locacao> locacoes = new ArrayList<>();

    public Locacao(int idLocacao, int idCliente, String dataDeLocacao, String dataDeDevolucao, Cliente cliente) {

        this.idLocacao = idLocacao;
        this.idCliente = idCliente;
        this.dataDeLocacao = dataDeLocacao;
        this.dataDeDevolucao = dataDeDevolucao;
        
        this.veiculosLocados = new ArrayList<>();

        cliente.locacoes.add(this);
        locacoes.add(this);
    }

    // ======== SETS ========
    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;

    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;

    }
    public void setDataDeLocacao(String dataDeLocacao) {
        this.dataDeLocacao = dataDeLocacao;

    }
    public void setDataDeDevolucao(String dataDeDevolucao) {
        this.dataDeDevolucao = dataDeDevolucao;

    }
    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }   

    // ======== GETS ========
    public int getIdLocacao() {
        return this.idLocacao;

    }
    public int getIdCliente() {
        return this.idCliente;

    }
    public String getDataDeLocacao() {
        return this.dataDeLocacao;

    }
    public String getDataDeDevolucao() {
        return this.dataDeDevolucao;

    }
    public Cliente getCliente() {
        return this.cliente;
    }
   

    // ====== MÉTODOS ======
    public double valorTotalLocacao() {
        double total = 0;
        for (VeiculosLocados veiculosLocados : veiculosLocados) {
            total += veiculosLocados.veiculoLeve.getValorLocacao() + veiculosLocados.veiculoPesado.getValorLocacao();

        }
        return total;
    }
    public void imprimirValorTotal() {
        System.out.println("Valor Total das Locações: " + valorTotalLocacao());
    }
    public void qtdVeiculosLocados() {
        System.out.println("Quantidade de Veículos Locados no momento: " + veiculosLocados.size());
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
        int diasLocados = Data.diffDays(this.dataDeLocacao, this.dataDeDevolucao);
        String print = "Data de Locação: " + getDataDeLocacao() + "\n" +
                       "Data de Devolução: " + getDataDeDevolucao() + "\n" +
                       "Total de dias: " + diasLocados + "\n";
        return print;
    }
    
}
