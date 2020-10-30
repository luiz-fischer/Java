package heranca;

public class Terceiro extends Pessoa {
    private String empresa;

    public Terceiro(
        String nome, 
        String dtNascimento, 
        String cpf,
        String empresa
    ) {
        super(nome, dtNascimento, cpf);
        this.empresa = empresa;
    }

    public Terceiro(String nome, String dtNascimento) {
        this(nome, dtNascimento,  "", "");
    }
}
