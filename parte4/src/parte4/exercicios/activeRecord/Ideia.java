package parte4.exercicios.activeRecord;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import parte4.exercicios.FabricaConexao;
import parte4.exercicios.Urgencia;

public class Ideia {
	private Integer id;
	private String descricao;
	private String titulo;
	private Urgencia urgencia;

	public Ideia( String descricao, String titulo, Urgencia urgencia) {
		this.descricao = descricao;
		this.titulo = titulo;
		this.urgencia = urgencia;
		id = null;
	}
	public Ideia(int id, String descricao, String titulo, Urgencia urgencia) {
		this(descricao, titulo, urgencia);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Urgencia getUrgencia() {
		return urgencia;
	}

	public void setUrgencia(Urgencia urgencia) {
		this.urgencia = urgencia;
	}

	// inserir(): o método grava no banco de dados o objeto de ideia (na tabela
	// Ideia
	// cada ideia será representa por uma linha na tabela Ideia).
	public void inserir() {
		if(this.id!=null)
			throw new RuntimeException("Objeto já salvo no BD");
		
		String sql = "INSERT INTO ideia (\"titulo\", \"descricao\", \"urgencia\") VALUES (?,?,?) RETURNING id";

		try (Connection c = FabricaConexao.getConexao(); var pstm = c.prepareStatement(sql)) {
			pstm.setString(1, this.titulo);
			pstm.setString(2, this.descricao);
			pstm.setInt(3,this.urgencia.value);
			ResultSet res = pstm.executeQuery();
			if (res.next()) {
				this.id = res.getInt("id");
			}
			res.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	// deletar(): o método deleta a ideia do banco (considere o filtro feito pelo
	// id)

	public void deletar() {
		if(id==null) 
			throw new RuntimeException("objeto (transiente) não representa uma linha no banco de dados");
		String sql = "DELETE FROM \"ideia\" WHERE \"id\" =?";

		try (Connection c = FabricaConexao.getConexao(); var pstm = c.prepareStatement(sql)) {
			pstm.setInt(1, this.id);
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	// listar(): método estático que lê os dados do BD e para cada linha cria um
	// objeto de Ideia com os seus campos (atributos) preenchidos e o adiciona a um
	// List de Ideias que será retornado pelo método.
	public static List<Ideia> listar(int limit, int offset){
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
				ideias.add( new Ideia(id, desc, tit,ur));
			}
			res.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return ideias;
	}
	@Override
	public String toString() {
		return "("+this.id+") - "+this.titulo+": "+this.descricao+ "[prioridade: "+this.urgencia+"]"; 
	}
}
