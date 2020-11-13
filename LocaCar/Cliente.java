package LocaCar;

import java.util.ArrayList;

public class Cliente {
    protected int idCliente;
    protected String nome;
    protected String dataDeNascimento;
    protected String cpf;
    protected int diasParaDevolucao;
    ArrayList<Locacao> locacoes;

    public static ArrayList<Cliente> clientes = new ArrayList<>();

    public Cliente(int idCliente, String nome, String dataDeNascimento, String cpf, int diasParaDevolucao) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
        this.diasParaDevolucao = diasParaDevolucao;

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
    public void setDiasParaDevolucao(int diasParaDevolucao) {
        this.diasParaDevolucao = diasParaDevolucao;

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

    public void imprimirLocacoes() {
        System.out.println(
            " * O Cliente " + this.nome + 
            "\nPossui um total de Locações de:  " + this.qtdVeiculosLocados()
        );
    }

    // ====== EQUALS ====== 
    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof Cliente))
            return false;

        Cliente cliente = (Cliente) object;

        return idCliente == cliente.idCliente;
    }

    // ====== IMPRESSÃO ====== 
    @Override
    public String toString() {
        String print = "++ Dados do Cliente ++" + "\n" + 
                    "Nome: " + getNome() + "\n" +
                    "Data de Nascimento" + getDataDeNascimento() + "\n" +
                    "CPF: " + getCpf() + "\n" +
                    "Dias para Devolução: " + getDataDeNascimento() + 
                    "------------------------------------------------";
        return print;
    }
}