package Vendas;

public class Main {
    public static void main(String[] args) {

    Usuario usuario1 = new Usuario("", "");
    Usuario usuario2 = new Usuario("Pedro", "senha2");

    // Funcionario funcionario = (Funcionario) usuario1;
    // funcionario.salario = 10000;
    // funcionario.setor = "Gerente Operações";
    
    Cliente cliente = (Cliente) usuario2;
    cliente.cep = "43553";
    cliente.endereco = "Rua dos Boitacazes, n10";
    cliente.numero = 10;
    cliente.telefone = 434342;

    System.out.println(usuario1);
    System.out.println(usuario2);
    

        
    }

    
}
