package LocaCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    protected int idCliente;
    protected String nome;
    protected String dataDeNascimento;
    protected String cpf;
    protected int diasParaDevolucao;
    List<Locacao> locacoes;

    // public static List<Cliente> clientes = new ArrayList<>();
    public static BancoDeDados<Cliente> clientes = new BancoDeDados<>();


    // SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    
    public Cliente() {
    }

    public Cliente(int idCliente, String nome, String dataDeNascimento, String cpf) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;

        this.locacoes = new ArrayList<>();

        clientes.insertValue(this);
        // clientes.add(this);

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

    public void setDiasParaDevolucao(int diasParaDevolucao) {
        this.diasParaDevolucao = diasParaDevolucao;

    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(List<Locacao> locacoes) {
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
    public int getDiasParaDevolucao() {
        return this.diasParaDevolucao;

    }

    // ====== MÉTODOS ======
    public int qtdVeiculosLocados() {
        int veiculosLocados = this.locacoes.size();
        return veiculosLocados;
    }

    public String imprimirLocacoes() {
        String print = " * O Cliente " + this.nome + 
                 "\nPossui o total de Locações de:  " + this.qtdVeiculosLocados();
        return print;
    }
    
    public static void pesquisar(){
        Scanner entrada = new Scanner( System.in );
        try { if (clientes.sizeList() == 0) 
        {
            System.out.println("Não há Clientes cadastrados!");
        } else {
            System.out.print("Digite o número do I.D. Do Cliente: ");
            int nmrConta = entrada.nextInt();
            nmrConta--; //pq ao invés de começar o for de zero, começamos de 1, mas guardamos no elemento 0 do array

            Cliente auxiliar = clientes.getValor(nmrConta);
            System.out.println("Nome do Cliente:" + auxiliar.nome);
            System.out.println("I.D. Do Cliente:" +auxiliar.idCliente);
        }   
        } catch (Exception exception) {
                System.out.println(exception);

        } finally {
            entrada.close();
        }
    }

    // ====== EQUALS ====== 
    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof Cliente))
            return false;

        Cliente cliente = (Cliente) object;

        return idCliente == this.idCliente;
    }

    // ====== IMPRESSÃO ====== 
    @Override
    public String toString() {
        String print = "++ Dados do Cliente ++" + "\n" + 
                    "Id do CLiente: " + getIdCliente() + "\n" +
                    "Nome: " + getNome() + "\n" +
                    "Data de Nascimento: " + getDataDeNascimento() + "\n" + 
                    "CPF: " + getCpf() + "\n" +
                    "Dias para Devolução: " +
                    "\n------------------------------------------------";
        return print;
    }
}