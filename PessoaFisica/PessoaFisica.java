package PessoaFisica;

import Pessoa.Pessoa;


public class PessoaFisica extends Pessoa {
    protected String cpf;    

    @Override
    public void Cadastrar() {
        System.out.println("Cliente Fisico Cadastrado!");
    }
    
}
