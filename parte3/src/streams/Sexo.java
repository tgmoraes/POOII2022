package streams;

public enum Sexo {
	MASCULINO('m'), FEMININO('f');
	public char valor;
	private Sexo(char sexo) {
		this.valor = sexo;
	}
}