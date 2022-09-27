package parte4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
import java.time.temporal.TemporalUnit;

public class TestaCon {
	public static void main(String[] args)  {
		ConBD tc = new ConBD();
		System.out.println(tc.getConexao());
		System.out.println(tc.getLinha(2));
		
		
		Duration in = Duration.ofSeconds(90);	//1:30
		Duration in2 = Duration.ofSeconds(156);	//2:36
		Duration soma = in.plus(in2);			//4:06
		
		System.out.println(in.plus(in2));
		System.out.println("total de segundos:"+in2.toSeconds());
		System.out.println("segundos descontados os minutos:"+in2.toSecondsPart());
		//passando para uma string bonita
		String intText = String.format("%d:%02d",soma.toMinutesPart(),soma.toSecondsPart());
		System.out.println(intText);
		//verificando se o período é negativo
		System.out.println(in.isNegative());	//false
		
		System.out.println((int)(Math.random()*10+5));
	}
}
