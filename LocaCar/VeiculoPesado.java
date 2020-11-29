package LocaCar;

import java.util.ArrayList;

public class VeiculoPesado extends Veiculo implements BaseVeiculo {
    protected int idVeiculoPesado;
    protected String restricao;
    ArrayList<VeiculosLocados> veiculosLocados;

    public static ArrayList<VeiculoPesado> veiculosPesados = new ArrayList<>();

    public VeiculoPesado() {
    }

    public VeiculoPesado(int idVeiculoPesado, String restricao, String marca, String modelo, int ano, double valorLocacao) {
        super(marca, modelo, ano, valorLocacao);
        this.idVeiculoPesado = idVeiculoPesado;
        this.restricao = restricao;
        
        this.veiculosLocados = new ArrayList<>();

        veiculosPesados.add(this);
    }


     // ======== SETS ========
     public void setIdVeiculoPesado(int idVeiculoPesado) {
        this.idVeiculoPesado = idVeiculoPesado;

    }
    public void setRestricao(String restricao) {
        this.restricao = restricao;

    }
    public void setVeiculosLocados(ArrayList<VeiculosLocados> veiculosLocados) {
        this.veiculosLocados = veiculosLocados;
    }

    // ======== GETS ========
    public int getIdVeiculoPesado() {
        return this.idVeiculoPesado;

    }
    public String getRestricao() {
        return this.restricao;

    }

    public ArrayList<VeiculosLocados> getVeiculosLocados() {
        return veiculosLocados;
    }

    // ====== EQUALS ====== 
    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof VeiculoPesado))
            return false;

        VeiculoPesado veiculoPesado = (VeiculoPesado) object;

        return idVeiculoPesado == veiculoPesado.idVeiculoPesado;
    }

    // ====== IMPRESSÃO ====== 
    @Override
    public String toString() {
        String print = seloDaEmpresa() + "\n\n\n" +
                    super.toString() + "\n" +
                    "=> Modelo Pesado =======>" + this.getModelo() + "\n" +
                    "   ====> Restrição: " + getRestricao() + "\n";
        return print;
    }




    @Override
    public int qtdLocacaoRealizada() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Veiculo getVeiculo(int id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    public static String pesquisar(int valorId) {
        try {
            if (veiculosPesados.size() == 0) {
                System.out.println("Não há Veiculos Cadastrados!");
            } else {
                valorId--; // pq ao invés de começar o for de zero, começamos de 1, mas guardamos no
                           // elemento 0 do array
            }
        } catch (Exception exception) {
            System.out.println("ERRO: " + exception.getMessage());

        } return "=> Valor Total  :         "   + veiculosPesados.get(valorId).getValorLocacao()        * Locacao.locacoes.get(valorId).qtdDiasLocados() + "\n" +
                 " ==> Marca:               "   + veiculosPesados.get(valorId).getMarca() + "\n" +
                 "   ====> Modelo:          "   + veiculosPesados.get(valorId).getModelo() + "\n" +
                 "     ====> Restrição:     "   + veiculosPesados.get(valorId).getRestricao() + "\n";
        
    }

}