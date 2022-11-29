package br.edu.ifrs.osorio.parte6orm.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.edu.ifrs.osorio.parte6orm.model.Etapa;

public class EtapaDAO implements DAO<Etapa>{

	@Override
	public void inserir(Etapa etapa) {
		if (etapa.getId() != null)
			throw new RuntimeException("Objeto já salvo no BD");

		String sql = "INSERT INTO etapa (\"nome\", \"idideia\") VALUES (?,?)";

		try (Connection c = FabricaConexao.getConexao(); 
			 var pstm = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, etapa.getNome());
			pstm.setInt(2, etapa.getIdeia().getId());
			pstm.execute();
			ResultSet res = pstm.getGeneratedKeys();
			if (res.next()) {
				etapa.setId(res.getInt("id"));
			}
			res.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Etapa> listar(int limit, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Etapa buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Etapa obj) {
		// TODO Auto-generated method stub
		
	}

}
