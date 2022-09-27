package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TesteStreams {

	// Exercício: por fim, crie um Stream que processe o arquivo da seguinte
	// maneira:
	// retorne uma List<Pessoa> com as pessoas com nomes compostos por ao menos
	// 2 palavras e do sexo masculino. Essa lista deve estar com os nomes em
	// maiúsculo.

	public static void exemploStreamInt() {
		List<Integer> nums = Arrays.asList(2, 10, 8, 9, 5, 6, 23);
		
		System.out.println(nums);
		
		List<Integer> l2=nums.stream() // criar o stream
				.skip(1) // pular os dois primeiros elementos
				.filter(y -> y%2==0 ) // todos pares
				.limit(2)
				.map(elem -> +elem*elem)
				.collect(Collectors.toList());// transforma o stream em lista
		System.out.println(l2);
		
		nums.stream() // criar o stream
				.skip(1) // pular os dois primeiros elementos
				.filter(y -> y%2==0 ) // todos pares
				.limit(2)
				.map(elem -> +elem*elem)
				.forEach(System.out::println);// transforma o stream em lista
	}

	public static void main(String[] args) throws IOException {
		//exemploStreamInt();
		
		Path arq = Paths.get("dados", "dados.txt");
//
		// printando as linhas
		Files.lines(arq).
			forEach(System.out::println);
		List<Pessoa> pessoas = Files.lines(arq).
				map(linha -> Pessoa.fromLine(linha)).
				collect(Collectors.toList());
		System.out.println(pessoas);
		System.out.println("--------------------");

		// transforma para Pessoa
		// filtra mulheres:
		// filtra nomes com "of"
		// transforma para Lista<Pessoa>
		List<Pessoa> listaBonita = Files.lines(arq)
				.map(l -> Pessoa.fromLine(l))
				.filter(p -> p.getSexo() == Sexo.FEMININO)
				.filter(p -> p.getNome().contains("of"))
				.collect(Collectors.toList());

		listaBonita.stream().forEach(System.out::println);
		System.out.println("--------------------");
		
		//otimizando o stream (reduzindo o máximo o seu tamanho antes
		List<Pessoa> listaOtimizada = Files.lines(arq)
				.filter(linha -> linha.split(";")[1].contains("of"))
				.filter(linha -> linha.split(";")[2].equals(Sexo.FEMININO))
				.map(l -> Pessoa.fromLine(l))
				.collect(Collectors.toList());
		
		listaBonita.stream().forEach(System.out::println);
		listaOtimizada.stream().forEach(System.out::println);

		System.out.println("--------------------");
		
		// pessoa com o máximo ID
		Optional<Pessoa> maximo = Files.lines(arq)
				.map(l -> Pessoa.fromLine(l))
				.max((p1, p2) -> Integer.compare(p1.getId(), p2.getId()));

		if (maximo.isPresent())
			System.out.println(maximo.get());

		System.out.println("--------------------");

		// get pelo id
		int id = 2;

		Optional<Pessoa> pes = Files.lines(arq)
				.filter(l -> Integer.parseInt(l.split(";")[0]) == id)
				.map(l -> Pessoa.fromLine(l)).findFirst();
		if (pes.isPresent())
			System.out.println(pes.get());
	}
}
