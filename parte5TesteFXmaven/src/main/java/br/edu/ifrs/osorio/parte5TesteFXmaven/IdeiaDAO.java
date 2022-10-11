package br.edu.ifrs.osorio.parte5TesteFXmaven;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class IdeiaDAO {

	public void inserir(Ideia ideia) {
		if (ideia.getId() != null)
			throw new RuntimeException("Objeto já salvo no BD");

		String sql = "INSERT INTO ideia (\"titulo\", \"descricao\", \"urgencia\") VALUES (?,?,?)";

		try (Connection c = FabricaConexao.getConexao(); 
			 var pstm = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, ideia.getTitulo());
			pstm.setString(2, ideia.getDescricao());
			pstm.setInt(3, ideia.getUrgencia().value);
			pstm.execute();
			ResultSet res = pstm.getGeneratedKeys();
			if (res.next()) {
				ideia.setId(res.getInt("id"));
			}
			res.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void deletar(Integer id) {
		if (id == null)
			throw new RuntimeException("objeto (transiente) não representa uma linha no banco de dados");
		String sql = "DELETE FROM \"ideia\" WHERE \"id\" =?";

		try (Connection c = FabricaConexao.getConexao(); var pstm = c.prepareStatement(sql)) {
			pstm.setInt(1, id);
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Ideia> listar(int limit, int offset) {
		String sql = "SELECT \"id\", \"titulo\", \"descricao\", \"urgencia\" FROM ideia LIMIT ? OFFSET ?";
		List<Ideia> ideias = new ArrayList<Ideia>();
		try (Connection c = FabricaConexao.getConexao(); var pstm = c.prepareStatement(sql)) {
			pstm.setInt(1, limit);
			pstm.setInt(2, offset);
			ResultSet res = pstm.executeQuery();
			while (res.next()) {
				int id = res.getInt("id");
				String desc = res.getString("descricao");
				String tit = res.getString("titulo");
				Urgencia ur = Urgencia.getType(res.getInt("urgencia"));
				ideias.add(new Ideia(id, desc, tit, ur));
			}
			res.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return ideias;
	}
	
	public Ideia buscar(Integer id) {
		String sql = "SELECT \"id\", \"titulo\", \"descricao\", \"urgencia\" FROM ideia WHERE \"id\"= ? ";
		Ideia ret = null;
		try (Connection c = FabricaConexao.getConexao(); var pstm = c.prepareStatement(sql)) {
			pstm.setInt(1, id);
			ResultSet res = pstm.executeQuery();
			while (res.next()) {
				int i = res.getInt("id");
				String desc = res.getString("descricao");
				String tit = res.getString("titulo");
				Urgencia ur = Urgencia.getType(res.getInt("urgencia"));
				ret = new Ideia(i, desc, tit, ur);
			}
			res.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return ret;
		
	}
	
	public void alterar(Ideia ideia) {
		if (ideia.getId() == null)
			throw new RuntimeException("Objeto não salvo no BD");

		String sql = "UPDATE \"ideia\" SET  \"titulo\" = ?, \"descricao\" =?, \"urgencia\"=? WHERE \"id\"=?";

		try (Connection c = FabricaConexao.getConexao(); var pstm = c.prepareStatement(sql)) {
			pstm.setString(1, ideia.getTitulo());
			pstm.setString(2, ideia.getDescricao());
			pstm.setInt(3, ideia.getUrgencia().value);
			pstm.setInt(4, ideia.getId());
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void salvar(Ideia i) {
		if(i.getId()==null) this.inserir(i); 
		else this.alterar(i);
	}
}




