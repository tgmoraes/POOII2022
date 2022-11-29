package br.edu.ifrs.osorio.parte6orm.model;

import java.time.LocalDate;

public class Autor {
	private Integer id;
	private final String nome;
	private final LocalDate dataNascimento;
	
	public Autor( String nome, LocalDate dataNascimento) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		id= null;
	}
	public Autor(int id, String nome, LocalDate dataNascimento) {
		this(nome,dataNascimento);
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	@Override
	public String toString() {
		return String.format("[%d]nome: %s, dt:%d/%d/%d", 
				this.id, this.nome, this.dataNascimento.getDayOfMonth(),
				this.dataNascimento.getMonthValue(),
				this.dataNascimento.getYear());
	}
	
}
