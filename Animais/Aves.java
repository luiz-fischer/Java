package Animais;

public class Aves extends Animal {
    public String bico;
    public void PorOvos(String cor) {};
    public void PorOvos(int qtdPorVez) {};

    @Override
    public void Comer() {
        System.out.println("Pic Pic Pic!!");
    }

}

