package LocaCarv1.models;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente {
    private int idCliente;
    private String nome;
    private String dataDeNascimento;
    private String cpf;
    private int qtdDiasLocacao;

    public ArrayList<Locacao> locacoes = new ArrayList<>();
    public ArrayList<Cliente> clientes = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(int idCliente, String nome, String dataDeNascimento, String
    cpf, int qtdDiasLocacao) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
        this.qtdDiasLocacao = qtdDiasLocacao;

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

    public void setLocacoes(ArrayList<Locacao> locacoes) {
        this.locacoes = locacoes;
    }
    public int setQtdDiasLocacao(int qtdDiasLocacao) {
        if((qtdDiasLocacao == 5) && (qtdDiasLocacao == 10) && (qtdDiasLocacao == 15)) {
            this.qtdDiasLocacao = qtdDiasLocacao;
        } else {
            this.qtdDiasLocacao = 0;
        } return this.qtdDiasLocacao;
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

    // ====== EQUALS ======
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return Objects.equals(idCliente, this.idCliente) && Objects.equals(nome, this.nome)
                && Objects.equals(cpf, this.cpf) && Objects.equals(dataDeNascimento, this.dataDeNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, nome, cpf);
    }

    @Override
    public String toString() {
        String print = "\n|---------------     Dados do Cliente        ---------------|" + "\n" + 
                       "  Nome                          :            " + getNome() + "\n" +
                       "  Data de Nascimento            :            " + getDataDeNascimento() + "\n" +
                       "  CPF                           :            " + getCpf() + "\n" +
                       "  Dias De Locação               :            " + getQtdDiasLocacao() + "\n" +
                       "\n|-----------------------------------------------------------|\n";
        return print;
    }

    public Cliente getCliente(int id) throws Exception {
        return clientes.get(id);
     }

}