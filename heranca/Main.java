package heranca;

public class Main {
    public static void main(String[] args) {
        Matematica.somaClasse(1, 1);
        Math.min(10, 5);

        Pessoa pessoa1 = new Pessoa("","","","");


        Empregado empregado = (Empregado) pessoa1;
        empregado.salario = 10000;
        
    }
}
