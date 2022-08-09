package listaLigada;

public class TesteLista {
	public static void main(String[] args) {
		ListaEncadeada<Integer> lista = new ListaEncadeada<>();
		
		lista.add(10);
		lista.add(8);
		lista.add(9);
		lista.add(0);
		lista.add(1000);

		int tam = lista.size();
		for(int i=0;i<tam;i++){
			System.out.println(lista.get(i));
		}
			
	}
}
