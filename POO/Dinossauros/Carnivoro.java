package POO.Dinossauros;

import POO.Animal;

public class Carnivoro extends Animal{
    public  String dentes;
    protected boolean cacador;

    @Override
    public void Comer() {
        System.out.println("Corre se nao vira comida");
    }

    
}
