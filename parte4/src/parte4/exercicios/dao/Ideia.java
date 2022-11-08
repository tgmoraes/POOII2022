package parte4.exercicios.dao;

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

	public Integer getId() {
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

	
	@Override
	public String toString() {
		return "("+this.id+") - "+this.titulo+": "+this.descricao+ "[prioridade: "+this.urgencia+"]"; 
	}
	
	
}
