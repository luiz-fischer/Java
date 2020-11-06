package Zoo;

public class Main {
    public static void main(String[] args) {

        Mamifero girafa = new Mamifero("Girafa", 6.25, 4, "Amarelo e Preto", "Savanas Áfricanas", "Herbívoro");

        Peixe peixePalhaco = new Peixe("Peixe Palhaço", 17, 0, "Laranja e Branco", "Oceanos índico e Pacífico.", true);

        Gato persa = new Gato("Macio", "Persa", 0.75, 4, "Branco e Bege", "Doméstico", "Whiskas");

        Vaca holandesa = new Vaca("Leite Gordo", "Holandesa", 2.00, 4, "Preta com Manchas Pretas", "Pasto", "Grama");

        Ovelha ovelha = new Ovelha("Branco", "Uma Ovelha", 1.00, 4, "Branco Neve", "Pasto", "Grama");
        System.out.println(girafa);
        girafa.darComida();
        girafa.respiracao();
        System.out.println(peixePalhaco);
        peixePalhaco.darComida();
        peixePalhaco.respiracao();

        System.out.println(persa);
        persa.emitirSom();
        System.out.println(holandesa);
        holandesa.emitirSom();
        System.out.println(ovelha);
        ovelha.emitirSom();

    }
}
