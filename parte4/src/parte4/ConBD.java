package parte4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConBD {
	public Connection getConexao() {
		String login = "postgres";
		String senha = "postgres";
		String urlcon = "jdbc:postgresql://localhost:5432/aulapoo2";
		Connection con = null;
		try {
			con = DriverManager.getConnection(urlcon, login, senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public String getLinha(int id) {
		String retorno = "";
		
		String sql = "SELECT id, nome, datanascimento "
					+ "FROM pessoa WHERE id =?";
		
		try (Connection c = getConexao();
			var pstm =  c.prepareStatement(sql)){
			
			System.out.println(pstm.getClass().getName());
			pstm.setInt(1, id);
			ResultSet res = pstm.executeQuery();
			if(res.next()) {
				retorno = res.getInt("id") + " - "+ res.getString(2);
			}
			res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retorno;
	}
}
