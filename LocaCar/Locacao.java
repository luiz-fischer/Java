package LocaCar;

import java.util.ArrayList;
import java.util.Objects;

public class Locacao {
    protected int idLocacao;
    protected int idCliente;
    protected String dataDeLocacao;
    protected String dataDeDevolucao;
    protected int idVeiculoLeve;
    Cliente cliente;
    VeiculoLeve veiculoLeve;
    ArrayList<Cliente> clientes;
    ArrayList<VeiculosLocados> veiculosLocados;
    ArrayList<VeiculoLeve> veiculosLeves;

    public static ArrayList<Locacao> locacoes = new ArrayList<>();

   
    public Locacao() {

    }

    public Locacao(int idLocacao, int idCliente, String dataDeLocacao, String dataDeDevolucao) {
        this.idVeiculoLeve = veiculoLeve.idVeiculoLeve;
        this.idLocacao = idLocacao;
        this.idCliente = idCliente;
        this.dataDeLocacao = dataDeLocacao;
        this.dataDeDevolucao = dataDeDevolucao;

        this.veiculosLocados = new ArrayList<>();

        locacoes.add(this);
    }

    public Locacao(int idLocacao) {
        this.idLocacao = idLocacao;
        this.veiculosLocados = new ArrayList<>();

    }
    

    // ======== SETS ========
    public void setIdVeiculoLeve(int idVeiculoLeve) {
        this.idVeiculoLeve = idVeiculoLeve;
    }
    public int getIdVeiculoLeve() {
        return idVeiculoLeve;
    }


    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;

    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;

    }

    public void setVeiculosLocados(ArrayList<VeiculosLocados> veiculosLocados) {
        this.veiculosLocados = veiculosLocados;
    }

    public void setDataDeLocacao(String dataDeLocacao) {
        this.dataDeLocacao = dataDeLocacao;

    }

    public void setDataDeDevolucao(String dataDeDevolucao) {
        this.dataDeDevolucao = dataDeDevolucao;

    }
 

    // ======== GETS ========
    public int getIdLocacao() {
        return this.idLocacao;

    }
    public ArrayList<VeiculoLeve> getVeiculoLeve() {
        return this.veiculosLeves;
    }
    public ArrayList<VeiculosLocados> getVeiculosLocados() {
        return this.veiculosLocados;
    }

    public int getIdCliente() {
        return idCliente;

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
    public int qtdVeiculosLocados() {
        return locacoes.size();
    }

    public int qtdDiasLocados() {
        int diasLocados = Data.diffDays(getDataDeLocacao(), getDataDeDevolucao());
        return diasLocados;
    }

    public double valorTotalLocacao() {
        double total = 0;
        for (VeiculosLocados veiculosLocados : veiculosLocados) {
            total += ((VeiculoLeve) veiculosLocados.veiculoLeve).getValorLocacao()
                    + veiculosLocados.veiculoPesado.getValorLocacao();

        }
        return total;
    }

    //====== HASH ======
    @Override
    public int hashCode() {
        return Objects.hash(idLocacao, idCliente);
    }

    // ====== EQUALS ======
    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof Locacao))
            return false;

            Locacao locacao = (Locacao) object;

        return idLocacao == this.idLocacao;
    }

    // ====== IMPRESSÃO ======
    @Override
    public String toString() {
        String print =
                "           |--------Lista de Carros Alugados--------|" + "\n" +
                // "I.D. Locacao:             "         + getIdLocacao() + "\n" +
                // "I.D. Cliente:             "         + getIdCliente() + "\n" +
                // // "Nome do Cliente:          "         + clientes.get(idCliente).getNome() +"\n"+
                // "Data de Locação:          "         + getDataDeLocacao() + "\n" + 
                // "Data de Devolução:        "         + getDataDeDevolucao() + "\n" +
                // "Total de dias:            "         + qtdDiasLocados() + "\n" +
                // VeiculoLeve.pesquisar(Integer.valueOf(idVeiculoLeve));
                // Cliente.pesquisar(Integer.valueOf(idCliente));
                "\n|-----------------------------------------------------------|\n";
            return print;
    }


}
