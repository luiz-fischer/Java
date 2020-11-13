package LocaCar;

import java.sql.Date;
import java.util.ArrayList;

public class Locacao {
    protected int idLocacao;
    protected int idCliente;
    protected Date dataDeLocacao;
    protected Date dataDeDevolucao;
    Cliente cliente;
    ArrayList<VeiculosLocados> veiculosLocados;

    public static ArrayList<Locacao> locacoes = new ArrayList<>();

    public Locacao(int idLocacao, int idCliente, Date dataDeLocacao, Date dataDeDevolucao, Cliente cliente) {
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
    public void setDataDeLocacao(Date dataDeLocacao) {
        this.dataDeLocacao = dataDeLocacao;

    }
    public void setDataDeDevolucao(Date dataDeDevolucao) {
        this.dataDeDevolucao = dataDeDevolucao;

    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
   

    // ======== GETS ========
    public int getIdLocacao() {
        return this.idLocacao;

    }
    public int getIdCliente() {
        return this.idCliente;

    }
    public Date getDataDeLocacao() {
        return this.dataDeLocacao;

    }
    public Date getDataDeDevolucao() {
        return this.dataDeDevolucao;

    }
    public Cliente getCliente() {
        return this.cliente;
    }
   

    // ====== MÉTODOS ======
    public void valorTotalLocacao() {

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
