package LocaCar;

import java.util.ArrayList;
import java.util.Objects;


public class VeiculoLeve extends Veiculo implements BaseVeiculo {
    protected int idVeiculoLeve;
    protected String cor;
    ArrayList<VeiculosLocados> veiculosLocados;

    public static ArrayList<VeiculoLeve> veiculosLeves = new ArrayList<VeiculoLeve>();

    public VeiculoLeve() {
    }

    public VeiculoLeve(int idVeiculoLeve, String cor, String marca, String modelo, int ano, double valorLocacao) {
        super(marca, modelo, ano, valorLocacao);
        this.idVeiculoLeve = idVeiculoLeve;
        this.cor = cor;

        this.veiculosLocados = new ArrayList<>();

        veiculosLeves.add(this);
    }

   

    // ======== SETS ========
    public void setIdVeiculoLeve(int idVeiculoLeve) {
        this.idVeiculoLeve = idVeiculoLeve;

    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setVeiculosLocados(ArrayList<VeiculosLocados> veiculosLocados) {
        this.veiculosLocados = veiculosLocados;
    }

    // ======== GETS ========
    public int getIdVeiculoLeve() {
        return this.idVeiculoLeve;

    }
    public double getValorLocacao() {
        return this.valorLocacao;

    }
    public String getCor() {
        return this.cor;

    }
    public ArrayList<VeiculosLocados> getVeiculosLocados() {
        return this.veiculosLocados;
    }

    // ====== EQUALS ======
    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof VeiculoLeve))
            return false;

        VeiculoLeve veiculoLeve = (VeiculoLeve) object;

        return idVeiculoLeve == veiculoLeve.idVeiculoLeve;
    }


    @Override
    public int hashCode() {
        return Objects.hash(idVeiculoLeve, cor);
    }

    // ====== IMPRESSÃO ====== 
    @Override
    public String toString() {
        String print = seloDaEmpresa() + 
                       "\n\n\n"         + super.toString() + "\n" +
                       "   ====> Cor: " + getCor() + "\n";
        return print;
    }

    public VeiculoLeve getVeiculo(int id) throws Exception {
        return veiculosLeves.get(id);
     }

     @Override
     public int qtdLocacaoRealizada() {
         // TODO Auto-generated method stub
         return 0;
     }

     @Override
     public double valorLocacao() {
         double total = 0.0;
         total = getValorLocacao();
         return 0;
     }

   
    public static String pesquisar(int valorId) {
        try {
            if (veiculosLeves.size() == 0) {
                System.out.println("Não há Veiculos Cadastrados!");
            } else {
                valorId--; // pq ao invés de começar o for de zero, começamos de 1, mas guardamos no
                           // elemento 0 do array
            }
        } catch (Exception exception) {
            System.out.println("ERRO: " + exception.getMessage());

        } return "=> Valor Total:           "   + veiculosLeves.get(valorId).getValorLocacao()        * Locacao.locacoes.get(valorId).qtdDiasLocados() + "\n" +
                 " ==> Marca:               "   + veiculosLeves.get(valorId).getMarca() + "\n" +
                 "   ====> Modelo:          "   + veiculosLeves.get(valorId).getModelo() + "\n" +
                 "     ====> Cor:           "   + veiculosLeves.get(valorId).getCor() + "\n";
        
    }

}