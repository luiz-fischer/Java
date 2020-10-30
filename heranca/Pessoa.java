package heranca;

public class Pessoa extends SerVivo {
    protected String nome;
    protected String dtNascimento;
    protected String cpf;

    public Pessoa(
        String nome, 
        String dtNascimento, 
        String cpf,
        String tipoResp
    ) {
        super(tipoResp);
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
    }
}
