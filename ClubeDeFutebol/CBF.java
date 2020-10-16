package ClubeDeFutebol;

import java.util.ArrayList;

public class CBF{
    public static void main(String[] args) {
        
        // Criacao dos Times
        Times time1 = new Times(1,"Joinville Esporte Club2", "JEC","Vermelho e Branco", 1975, 125446.54);
        Times time2 = new Times(1,"Mogi Mirim Esporte Clube", "MMEC", "Vermelho e Branco", 1932, 445132.55);
        Times time3 = new Times(3, "São Paulo Futebol Clube", "SPFC", "Vermelho Branco e Preto", 1930, 2659887.99);

        ArrayList listaTimes = new ArrayList<>();

        listaTimes.add(time1);
        listaTimes.add(time2);
        listaTimes.add(time3);

        System.out.println(listaTimes);

        if(time1.getDescricaoEscudo().equals(time3.getDescricaoEscudo())) {
            System.out.println("Sao times iguais");
        } else {
            System.out.println("Sao times distintos");
        }

        if(time1.equals(time2)) {
            System.out.println("Sao times iguais");
        } else {
            System.out.println("Sao times distintos");
        }

        if(time2.equals(time3)) {
            System.out.println("Sao times iguais");
        } else {
            System.out.println("Sao times distintos");
        }
    }    
}
