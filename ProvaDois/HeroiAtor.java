package ProvaDois;

public class HeroiAtor {
    int idHeroi;
    int idAtor; 
    Ator ator;
    Heroi heroi;
      
    /**
     * 
     * @param filme
     * @param heroi
     */
    public HeroiAtor(Heroi heroi, Ator ator) {
        this.idHeroi = heroi.idHeroi;
        this.idAtor = ator.id;
        this.heroi = heroi; 
        this.ator = ator;

       
    }
   
}
