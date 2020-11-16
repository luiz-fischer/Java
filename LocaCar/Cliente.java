package LocaCar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Cliente {
    protected int idCliente;
    protected String nome;
    protected String dataDeNascimento;
    protected String cpf;
    protected int diasParaDevolucao;
    ArrayList<Locacao> locacoes;
    private static int pedidoNumero = 1;

    public static ArrayList<Cliente> clientes = new ArrayList<>();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    public Cliente() {

    }

    public Cliente(int idCliente, String nome, String dataDeNascimento, String cpf) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;

        this.locacoes = new ArrayList<>();

        // LocalDate datetime = LocalDate.parse(dataDeNascimento,
        // DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        // String newstring =
        // datetime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        // this.dataDeNascimento = newstring;

        clientes.add(this);

    }

    // ======== SETS ========
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
        // if(idCliente == 0) {
        // this.idCliente = 1;
        // } else {
        // this.idCliente = idCliente;
        // }
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

    public ArrayList<Locacao> getLocacoes() {
        return locacoes;
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