package Animais;

public class Zoo {
    public static void main(String[] args) {
        Mamiferos baleia = new Mamiferos();
        Aves dodo = new Aves();
        
        dodo.Locomover();
        dodo.PorOvos(4);
        dodo.PorOvos("Amarelo");
        baleia.Locomover();

        dodo.Comer();
    }
}
