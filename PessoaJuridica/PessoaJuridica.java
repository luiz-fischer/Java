package PessoaJuridica;

import Pessoa.Pessoa;

public class PessoaJuridica extends Pessoa {
    protected String cnpj;
    protected String nomeFantasia;

    @Override
    public void Cadastrar() {
        System.out.println("Cliente Juridico Cadastrado!");
    }
    
}
