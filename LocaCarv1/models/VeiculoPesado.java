package LocaCarv1.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import LocaCarv1.DAO.VeiculoPesadoDAO;
import LocaCarv1.views.Painel;
import Libs.Teclado;

public class VeiculoPesado extends Veiculo implements BaseVeiculo {
    protected int idVeiculoPesado;
    protected String restricao;
    ArrayList<VeiculosLocados> veiculosLocados;
    Veiculo veiculo;

    public ArrayList<VeiculoPesado> veiculosPesados = new ArrayList<>();

    public VeiculoPesado() {
    }

    public VeiculoPesado(
        int idVeiculoPesado,
        int idVeiculo, 
        String marca, 
        String modelo, 
        int ano, 
        double valorLocacao,
        String restricao
        ) {
            super(idVeiculo, marca, modelo, ano, valorLocacao);
            this.idVeiculoPesado = idVeiculoPesado;
            this.restricao = restricao;

            this.veiculosLocados = new ArrayList<>();

            veiculosPesados.add(this);
    }

    // ======== SETS ========
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

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
        if (!(object instanceof VeiculoLeve))
            return false;

        VeiculoLeve veiculoLeve = (VeiculoLeve) object;

        return 
            Objects.equals(idVeiculo, this.idVeiculo) && 
            Objects.equals(idVeiculoPesado, this.idVeiculoPesado) && 
            Objects.equals(marca, this.marca) && 
            Objects.equals(modelo, this.modelo) && 
            Objects.equals(restricao, this.restricao) &&
            Objects.equals(valorLocacao, this.valorLocacao) &&
            Objects.equals(ano, this.ano
        );
    }

    // ====== HASH ======
    @Override
    public int hashCode() {
        return Objects.hash(idVeiculo, idVeiculoPesado, marca, modelo, ano, restricao, valorLocacao);
    }

    // ====== IMPRESSÃO ======
    @Override
    public String toString() {
        String print = "\n\n" + seloDaEmpresa() + "\n\n"
                + "\n\n|---------------     Dados do Veículo        ---------------|" + "\n"
                + "  => Ano             :                        " + super.getAno() + "\n"
                + "  ===> Marca         :                        " + super.getMarca() + "\n"
                + "  ====> Modelo       :                        " + super.getModelo() + "\n"
                + "  =====> Restrição   :                        " + this.getRestricao() + "\n"
                + "  =====> Valor Diária:                        " + super.getValorLocacao() + "\n"
                + "\n|-----------------------------------------------------------|\n";
        return print;
    }

    public static void cadastrarVeiculoPesado() throws SQLException {
        boolean efetuarCadastro = true;

        while (efetuarCadastro) {
            VeiculoPesado dados = new VeiculoPesado();
            System.out.println("|------------------ OFFROAD ------------------|");

            System.out.print("Marca: ");
            dados.setMarca(Teclado.StringInput());
            System.out.print("Modelo: ");
            dados.setModelo(Teclado.StringInput());
            System.out.print("Ano: ");
            dados.setAno(Teclado.IntInput());
            System.out.print("Valor da Diária: ");
            dados.setValorLocacao(Teclado.DoubleInput());
            System.out.print("Restriçao: ");
            dados.setRestricao(Teclado.StringInput());

            VeiculoPesadoDAO dao = new VeiculoPesadoDAO();
            dao.salvarVeiculoPesado(dados);

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