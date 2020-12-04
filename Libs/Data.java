package Libs;

import java.text.ParseException;
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

	public static Date convDataBanco(String dataSistema) {
		String dataFormatada = "";
		Date dataBanco = new Date();//variavel que vai receber a data para o banco
		
		try {//Conversão da data do sistema para formato da data do Banco
			dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataSistema);
			dataBanco = new SimpleDateFormat("yyyy-MM-dd").parse(dataFormatada);
		} catch (ParseException ex) {
			System.out.println(ex);
		}
		return dataBanco;
	}


	public static String plusDay(String date) throws ParseException {

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		Date dateOne = null;

			dateOne = formato.parse(date);
			dateOne.setDate(dateOne.getDate() + 10);



		return date;
		

	}

	public static int diffDays(String date, String date2) {

		//Inicia o Objeto com o tipo dd/MM/yyyy
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
 
		Date dateOne = null;
		Date dateTwo = null;
 
		try {

			dateOne = formato.parse(date);
			dateTwo = formato.parse(date2);

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

	public static int diffDays2(Date dataDeLocacao, Date dataDeDevolucao) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
 
		Date dateOne = null;
		Date dateTwo = null;
 
		try {
 
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