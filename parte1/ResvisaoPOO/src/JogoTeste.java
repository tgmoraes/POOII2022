import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class JogoTeste {
	public static void main(String[] args) {
		var j = new Jogo("Super orientador a Objetos 2","IFéRS",
				LocalDate.of(2021,7,25));
		var ggEasy = new Jogo("jogo facil","IFéRS",
				LocalDate.of(2020,7,26));
		var j1 = new Jogo("Super orientador a Objetos 2 beta","IFéRS",
				LocalDate.of(2021,7,25));
		var j2 = new Jogo("Dio of War","Santo Cebolinha ex tu diz",
				LocalDate.of(2022,7,25));
		
		var jogos = new ArrayList<Jogo>();
		jogos.add(j);
		jogos.add(j1);
		jogos.add(ggEasy);
		jogos.add(j2);
		System.out.println("------ DEsordenado-----");
		System.out.println(jogos);
		
		Collections.sort(jogos);
		System.out.println("------ OOrdenado-----");
		
		System.out.println(jogos);
		
		
//		System.out.println(j);
	}
}

