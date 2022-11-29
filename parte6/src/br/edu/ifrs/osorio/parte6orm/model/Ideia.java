package br.edu.ifrs.osorio.parte6orm.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Ideia {
	private Integer id;
	private String descricao;
	private String titulo;
	private Urgencia urgencia;
	
	//mapeia associação um para muitos
	private final List<Etapa> etapas;
	
	//mapeia associação muitos para muitos
	private final List<Autor> autores;
	
	public Ideia( String descricao, String titulo, Urgencia urgencia) {
		this.descricao = descricao;
		this.titulo = titulo;
		this.urgencia = urgencia;
		id = null;
		etapas = new ArrayList<Etapa>();
		autores = new ArrayList<Autor>();
	}
	public Ideia(int id, String descricao, String titulo, Urgencia urgencia) {
		this(descricao, titulo, urgencia);
		this.id = id;
	//	this.codigo = "cod:"+id;
	}
	
	
	public void addEtapa(Etapa e) {
		this.etapas.add(e);
	}
	public List<Etapa> getEtapas() {
		return this.etapas;
	}
	public Etapa getEtapa(int pos) {
		return this.etapas.get(pos);
	}

	public void addAutor(Autor a) {
		this.autores.add(a);
	}
	public List<Autor> getAutores() {
		return this.autores;
	}
	public Autor getAutor(int pos) {
		return this.autores.get(pos);
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
		return "("+this.id+") - "+this.titulo+": "+
				this.descricao+ "[prioridade: "+this.urgencia+"]"+
				"\n etapas:"+this.etapas.toString()+
				"\n autores:"+this.autores.toString(); 
	}
	public String getCodigo() {
		return "cod:"+id;
	}
//	public void setCodigo(String cod) {
//		this.codigo = cod;
//	}
}
