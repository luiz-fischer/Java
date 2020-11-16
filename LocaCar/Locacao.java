package LocaCar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Locacao {
    protected int idLocacao;
    protected int idCliente;
    protected String dataDeLocacao;
    protected String dataDeDevolucao;
    private Locacao locacao;
    Cliente cliente;
    ArrayList<VeiculosLocados> veiculosLocados;

    public static ArrayList<Locacao> locacoes = new ArrayList<>();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public Locacao(int idLocacao, int idCliente, String dataDeLocacao, String dataDeDevolucao, Cliente cliente) {

        this.idLocacao = idLocacao;
        this.idCliente = idCliente;
        this.dataDeLocacao = dataDeLocacao;

        try {
            // Date date = formatter.parse(dataDeLocacao);
            DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date date = (Date)formatter.parse(this.dataDeLocacao); 
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.dataDeDevolucao = dataDeDevolucao;
        try {
            // Date date = formatter.parse(dataDeDevolucao);
            DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date date = (Date)formatter.parse(this.dataDeDevolucao); 
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
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
            total += veiculosLocados.veiculoLeve.getValorLocacao();
            total += veiculosLocados.veiculoPesado.getValorLocacao();

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
        String print = "Data de Locação: " + getDataDeLocacao() + "\n" +
                    "Data de Devolução: " + getDataDeLocacao();
        return print;
    }
    
}
