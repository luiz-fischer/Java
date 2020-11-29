package LocaCar;


public abstract class Veiculo {
   protected String marca;
   protected String modelo;
   protected int ano;
   protected double valorLocacao;

   public Veiculo() {

   }

   public Veiculo(String marca, String modelo, int ano, double valorLocacao) {
       this.marca = marca;
       this.modelo = modelo;
       this.ano = ano;
       this.valorLocacao = valorLocacao;

   }

   // ======== SETS ========
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
   public String getMarca() {
       return marca;

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

    public abstract Veiculo getVeiculo(int id) throws Exception;

    // ====== IMPRESSÃO ====== 
    @Override
    public String toString() {
        String print = "*********** Veículo  ***********" + "\n" +
                    "Marca: "              + getMarca() + "\n" +
                    "Modelo: "             + getModelo() + "\n" +
                    "Ano: "                + getAno() + "\n" +
                    "Valor para Locação: " + getValorLocacao() + "\n";
        return print;
    }
    
}