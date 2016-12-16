package entidade;

public class Arquivo {
	
	private int id;
	private String palavra;
	private String significado;
	private String nomeRealArquivo;
	private String nomeSistemaArquivo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPalavra() {
		return palavra;
	}
	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	public String getNomeRealArquivo() {
		return nomeRealArquivo;
	}
	public void setNomeRealArquivo(String nomeRealArquivo) {
		this.nomeRealArquivo = nomeRealArquivo;
	}
	public String getNomeSistemaArquivo() {
		return nomeSistemaArquivo;
	}
	public void setNomeSistemaArquivo(String nomeSistemaArquivo) {
		this.nomeSistemaArquivo = nomeSistemaArquivo;
	}
	public String getSignificado() {
		return significado;
	}
	public void setSignificado(String significado) {
		this.significado = significado;
	}
	
}
