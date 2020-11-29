package LocaCar;

import java.util.ArrayList;
import java.util.List;
public class BancoDeDados<T> {

    public ArrayList<T> banco = new ArrayList<>();
    public void insertValue(T valor) {
          this.banco.add(valor);
    }
 
    public T getValor(int index) throws Exception {
        if(index < 0) {
        throw new Exception("Valor não pode ser inferior a 0");
    }
        return this.banco.get(index);
    }

    public List<T> getList() {
        return this.banco;
    }

    public int sizeList() {
        return this.banco.size();
    }

}