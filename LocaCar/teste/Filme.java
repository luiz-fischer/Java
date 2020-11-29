package LocaCar.teste;

import java.util.ArrayList;

public class Filme {

    private String nome, codigo;
    private ArrayList<Cliente> reservas;
    private int nReservas;
    private Cliente emprestador;

    public Filme(String codigo) {

        this.codigo = codigo;

        reservas = new ArrayList<Cliente>();

    }

    public Filme(String codigo, String nome) {

        this.nome = nome;

        this.codigo = codigo;

        reservas = new ArrayList<Cliente>();

    }

    public String getNome() {

        return nome;

    }

    public void setNome(String nome) {

        this.nome = nome;

    }

    public String getCodigo() {

        return codigo;

    }

    public void setCodigo(String codigo) {

        this.codigo = codigo;

    }

    public ArrayList<Cliente> getReservas() {

        return reservas;

    }

    public void setReservas(ArrayList<Cliente> reservas) {

        this.reservas = reservas;

    }

    public int getnReservas() {

        return nReservas;

    }

    public void setnReservas(int nReservas) {

        this.nReservas = nReservas;

    }

    public Cliente getEmprestador() {

        return emprestador;

    }

    public void setEmprestador(Cliente emprestador) {

        this.emprestador = emprestador;

    }

    public void reservarFime(Cliente c) {

        reservas.add(c);

    }

	public void setEmprestsador(Cliente cliente) {
	}

}