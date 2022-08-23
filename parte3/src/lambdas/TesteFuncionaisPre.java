package lambdas;

import java.time.LocalDate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TesteFuncionaisPre {
	public static void main(String[] args) {
		
		// utilizando Interfaces genéricas do Java: util.function
		// interface com um método - apply() que processa dois valores em um
		BinaryOperator<String> op1 = (x, y) -> x + y;
		System.out.println(op1.apply("ola", " mundo 1!"));
		
		
		//aplica uma operação em um elemento: metodo accept
		//accept recebe valor e processa, retorna void
		Consumer<String> op2 = x -> System.out.println(x);
		op2.accept("olá mundo 2!");
		
		//utilizando referencias de métodos:
		Consumer<String> op3 = System.out::println;
		op3.accept("olá mundo 3!");
		
		Supplier<LocalDate> op = LocalDate::now;
		System.out.println(op.get());
	}
}
