
public class TestaPacote {
	private static void printa(Pacote<? extends Number> pacote) {
		System.out.println(pacote.getConteudo());
	}

	public static void main(String[] args) {
		Pacote<String> pac1 = new Pacote<>();

		pac1.setConteudo("Olá");
		System.out.println(pac1.getConteudo());

		Pacote<Double> pac2 = new Pacote<>();
		pac2.setConteudo(5.0);
		// pac2.setConteudo("oi"); //erro de compilação
		System.out.println(pac2.getConteudo());
		// String v1 = pac2.getConteudo(); //erro de compilação
		String v2 = pac1.getConteudo();
		System.out.println(v2);

		printa(pac2);
		// printa(pac1); da erro!

		PacoteObj pac = new PacoteObj();
		pac.setConteudo("hello");
		// pac.setConteudo(45.6);
		String var1 = (String) pac.getConteudo(); // possivel erro de execução
		System.out.println(var1);

	}
}
