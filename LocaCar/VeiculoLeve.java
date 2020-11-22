package LocaCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VeiculoLeve extends Veiculo implements BaseVeiculo {
    protected int idVeiculoLeve;
    protected String cor;
    ArrayList<VeiculosLocados> veiculosLocados;

    public static ArrayList<VeiculoLeve> veiculosLeves = new ArrayList<>();

    public VeiculoLeve() {
    }

    public VeiculoLeve(int idVeiculoLeve, String cor, String marca, String modelo, int ano, double valorLocacao) {
        super(marca, modelo, ano, valorLocacao);
        this.idVeiculoLeve = idVeiculoLeve;
        this.cor = cor;

        this.veiculosLocados = new ArrayList<>();
        

        veiculosLeves.add(this);
    }

    public static void pesquisar(int valorId) {
        // Scanner entrada = new Scanner(System.in);
        try {
            if (veiculosLeves.size() == 0) {
                System.out.println("Não há Veiculos Cadastrados!");
            } else {
                // int valorId = entrada.nextInt();
                valorId--; // pq ao invés de começar o for de zero, começamos de 1, mas guardamos no
                           // elemento 0 do array

                VeiculoLeve aux = veiculosLeves.get(valorId);
                System.out.println("Modelo e Cor:" + aux.getModelo() + "\n" + aux.getCor());
                System.out.print("\nI.D. Do Veiculo:" + aux.getIdVeiculoLeve());
            }
        } catch (Exception exception) {
            System.out.println(exception);

        } finally {
            // entrada.close();
        }
    }

    // ======== SETS ========
    public void setIdVeiculoLeve(int idVeiculoLeve) {
        this.idVeiculoLeve = idVeiculoLeve;

    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    public VeiculoLeve getVeiculo(int id) throws Exception {
        return veiculosLeves.get(id);
    }

    public void setVeiculosLocados(ArrayList<VeiculosLocados> veiculosLocados) {
        this.veiculosLocados = veiculosLocados;
    }


    // public void setVeiculoLeve(VeiculoLeve veiculoLeve) {
    // this.veiculoLeve = veiculoLeve;
    // }

    // ======== GETS ========
    public int getIdVeiculoLeve() {
        return this.idVeiculoLeve;

    }

    public String getCor() {
        return this.cor;

    }

  public ArrayList<VeiculosLocados> getVeiculosLocados() {
        return veiculosLocados;
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
        String print = seloDaEmpresa() + "\n\n\n" +
                    super.toString() + "\n" +
                    "=> Modelo Leve =======>" + "\n" +
                    "   ====> Cor: " + getCor() + "\n";
        return print;
    }


}