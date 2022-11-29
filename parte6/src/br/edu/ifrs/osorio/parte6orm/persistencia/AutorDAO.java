package br.edu.ifrs.osorio.parte6orm.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifrs.osorio.parte6orm.model.Autor;
import br.edu.ifrs.osorio.parte6orm.model.Ideia;
import br.edu.ifrs.osorio.parte6orm.model.Urgencia;

public class AutorDAO implements DAO<Autor>{

	@Override
	public void inserir(Autor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Autor> listar(int limit, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Autor buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Autor obj) {
		// TODO Auto-generated method stub
		
	}

	public List<Autor> listaPorIdeia(Ideia i){
		String sql = 
				"SELECT a.id, a.nome, a.datanascimento FROM ideia i \n"
				+ "	JOIN autorideia ai ON ai.idideia = i.id\n"
				+ "	JOIN autor a ON a.id=ai.idautor\n"
				+ "	WHERE i.id =?";
		List<Autor> autores = new ArrayList<>();
		try (Connection c = FabricaConexao.getConexao(); var pstm = c.prepareStatement(sql)) {
			pstm.setInt(1, i.getId());
			ResultSet res = pstm.executeQuery();
			while (res.next()) {
				int id = res.getInt("id");
				String nome = res.getString("nome");
				LocalDate dataNasc = res.getObject("datanascimento", LocalDate.class);
				autores.add(new Autor(id, nome, dataNasc));
			}
			res.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return autores;
	}
	
}
