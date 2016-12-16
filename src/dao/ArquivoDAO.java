package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.ConnectionFactory;
import entidade.Arquivo;

public class ArquivoDAO {
private Connection con;
	
	public ArquivoDAO(){
		this.con = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Arquivo arquivo){
		String sql = "insert into arquivos" + "(palavra,significado,nomeSistemaArquivo)" + " values (?,?,?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1,arquivo.getPalavra());
			stmt.setString(2,arquivo.getSignificado());
			stmt.setString(3,arquivo.getNomeSistemaArquivo());	
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace(); 
		} 	
	}
	
	public void buscarTodos(String letra){
		
	}
	
	public Arquivo consultaByPalavra(String palavra){
		String sql = "select * from arquivos where palavra=?";
		Arquivo arquivo = new Arquivo();
		
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, palavra);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				arquivo.setPalavra(rs.getString("palavra"));
				arquivo.setSignificado(rs.getString("significado"));
				arquivo.setNomeSistemaArquivo(rs.getString("nomeSistemaArquivo"));
			}else{
				arquivo = null;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return arquivo;
	}

}
