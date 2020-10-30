package Vendas;

public class Main {
    public static void main(String[] args) {

    Usuario usuario1 = new Usuario("Luiz", "senha1");
    // Usuario usuario2 = new Usuario("Pedro", "senha2");

    Cliente cliente = new Cliente(usuario1, "45345", "Rua Boitagazes", 10, 3124124);
    // Cliente cliente = new Cliente("45345", "Rua Boitagazes", "99", 10, 3124124);
    

    // Funcionario funcionario = (Funcionario) usuario1;
    // funcionario.salario = 10000;
    // funcionario.setor = "Gerente Operações";
    
    // Cliente cliente = (Cliente) usuario1;
    // cliente.cep = "43553";
    // cliente.endereco = "Rua dos Boitacazes";
    // cliente.numero = 10;
    // cliente.telefone = 434342;

    // System.out.println(usuario1);
    System.out.println(cliente);
    
        
    }

    
}
