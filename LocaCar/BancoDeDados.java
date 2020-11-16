package LocaCar;

    
import java.util.ArrayList;

public class BancoDeDados<T> {

    private ArrayList<T> banco = new ArrayList<>();
    public void insertValue(T valor) {
          this.banco.add(valor);
    }
 
    public T getValor(int index) throws Exception {
        if(index < 0) {
        throw new Exception("Valor não pode ser inferior a 0");
    }
        return this.banco.get(index);
    }

    public ArrayList<T> getList() {
        return this.banco;
    }
}​​​​​​​​
