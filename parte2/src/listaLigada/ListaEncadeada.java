package listaLigada;

public class ListaEncadeada<T> {
	private int tamanho;
	private No inicio;
	private No fim;
	
	public ListaEncadeada(){
		this.tamanho =0;
		this.inicio=null;
		this.fim=null;
	}
	//adiciona no final
	public void add(T info) {
		No nodoAux = new No(info);
		//lista vazia
		if(this.inicio==null) this.inicio = nodoAux;
		else this.fim.prox = nodoAux;
		
		this.fim = nodoAux;
		this.tamanho++;
	}
	//retorna elemento na Pos
	public T get(int pos) {
		if(pos<0 || pos> this.tamanho-1)
			throw new IllegalArgumentException("Posição da lista inválida!");
		No aux = this.inicio;
		int cont=0;
		while(aux != null && cont!=pos) {
			cont++;
			aux= aux.prox;
		}
		return aux.info;
	}
	
	public int size() {
		return this.tamanho;
	}
	//classe interna
	private class No {
		T info;
		No prox;
		No(T informacao){
			this.info = informacao;
			this.prox = null;
		}
	}

}
