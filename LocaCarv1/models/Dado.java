package LocaCarv1.models;

public class Dado<T> {
    // private T codigo;
    private String vrlString;
    private int vrlInt;

    public Dado(String vrlString) {
        // codigo = cod;
        this.vrlString = vrlString;
    }

    public Dado(int vrlInt) {
        // codigo = cod;
        this.vrlInt = vrlInt;
    }

    // public T getCodigo() {
    //     return codigo;
    // }

    public String getvariavelString() {
        return vrlString;
    }

    public double getvariavelInt() {
        return vrlInt;
    }

    @Override
    public String toString() {
        return "ProdutoG{" + "variavelString=" + vrlString + ", variavelInt=" + vrlInt
                + "}";
     }
 }