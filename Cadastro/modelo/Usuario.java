package Cadastro.modelo;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Usuario {
    static Long id;
    static String nome;
    static String cpf;
    static String email;
    static String telefone;

    public static String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        Usuario.cpf = cpf;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Usuario.email = email;
    }

    public static String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Usuario.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Usuario.id = id;
    }

    public static String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        Usuario.telefone = telefone;
    }

}
