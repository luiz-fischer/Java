package libs;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

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
			dateOne = (Date) formato.parse(date);
 
			long conversao = dateOne.getTime();
 			
			return Integer.parseInt(String.valueOf(conversao));
			
		}
		catch (Exception exception) {
			System.out.println("Erro de Data: " + exception);
			exception.printStackTrace();
		}
		return 0;
	}

	public String convDataBanco(String dataSistema) {
		Date dataFormatada;
		String dataBanco = "";//variavel que vai receber a data para o banco
		try {//Conversão da data do sistema para formato da data do Banco
			dataFormatada = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(dataSistema);
			dataBanco = new SimpleDateFormat("yyyy-MM-dd").format(dataFormatada);
		} catch (ParseException ex) {
			System.out.println(ex);
		}
		return dataBanco;
	}


	public final static Long calcDifAnos(Date dtInicial, Date dtFinal) {
		LocalDate ldInicial = dtInicial.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate ldFinal = dtFinal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		return ldInicial.until(ldFinal, ChronoUnit.YEARS);
	}

	public final static Long calcDifDias(Date dtInicial, Date dtFinal) {
		LocalDate ldInicial = convParaLocalDate(dtInicial);
		LocalDate ldFinal = convParaLocalDate(dtFinal);
		return ldInicial.until(ldFinal, ChronoUnit.DAYS);
	}

	public final static Long calcDifDias(LocalDate ldInicial, LocalDate ldFinal) {
		return ldInicial.until(ldFinal, ChronoUnit.DAYS);
	}

	public final static Date plusDays(Date date, long qtdDays) {
		return convParaDate(convParaLocalDate(date).plusDays(qtdDays));
	}

	public final static Date convParaDate(LocalDate localDate) {
		Instant i = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
		return (Date) Date.from(i);
	}

	public final static LocalDate convParaLocalDate(Date date) {
		return LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(date));
	}

	public static int diffDays(String date, String date2) {

		//Inicia o Objeto com o tipo dd/MM/yyyy
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
 
		Date dateOne = null;
		Date dateTwo = null;
 
		try {
			dateOne = (Date) formato.parse(date);
			dateTwo = (Date) formato.parse(date2);
 
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

	public static int diffDays2(Date dataDeLocacao, Date dataDeDevolucao) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
 
		Date dateOne = null;
		Date dateTwo = null;
 
		try {
			dateOne = (dataDeLocacao);
			dateTwo = (dataDeDevolucao);
 
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