package heranca;

public class Terceiro extends Pessoa {
    private String empresa;

    public Terceiro(
        String nome, 
        String dtNascimento, 
        String cpf,
        String tipoResp,
        String empresa
    ) {
        super(nome, dtNascimento, cpf, tipoResp);
        this.empresa = empresa;
    }

    public Terceiro(String nome, String dtNascimento) {
        this(nome, dtNascimento, "", "", "");
    }
}
