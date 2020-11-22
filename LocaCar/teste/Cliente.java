package LocaCar.teste;

import java.util.ArrayList;

public class Cliente {

    private String nome;

    private String cpf;

    private ArrayList<Filme> emprestados;

    private int nFilmes;

    public Cliente(String nome, String cpf) {

        this.nome = nome;

        this.cpf = cpf;

        emprestados = new ArrayList<Filme>();

    }

    public String getNome() {

        return nome;

    }

    public void setNome(String nome) {

        this.nome = nome;

    }

    public String getCpf() {

        return cpf;

    }

    public void setCpf(String cpf) {

        this.cpf = cpf;

    }

    public int getnFilmes() {

        return nFilmes;

    }

    public void setnFilmes(int nFilmes) {

        this.nFilmes = nFilmes;

    }

    public void emprestar(Filme f) {

        f.setEmprestador(this);

        emprestados.add(f);

    }

    public void devolver(String codFilme) {

        for (Filme f : emprestados) {

            if (f.getCodigo().equals(codFilme)) {

                emprestados.remove(f);

                f.setEmprestador(null);

                break;

            }

        }

    }

    public void mostraFilmes() {

        System.out.println(nome);

        for (Filme f : emprestados) {

            System.out.println(f.getNome());

        }

    }

} 