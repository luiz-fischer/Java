package LocaCar.teste;


public class Locadora {

    /**

     * @param args the command line arguments

     */

    public static void main(String[] args) {

        Filme a = new Filme("001", "BATMAN");

        Filme b = new Filme("002", "X-MAN");

        Filme c = new Filme("003", "HULK");

        Filme d = new Filme("004", "IRON MAN");

        Cliente e = new Cliente("João", "");

        Cliente f = new Cliente("José", "");

        Cliente g = new Cliente("Antenor", "");

        Cliente h = new Cliente("Maria", "");

        

        e.emprestar(a);

        e.emprestar(c);
        f.emprestar(b);

        

        e.mostraFilmes();
        f.mostraFilmes();

        

        c.reservarFime(f);

        c.reservarFime(g);

        c.reservarFime(h);
        System.out.println();

        System.out.println(c);
        

    }

}