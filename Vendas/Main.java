package Vendas;

public class Main {
    public static void main(String[] args) {

    
    Cliente cliente1 = new Cliente("Luiz", "senha1", "89500-552", "Rua Boitagazes", 10, 987456224);
    System.out.println(cliente1);

    Funcionario funcionario1 = new Funcionario("Pedro", "senha2", "Vendedor", 2000);
    System.out.println(funcionario1);

    Gerente gerente1 = new Gerente("Teodoro", "senha3", "Compras", 10000);
    System.out.println(gerente1);
        
    }

    
}
