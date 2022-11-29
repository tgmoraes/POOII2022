package br.edu.ifrs.osorio.parte6orm.model;

public class Etapa {
	private Integer id;
	private final String nome;
	//mapeia uma associação de muitos para um 
	private Ideia ideia;
	
	public Etapa( String nome) {
		this.nome = nome;
		id=null;
	}
	public Etapa(int id, String nome) {
		this(nome);
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public Ideia getIdeia() {
		return ideia;
	}
	public void setIdeia(Ideia ideia) {
		this.ideia = ideia;
	}
	@Override
	public String toString() {
		return "Etapa (" + id + "): " + nome ;
	}
}
