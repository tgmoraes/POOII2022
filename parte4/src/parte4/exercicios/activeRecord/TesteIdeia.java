package parte4.exercicios.activeRecord;

import parte4.exercicios.Urgencia;

public class TesteIdeia {
	public static void main(String[] args) {
		Urgencia u = Urgencia.ALTA;
		
		Urgencia u1 = Urgencia.valueOf("ALTA");
		
		System.out.println(u.value);
		System.out.println(u1.value);
		
		
		var ideias = Ideia.listar(1, 1);
		ideias.stream().forEach(System.out::println);
		
	}
}
