package ProvaDois;

public class HeroiFilme {
    int idHeroi;
    int idFilme; 
    Filme filme;
    Heroi heroi;
      
    /**
     * 
     * @param filme
     * @param heroi
     */
    public HeroiFilme(Filme filme, Heroi heroi) {
        this.idHeroi = heroi.idHeroi;
        this.idFilme = filme.idFilme;
        this.filme = filme;
        this.heroi = heroi; 

       
    }
   
}
