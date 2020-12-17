package LocaCarv1.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import LocaCarv1.DAO.ClienteDAO;
import Libs.Teclado;

public class Cliente {
    private int idCliente;
    private String nome;
    private String dataDeNascimento;
    private String cpf;
    private int qtdDiasLocacao;
    Locacao locacao;

    public ArrayList<Locacao> locacoes;
    public ArrayList<Cliente> clientes = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(
        int idCliente, 
        String nome, 
        String dataDeNascimento, 
        String cpf
        ) {
            this.idCliente = idCliente;
            this.nome = nome;
            this.dataDeNascimento = dataDeNascimento;
            this.cpf = cpf;
            
            this.locacoes = new ArrayList<>();

            clientes.add(this);

    }

    // ======== SETS ========
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setQtdDiasLocacao(int qtdDiasLocacao) {
        this.qtdDiasLocacao = qtdDiasLocacao;
    }

    public void setLocacoes(ArrayList<Locacao> locacoes) {
        this.locacoes = locacoes;
    }
    

    // ======== GETS ========
    public int getIdCliente() {
        return this.idCliente;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDataDeNascimento() {
        return this.dataDeNascimento;
    }

    public String getCpf() {
        return this.cpf;

    }
    public int getQtdDiasLocacao() {
        return this.qtdDiasLocacao;
    }
    public ArrayList<Locacao> getLocacoes() {
        return this.locacoes;
    }

    // ====== EQUALS ======
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return 
            Objects.equals(idCliente, this.idCliente) && 
            Objects.equals(nome, this.nome) && 
            Objects.equals(cpf, this.cpf) && 
            Objects.equals(dataDeNascimento, this.dataDeNascimento
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, nome, cpf, dataDeNascimento);
    }

    @Override
    public  String toString() {
        String print = "\n|---------------     Dados do Cliente        ---------------|" + "\n\n" + 
                       "  Nome                :               " + getNome() + "\n" +
                       "  I.D. Cliente        :               " + getIdCliente() + "\n" +
                       "  Data de Nascimento  :               " + getDataDeNascimento() + "\n" +
                       "  CPF                 :               " + getCpf() + "\n" +
                       "  Dias De Locação     :               " + Locacao.totalDeDiasLocados() + "\n" +
                       "\n|---------------------------------------------------------------|\n";
        return print;
    }

    public Cliente getCliente(int id) throws Exception {
        return clientes.get(id);
     }

     public static void cadastrarCliente() throws SQLException {
		boolean efetuarCadastro = true;

		while (efetuarCadastro) {
			Cliente dados = new Cliente();

			System.out.println(
								"|------------------ Cadastro de Cliente ------------------|"
							);

			System.out.print("Nome: ");
			dados.setNome(Teclado.StringInput());
			System.out.print("CPF: ");
			dados.setCpf(Teclado.StringInput());
			System.out.print("Formato da Data - aaaa/MM/dd \n");
			dados.setDataDeNascimento(Teclado.StringInput());
			// System.out.print("Quantidade de dias para Locação:" +  "\n" + "[5] - [10] - [15]: ");
			// dados.setQtdDiasLocacao(Teclado.IntInput());

			ClienteDAO dao = new ClienteDAO();
			dao.salvarCliente(dados);
			
			System.out.println("!!! -- Continuar Cadastrando (S/N) -- !!!");
			String continuarCadastro = Teclado.StringInput();

			if (continuarCadastro.equalsIgnoreCase("N")) {
				efetuarCadastro = false;
			} else if (continuarCadastro.equalsIgnoreCase("s")) {
			} else {
				System.out.println("\n!!! -- SAIR -- !!! \n");
				efetuarCadastro = false;

			}
        }
    }

}			