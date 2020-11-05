package Zoo;


public class Main {
    public static void main(String[] args) {

        Mamifero girafa = new Mamifero("Girafa", 6.25, 4, "Amarelo e Preto", "Savanas Áfricanas", "Herbívoro");

        Peixe peixePalhaco = new Peixe("Peixe Palhaço", 17, 0, "Laranja e Branco", "Oceanos índico e Pacífico.", true );

        System.out.println(girafa);
        girafa.darComida();
        girafa.respiracao();
        System.out.println(peixePalhaco);
        peixePalhaco.darComida();
        peixePalhaco.respiracao();
    
    }
}
