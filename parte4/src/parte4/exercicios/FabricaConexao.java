package parte4.exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class FabricaConexao {
	public static Connection getConexao() {
		String login = "postgres";
		String senha = "postgres";
		String urlcon = "jdbc:postgresql://localhost:5432/Teste1";
		Connection con = null;
		try {
			con = DriverManager.getConnection(urlcon, login, senha);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return con;
	}
}
