package livraria;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestaApp {
	static double nota = 0;

	static void printaGrupoTeste(ArrayList<Boolean> testes, String titulo, double peso) {
		System.out.print("conjunto de testes - " + titulo + ": ");
		int acertos = 0;
		for (boolean teste : testes) {
			if (teste) {
				System.out.print("o");
				acertos++;
			} else {
				System.out.print("x");
			}
		}
		double notaGrupo = acertos * peso / testes.size();
		System.out.println(" - " + acertos + "/" + testes.size() + "(" + notaGrupo + ")");
		nota += notaGrupo;
	}

	public static void main(String[] args) {
		ArrayList<Boolean> t1 = new ArrayList<>();
		ArrayList<Boolean> t2 = new ArrayList<>();
		ArrayList<Boolean> t3 = new ArrayList<>();
		ArrayList<Boolean> t4 = new ArrayList<>();

		Livro l1 = new Livro("O Senhor dos anéis - A Sociedade do Anel", LocalDate.of(1954, 5, 24), 468,
				"J. R. R. Tolkien");
		Livro l1Copy = new Livro("O Senhor dos anéis - A Sociedade do Anel", LocalDate.of(1954, 5, 24), 468,
				"J. R. R. Tolkien");
		Livro l1CopyComErro = new Livro("O Senhor dos anéis - A Sociedade do Anel", LocalDate.of(1954, 5, 24), 468,
				"J. R. R. Tolkie");

		Livro l2 = new Livro("Sistema de Banco de Dados", LocalDate.of(2012, 1, 1), 754, "Abraham Silberschatz",
				"Henry F. Korth", "S. Sudarshan");
		String saidaEsperada = "Livro: Sistema de Banco de Dados (2012) - 754 "+
			"paginas - Autores: Abraham Silberschatz, Henry F. Korth, S. Sudarshan";
		//testes da classe Livro
		t1.add(l2.toString().equals(saidaEsperada)); //testa toString (deve retornar String no molde esperado)
		t1.add(l1.equals(l1Copy));					 //testa equals
		t1.add(!l1.equals(l1CopyComErro));			 //testa equals
		t1.add(l1 instanceof Publicacao);			 //testa herança
		t1.add(l2.getAutores()[1].equals("Henry F. Korth")); //testa getAutores
		t1.add(l1.getData().getDayOfYear()==144);			 //testa getData
		t1.add(l1.getPaginas()==468 && l1.getTitulo().equals("O Senhor dos anéis - A Sociedade do Anel")); //testa getters de paginas e titulo
		
		Revista r1 = new Revista("Superinteressante", LocalDate.of(2021, 3, 1), "Abril", 425);
		Revista r1Copy = new Revista("Superinteressante", LocalDate.of(2021, 3, 1), "Abril", 425);
		Revista r1CopyErro = new Revista("Superinteressante", LocalDate.of(2021, 2, 1), "Abril", 425);

		saidaEsperada = "Revista: Superinteressante (3/2021) - editora Abril - edicao n:425";
		//testes da classe Revista
		t2.add(r1.getEdicao()==425 && r1.getEditora().contentEquals("Abril")); 	//testa editora e edicao
		t2.add(r1 instanceof Publicacao);										//testa herança
		t2.add(r1.equals(r1Copy));												//testa equals
		t2.add(!r1.equals(r1CopyErro));											//testa equals
		t2.add(r1.toString().equals(saidaEsperada));							//testa toString
		
		//testes classes Impressão e Livraria
		saidaEsperada="exemplar: R0| Data impressao: 26/03/2024\n"+saidaEsperada; //troque pela data de hoje
		Livraria ccb = new Livraria("Chimas and Code books");
		Impressao revista1 = new Impressao(r1);
		t3.add(revista1.getCodigo().equals("R0"));
		System.out.println(revista1);
		t3.add(revista1.toString().equals(saidaEsperada)); //testa toString de Impressao
		t3.add(revista1.getPublicacao().equals(r1Copy));
		
		ccb.addEstoque(r1); 		//adiciona 1 exemplar de r1 -> cod:R1
		ccb.addEstoque(l1, 3);		//adiciona 3 exemplares de l1 -> cods:L2, L3 e L4
		ccb.addEstoque(l1);			//adiciona 1 exemplar de l1 -> cod:L5
		ccb.addEstoque(l2, 5);		//adiciona 5 exemplares de l2 -> cod:L6, L7, L8, L9 e L10

		t4.add(ccb.getExemplares(l1Copy)==4);	//quantas impressoes (cópias) no estoque do Livro "O Senhor dos Anéis - A Sociedade do Anel"
		t4.add(ccb.getExemplares(r1Copy)==1);		//quantas cópias da revista r1 em estoque
		t4.add(ccb.getExemplares(l2)==5);		//quantas cópias do livro l2 em estoque
		
		Impressao copiaR1 = ccb.vende(r1);
		Impressao copiaL2= ccb.vende(l2);
		copiaL2= ccb.vende(l2);
		t4.add(copiaL2.getCodigo().equals("L7"));			//testa código impressao
		t4.add(copiaL2.getData().equals(LocalDate.now()));	//testa data da entrada da cópia em estoque
		t4.add(ccb.getExemplares(l2)==3);					//estoque do livro l2 deve diminuir, pois duas cópias foram vendidas
		t4.add(ccb.vende(r1)==null);						// deve ser NULL pois sem itens de R1 em estoque
		t4.add(ccb.getExemplares(r1)==0);

		printaGrupoTeste(t1, "Livro", 1.5); // o --> acerto, x --> erro
		printaGrupoTeste(t2, "Revista", 1.25); // o --> acerto, x --> erro
		printaGrupoTeste(t3, "Impressao", 1.0); // o --> acerto, x --> erro
		printaGrupoTeste(t4, "Livraria", 3.25); // o --> acerto, x --> erro
		System.out.println("Nota Parcial: " + nota + "/7");
	}
}
