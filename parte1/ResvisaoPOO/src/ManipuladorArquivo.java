import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManipuladorArquivo {

	private final Path pathArquivo;

	public ManipuladorArquivo() {
		this.pathArquivo = Paths.get("arquivo.csv");

		if (!Files.exists(this.pathArquivo)) {
			try {
				Files.createFile(pathArquivo);
			} catch (IOException exception) {
				throw new RuntimeException(exception);
//            	System.out.println("Erro na crição do arquivo: " + exception.getMessage());
			}
		}
	}

	public boolean insert(Jogo jogo) {
		String linha = jogo.paraCSV()+"\n";
		try {
			Files.writeString(pathArquivo, linha, StandardOpenOption.APPEND);
			return true;
		} catch (IOException exception) {
			System.out.println("Erro ao inserir jogo no arquivo: " + exception.getMessage());
		}
		return false;
	}

	public Jogo get(int indexLinha) throws LinhaNaoEncontradaException {
		try {
			BufferedReader leitor = Files.newBufferedReader(this.pathArquivo, StandardCharsets.UTF_8);
			int linhaAtual = 1;
			String linha = leitor.readLine();

			while (linha != null) {

				if (linhaAtual == indexLinha) {
					return converteLinhaEmJogo(linha);
				}

				linha = leitor.readLine();
				linhaAtual++;
			}

		} catch (IOException exception) {
			System.out.println("Erro na leitura do arquivo: " + exception.getMessage());
		}

		throw new LinhaNaoEncontradaException();
	}

	public boolean delete(int indexLinha) throws LinhaNaoEncontradaException {

		try {
			List<String> linhas = Files.readAllLines(this.pathArquivo, StandardCharsets.UTF_8);

			if (linhas.size() <= (indexLinha - 1) || indexLinha < 1) {
				throw new LinhaNaoEncontradaException();
			}

			linhas.remove(indexLinha - 1);

			Files.write(this.pathArquivo, linhas);
			return true;

		} catch (IOException exception) {
			System.out.println("Erro ao ler as linhas do arquivo!!!");
		}

		return false;
	}

	public List<Jogo> list() {
		var ret = new ArrayList<Jogo>();
		List<String> linhas = new ArrayList<>();

		try {
			linhas = Files.readAllLines(this.pathArquivo, StandardCharsets.UTF_8);
		} catch (IOException exception) {
			System.out.println("Erro Ao Ler Linhas do Arquivo!!!");
		}

		for (String linha : linhas) {
			ret.add(this.converteLinhaEmJogo(linha));
		}
		return ret;
	}
	
	public void update(Jogo j, int indexLinha) {
		try {
			List<String> linhas = Files.readAllLines(this.pathArquivo, StandardCharsets.UTF_8);

			if (linhas.size() <= (indexLinha - 1) || indexLinha < 1) {
				throw new LinhaNaoEncontradaException();
			}

			linhas.remove(indexLinha - 1);
			linhas.add(indexLinha-1, j.paraCSV());

			Files.write(this.pathArquivo, linhas);
		
		} catch (IOException exception) {
			System.out.println("Erro ao ler as linhas do arquivo!!!");
		}

		
	}

	public Jogo converteLinhaEmJogo(String linha){
        String[] dadosSeparados = linha.split(";");
        String[] diasData = dadosSeparados[2].split("/");

        return new Jogo(dadosSeparados[0], dadosSeparados[1], LocalDate.of(
        		Integer.parseInt(diasData[2]), Integer.parseInt(diasData[1]), 
        		Integer.parseInt(diasData[0])));
     }

}