package LocaCarv1.models;

import java.util.ArrayList;
import java.util.Objects;

import Libs.Teclado;
import LocaCarv1.DAO.VeiculoLeveDAO;
import LocaCarv1.views.Painel;

public class VeiculoLeve extends Veiculo implements BaseVeiculo {
    private int idVeiculoLeve;
    private String cor;
    Veiculo veiculo;
    ArrayList<VeiculosLocados> veiculosLocados;

    public static ArrayList<VeiculoLeve> veiculosLeves = new ArrayList<VeiculoLeve>();

    public VeiculoLeve() {
    }

    public VeiculoLeve(
        int idVeiculo, 
        int idVeiculoLeve,
        String cor,
        String marca,
        String modelo,
        int ano,
        double valorLocacao
        ) {
            super(idVeiculo, marca, modelo, ano, valorLocacao);
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

    public int getIdVeiculo() {
        return this.idVeiculo;
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

        return 
            Objects.equals(idVeiculo, this.idVeiculo) && 
            Objects.equals(idVeiculoLeve, this.idVeiculoLeve) && 
            Objects.equals(marca, this.marca) && 
            Objects.equals(modelo, this.modelo) && 
            Objects.equals(ano, this.ano) && 
            Objects.equals(valorLocacao, this.valorLocacao) && 
            Objects.equals(cor, this.cor
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVeiculo, idVeiculoLeve, marca, modelo, cor, valorLocacao);
    }

    // ====== IMPRESSÃO ======
    @Override
    public String toString() {
        String print = "\n\n" + seloDaEmpresa() + "\n\n"
                + "\n\n|---------------     Dados do Veículo        ---------------|" + "\n"
                + "  => Ano             :                        " + super.getAno() + "\n"
                + "  ==> Cor            :                        " + this.getCor() + "\n"
                + "  ===> Marca         :                        " + super.getMarca() + "\n"
                + "  ====> Modelo       :                        " + super.getModelo() + "\n"
                + "  =====> Valor Diária:                        " + super.getValorLocacao() + "\n"
                + "\n|-----------------------------------------------------------|\n";
        return print;
    }

    public static void cadastrarVeiculoLeve() throws Exception {
        boolean efetuarCadastro = true;
        while (efetuarCadastro) {
            VeiculoLeve dados = new VeiculoLeve();

            System.out.println("|------------------ URBANO ------------------|");

            System.out.print("Marca: ");
            dados.setMarca(Teclado.StringInput());
            System.out.print("Modelo: ");
            dados.setModelo(Teclado.StringInput());
            System.out.print("Ano: ");
            dados.setAno(Teclado.IntInput());
            System.out.print("Valor da Diária: ");
            dados.setValorLocacao(Teclado.DoubleInput());
            System.out.print("Cor: ");
            dados.setCor(Teclado.StringInput());

            VeiculoLeveDAO dao = new VeiculoLeveDAO();
            dao.salvarVeiculoLeve(dados);

            System.out.println("!!! -- Continuar Cadastrando (S/N) -- !!!");
            String continuarCadastro = Teclado.StringInput();

            if (continuarCadastro.equalsIgnoreCase("N")) {
                efetuarCadastro = false;
                new Painel();
            } else if (continuarCadastro.equalsIgnoreCase("s")) {

            } else {
                System.out.println("\n!!! -- SAIR -- !!! \n");
                efetuarCadastro = false;

            }
        }
    }

	@Override
	public void qtdLocacaoRealizada() {
        System.out.println(
            "--- Quantidade de Locações         :           " + Locacao.locacoes.size() + "\n" +
            "------- Valor Total das Locações   :           " + Locacao.valorTotalLocacao()
        );
    }
	
}