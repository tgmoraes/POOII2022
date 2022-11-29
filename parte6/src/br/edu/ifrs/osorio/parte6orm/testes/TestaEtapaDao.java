package br.edu.ifrs.osorio.parte6orm.testes;

import br.edu.ifrs.osorio.parte6orm.model.Etapa;
import br.edu.ifrs.osorio.parte6orm.model.Ideia;
import br.edu.ifrs.osorio.parte6orm.model.Urgencia;
import br.edu.ifrs.osorio.parte6orm.persistencia.EtapaDAO;

public class TestaEtapaDao {
	public static void main(String[] args) {
		EtapaDAO edao = new EtapaDAO();
		Etapa e = new Etapa("etapa 3");
		// criando uma ideia que será utilizado apenas o id para o insert 
		// (os outros valores da ideia não serão utilizados...) 
		e.setIdeia(new Ideia(1, "","",Urgencia.ALTA));
		edao.inserir(e);
	}
}
