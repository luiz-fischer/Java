package Pessoa;

import PessoaFisica.PessoaFisica;
import PessoaJuridica.PessoaJuridica;

public class Cliente {
    public static void main(String[] args) {
        PessoaFisica cliente1 = new PessoaFisica();
        PessoaJuridica cliente2 = new PessoaJuridica();

        cliente1.Cadastrar();
        
        cliente2.Cadastrar();
        
                

    }
    
}
