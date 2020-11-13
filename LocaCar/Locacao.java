package LocaCar;

import java.util.ArrayList;

public class Locacao {
    protected int idLocacao;
    protected int idCliente;
    protected int dataDeLocacao;
    protected int dataDeDevolucao;
    private Locacao locacao;
    Cliente cliente;
    ArrayList<VeiculosLocados> veiculosLocados;

    public static ArrayList<Locacao> locacoes = new ArrayList<>();

    public Locacao(int idLocacao, int idCliente, int dataDeLocacao, int dataDeDevolucao, Cliente cliente) {
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
    public void setDataDeLocacao(int dataDeLocacao) {
        this.dataDeLocacao = dataDeLocacao;

    }
    public void setDataDeDevolucao(int dataDeDevolucao) {
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
    public int getDataDeLocacao() {
        return this.dataDeLocacao;

    }
    public int getDataDeDevolucao() {
        return this.dataDeDevolucao;

    }
    public Cliente getCliente() {
        return this.cliente;
    }
   

    // ====== MÉTODOS ======
    public double valorTotalLocacao() {
        double total = 0;
        for (VeiculosLocados veiculosLocados : veiculosLocados) {
            total += veiculosLocados.veiculoLeve.getValorLocacao();
            total += veiculosLocados.veiculoPesado.getValorLocacao();

        }
        return total;
    }
    public void imprimirValorTotal() {
        System.out.println("Valor Total das Locações: " + valorTotalLocacao());
    }
    public void qtdVeiculosLocados() {

    }
    public void dataDeDevolucao() {

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
        String print = "teste" ;
        return print;
    }
    
}
