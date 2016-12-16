package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.ConnectionFactory;
import entidade.Usuario;

public class UsuarioDAO {
	
private Connection con;
	
	public UsuarioDAO(){
		this.con = new ConnectionFactory().getConnection();
	}
	
	public void atualiza(Usuario usuario){
		String sql = "update usuario set email=?, senha=?" +
             " where id=?";
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
		
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getSenha());
			stmt.setInt(3, usuario.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public Usuario consultaByEmail(String email){
		String sql = "select * from usuario where email = ?";
		Usuario usuario = new Usuario();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
									
			if(rs.next()){
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setId(rs.getInt("id"));
			} else {
				usuario = null;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return usuario;	
	}
}
