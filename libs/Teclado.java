package libs;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Teclado {
    // private static Scanner entrada;

    private static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

    public static String StringInput() {
        String valor = null;
        try {
            valor = teclado.readLine();
        } catch (IOException e) {
            System.out.println(e);
        }
        return (valor);
    }

    public static int IntInput() {
        String valor = null;
        int numero;
        valor = StringInput();
        numero = new Integer(valor).intValue();
        return (numero);
    }

    public static float FloatInput() {
        String valor = null;
        float numero;
        valor = StringInput();
        numero = new Float(valor).floatValue();
        return (numero);
    }

    public static java.sql.Date DateInput() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String date = null;
        Date data = null;
        date = StringInput();
        data = dateFormat.parse(date);
        return (java.sql.Date) (data);
    }

    public static double DoubleInput() {
        String valor = null;
        double numero;
        valor = StringInput();
        numero = new Double(valor).doubleValue();
        return (numero);
    }

    // public static String textInput(String texto) {
    //     System.out.print(texto);
    //     return entrada.nextLine();
    // }

    // public static int intInput(String texto) {
	// 	System.out.print(texto);
	// 	return entrada.nextInt();
    // }
    // public static double doubleInput(String texto) {
	// 	System.out.print(texto);
	// 	return entrada.nextDouble();
	// }
      
}