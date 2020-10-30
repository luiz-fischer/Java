package heranca;

public class Pessoa {
    protected String nome;
    protected String dtNascimento;
    protected String cpf;

    public Pessoa(
        String nome, 
        String dtNascimento, 
        String cpf
    ) {
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
    }
}
