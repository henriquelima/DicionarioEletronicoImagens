package util;

public class ArquivoUtil {
	
	public static String getNomeSistemaArquivo(String palavra, String nomeRealArquivo){
		String nomeSistemaArquivo = palavra +"-"+ nomeRealArquivo;
		return nomeSistemaArquivo;
	}
}