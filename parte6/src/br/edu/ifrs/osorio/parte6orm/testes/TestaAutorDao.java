package br.edu.ifrs.osorio.parte6orm.testes;

import br.edu.ifrs.osorio.parte6orm.model.Ideia;
import br.edu.ifrs.osorio.parte6orm.persistencia.AutorDAO;
import br.edu.ifrs.osorio.parte6orm.persistencia.IdeiaDAO;

public class TestaAutorDao {
	public static void main(String[] args) {
		IdeiaDAO idao = new IdeiaDAO();
		AutorDAO adao = new AutorDAO();
		
		Ideia i = idao.buscar(1);
		System.out.println(i);
		
		//var autores = adao.listaPorIdeia(i);
		
		//System.out.println(autores);
	}
}
