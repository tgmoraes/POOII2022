package parte4.exercicios.dao;

import parte4.exercicios.Urgencia;

public class TesteIdeia {
	public static void main(String[] args) {
		IdeiaDAO idao = new IdeiaDAO();
		
		Ideia semideia = new Ideia("Sem ideia", "meus amiguinhos mudos ou desviando o assunto e nao me ajudam!", Urgencia.BAIXA);
		idao.inserir(semideia);
		System.out.println(semideia);
		semideia.setUrgencia(Urgencia.MEDIA);
		semideia.setTitulo("sabe deus né?");
		semideia.setDescricao("que nada, só estão querendo ir pra casa logo, mas são bem legais! e além do mais, nao querem nem saber!");
		idao.alterar(semideia);
		Ideia nova = idao.buscar(semideia.getId());
		
		System.out.println(nova);
		var ideias = idao.listar(10, 0);
		ideias.stream().forEach(System.out::println);
		
	}
}
