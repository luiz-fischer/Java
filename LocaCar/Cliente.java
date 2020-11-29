package LocaCar;

import java.util.ArrayList;

public class Cliente {
    protected int idCliente;
    protected String nome;
    protected String dataDeNascimento;
    protected String cpf;
    protected int diasParaDevolucao;
    VeiculoLeve veiculoLeve;

    ArrayList<Locacao> locacoes;

    public static ArrayList<Cliente> clientes = new ArrayList<>();

    public Cliente(int idCliente) {
        this.idCliente = idCliente;

    }

    public Cliente(int idCliente, String nome, String dataDeNascimento, String cpf) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
        locacoes = new ArrayList<Locacao>();

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
        String print = 
                "\n|---------------     Dados do Cliente        ---------------|" + "\n" + 
                // "Id do CLiente:                             " + getIdCliente() + "\n" +
                // "Nome:                                      " + getNome() + "\n" + 
                // "Data de Nascimento:                        " + getDataDeNascimento() + "\n" + 
                // "CPF:                                       " + getCpf() + "\n" + 
                // "Quantidade de Veiculos Locados:            " + qtdVeiculosLocados() + "\n" + 
                // "Dias para Devolução: " + qtdDiasLocados() +
                "\n|-----------------------------------------------------------|\n";
        return print;
    }


    // ====== MÉTODOS ======
    public int qtdVeiculosLocados() {
        int cont = 0;
        for (Cliente cliente : clientes) {
            for (Locacao locacao : Locacao.locacoes) {
                while(cliente.idCliente == locacao.idCliente)
                    cont++;
            }
        }
        // int veiculosLocados = this.locacoes.size();
        return cont;
    }

    public static void pesquisar(int valorId) {
        // Scanner entrada = new Scanner(System.in);
        try {
            if (clientes.size() == 0) {
                System.out.println("Não há Clientes cadastrados!");
            } else {
                // int valorId = entrada.nextInt();
                valorId--; // pq ao invés de começar o for de zero, começamos de 1, mas guardamos no
                           // elemento 0 do array

                Cliente aux = clientes.get(valorId);
                System.out.println("Nome do Cliente:" + aux.nome);
                System.out.print("\nI.D. Do Cliente:" + aux.idCliente);
            }
        } catch (Exception exception) {
            System.out.println(exception);

        } finally {
            // entrada.close();
        }
    }

    public int qtdDiasLocados() {
        int diasLocados = Data.diffDays(Locacao.locacoes.get(idCliente).getDataDeLocacao(), Locacao.locacoes.get(idCliente).getDataDeDevolucao());
        return diasLocados;
    }

    public void imprimirLocacoes() {
        System.out.println( " * O Cliente: " + getNome() + "\n" + 
                            "\nPossui o total de Locações de:  " + qtdVeiculosLocados() + "\n" +
                            "\n"
        );
    }
}