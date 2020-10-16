package ClubeDeFutebol;

public class CBF {
    public static void main(String[] args) {
        
        // Criacao dos Times.
        Times jec = new Times(1,"Joinville Esporte Clube", "J.E.C.","Vermelho e Branco", 1975, 125446.54);
        Times mogiMirim = new Times(1,"Mogi Mirim Esporte Clube", "M.M.E.C.", "Vermelho e Branco", 1932, 445132.55);
        Times saoPaulo = new Times(3, "São Paulo Futebol Clube", "S.P.F.C.", "Vermelho Branco e Preto", 1930, 2659887.99);

        // Adição do Time a lista.
        Times.listaTimes.add(jec);
        Times.listaTimes.add(mogiMirim);
        Times.listaTimes.add(saoPaulo);

        // Impressão.
        System.out.println(Times.listaTimes);

        // Comparação dos Times pelo Nome.
        if(jec.getDescricaoEscudo().equals(saoPaulo.getDescricaoEscudo())) {
            System.out.println(jec.getNome() + " e " + saoPaulo.getNome() + " sao times iguais");
        } else {  
            System.out.println(jec.getNome() + " e " + saoPaulo.getNome() + " sao times distindos");
        }  
  
        if(jec.equals(mogiMirim)) {  
            System.out.println(jec.getNome() + " e " + mogiMirim.getNome() + " sao times iguais");
        } else {  
            System.out.println(jec.getNome() + " e " + mogiMirim.getNome() + " sao times distintos");
        }  
  
        if(mogiMirim.equals(saoPaulo)) {  
            System.out.println(mogiMirim.getNome() + " e " + saoPaulo.getNome() + " sao times iguais");
        } else {  
            System.out.println(mogiMirim.getNome() + " e " + mogiMirim.getNome() + " sao times distintos");
        } 
    }    
}
