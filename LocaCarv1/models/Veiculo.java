package LocaCarv1.models;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Veiculo {
    protected int idVeiculo;
    protected String marca;
    protected String modelo;
    protected int ano;
    protected double valorLocacao;

    public static ArrayList<Veiculo> veiculos = new ArrayList<>();

    public Veiculo() {

    }

    public Veiculo(
        int idVeiculo, 
        String marca, 
        String modelo,
        int ano,
        double valorLocacao) {
            this.idVeiculo = idVeiculo;
            this.marca = marca;
            this.modelo = modelo;
            this.ano = ano;
            this.valorLocacao = valorLocacao;

            veiculos.add(this);

    }

    // ======== SETS ========
    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public void setMarca(String marca) {
        this.marca = marca;

    }

    public void setModelo(String modelo) {
        this.modelo = modelo;

    }

    public void setAno(int ano) {
        this.ano = ano;

    }

    public void setValorLocacao(double valorLocacao) {
        this.valorLocacao = valorLocacao;

    }

    // ======== GETS ========
    public int getIdVeiculo() {
        return this.idVeiculo;
    }

    public String getMarca() {
        return this.marca;

    }

    public String getModelo() {
        return this.modelo;

    }

    public int getAno() {
        return this.ano;

    }

    public double getValorLocacao() {
        return this.valorLocacao;

    }

    // ====== EQUALS ======
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return 
            Objects.equals(idVeiculo, this.idVeiculo) && 
            Objects.equals(marca, this.marca) && 
            Objects.equals(modelo, this.modelo) && 
            Objects.equals(ano, this.ano) &&
            Objects.equals(valorLocacao, this.valorLocacao);
    }

    // ====== HASH ======
    @Override
    public int hashCode() {
        return Objects.hash(idVeiculo, marca, modelo, ano, valorLocacao);
    }

    // ====== IMPRESSÃO ======
    @Override
    public String toString() {
        String print = "\n|---------------     Dados do Veículo     ---------------|" + "\n"
                + "I.D. Veículo      :                        " + getIdVeiculo() + "\n"
                + "Marca             :                        " + getMarca() + "\n"
                + "Modelo            :                        " + getModelo() + "\n"
                + "Ano               :                        " + getAno() + "\n"
                + "Valor para Locação:                        " + getValorLocacao() + "\n"
                + "\n|--------------------------------------------------------|\n";
        return print;
    }

}