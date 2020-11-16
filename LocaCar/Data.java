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
	
	public static int diffDays(String dateStart, String dateStop) {
		

		//HH converts hour in 24 hours format (0-23), day calculation
//		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
 
		Date d1 = null;
		Date d2 = null;
 
		try {
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);
 
			//in milliseconds
			long diff = d2.getTime() - d1.getTime();
 			long diffDays = diff / (24 * 60 * 60 * 1000);
 			
			return Integer.parseInt(String.valueOf(diffDays));
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}