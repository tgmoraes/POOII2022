package lambdas;

public class TesteFuncional {
	
	//método que usa prog funcional
	private static <T> T func(Funcional<T> func, T op1, T op2) {
		return (T) func.doisParaUm(op1, op2);
	}
	
	public static void main(String[] args) {
		//FORMA 1------ Não utilizar
		//forma inicial 
				
		System.out.println(func(new Anonima(), 5,6));
		// e se eu quisesse utilizar para Strings? 
		//teria que criar outra classe...
		//evoluindo para instanciar classe anonima declarando só o necessário
		//(como é feito por baixo dos panos)
		
		
		//FORMA 2------ Não utilizar mais depois do Java 8 
		System.out.println(func( new Funcional<String>() {
			@Override
			public String doisParaUm(String op1, String op2) {
				return op1+ " $$ "+op2;
			}
			
		},"ola", " mundo1!"));
		//ainda sim dificil de ler e muito longo
		
		
		//melhorando com lambdas:
		//FORMA 3------ Não utilizar
		Funcional<Double> lambda = (op1, op2) -> {
			return op1+op2;
		};
		System.out.println(func(lambda, 2.4, 4.5));
		//ou mais direto:
		
		//FORMA 4------ Formato recomendável
		System.out.println(func( (a, b) -> a+b, "Ola ","Mundo2!"));
		
		
	}
}
