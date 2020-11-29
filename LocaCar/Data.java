package LocaCar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {

	public static int[] getArrAnos() {
		
		int vetor[] = new int[30];
		
		int ano = 2013; //ano de início
		for(int i=0; i<vetor.length; i++) {
			vetor[i] = ano;
			ano--;
		}		
		return vetor;
	}

	public static int converterData(String date) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dateOne = null;

		try {
			dateOne = formato.parse(date);
 
			long conversao = dateOne.getTime();
 			
			return Integer.parseInt(String.valueOf(conversao));
			
		}
		catch (Exception exception) {
			System.out.println("Erro de Data: " + exception);
			exception.printStackTrace();
		}
		return 0;
	}

	public static int diffDays(String dateStart, String dateStop) {

		//Inicia o Objeto com o tipo dd/MM/yyyy
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
 
		Date dateOne = null;
		Date dateTwo = null;
 
		try {
			dateOne = formato.parse(dateStart);
			dateTwo = formato.parse(dateStop);
 
			//in milliseconds
			long diff = dateTwo.getTime() - dateOne.getTime();
 			long diffDays = diff / (24 * 60 * 60 * 1000);
 			
			return Integer.parseInt(String.valueOf(diffDays));
			
		}
		catch (Exception exception) {
			System.out.println("Erro de Data: " + exception);
			exception.printStackTrace();
		}
		return 0;
	}

	
}