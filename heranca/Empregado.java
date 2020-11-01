package heranca;

public class Empregado extends Pessoa {
    public double salario;

    public Empregado(
        String nome, 
        String dtNascimento, 
        String cpf, 
        double salario
    ) {
        super(nome, dtNascimento, cpf);
        this.salario = salario;
    }

    public Empregado(String nome, String dtNascimento) {
        this(nome, dtNascimento,  "", 0);
    }

    public String toString() {
        return this.salario + super.cpf;
    }
}
