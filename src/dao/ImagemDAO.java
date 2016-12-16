package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexao.ConnectionFactory;

public class ImagemDAO {
	
private Connection con;
	
	public ImagemDAO(){
		this.con = new ConnectionFactory().getConnection();
	}
	
	public byte[] recuperaImagem(String palavra)throws Exception{
       
        String SQL = "select * from imagens where nome=?";
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setString(1, palavra);
        try {  
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                return resultado.getBytes("imagem");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


}
