import java.util.List;
import java.util.Scanner;

public class Main {

	public static int pegaOpcaoMenu() {
		Scanner entrada = new Scanner(System.in);

		System.out.println("Cadastro de Jogos: ");
		System.out.println("(0) - Sair.");
		System.out.println("(1) - Inserir Jogo.");
		System.out.println("(2) - Listar Jogos.");
		System.out.println("(3) - Buscar Jogo.");
		System.out.println("(4) - Deletar Jogo.");
		System.out.println("(5) - Alterar Jogo.");

		System.out.println();
		System.out.print("Digite a Escolha Desejada: ");
		int opcaoMenu = entrada.nextInt();
		entrada.nextLine();

		return opcaoMenu;
	}

	public static void inserirJogo() {
		Scanner entrada = new Scanner(System.in);
		ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();

		String nomeJogo;
		String nomeEmpresa;
		String dataLancamento;

		System.out.println("cadastro de jogo: ");

		while (true) {
			System.out.print("Primeiro Digite O Nome do Jogo: ");
			nomeJogo = entrada.nextLine();

			if (nomeJogo.length() > 3) {
				break;
			}

			System.out.println("O nome deve ter ao menos 3 letras para ser válido!!!");
		}

		while (true) {
			System.out.print("Agora, Digite o Nome da Empresa que fez o Jogo: ");
			nomeEmpresa = entrada.nextLine();

			if (nomeEmpresa.length() > 3) {
				break;
			}

			System.out.println("O nome da empresa deve ter ao menos 3 letras para ser válido!!!");
		}

		while (true) {
			System.out.print(
					"É necessário que você informe a data de lançamento do jogo conforme o especificado abaixo: ");
			System.out.println("Ex: 31/12/2022");
			System.out.print("Data de Lançamento: ");
			dataLancamento = entrada.nextLine();

			if (dataLancamento.length() == 10 && dataLancamento.charAt(2) == '/' && dataLancamento.charAt(5) == '/') {

				break;
			}

			System.out.println("O nome da empresa deve ter ao menos 3 letras para ser válido!!!");
		}

		Jogo novoJogo = manipuladorArquivo
				.converteLinhaEmJogo((nomeJogo + ";" + nomeEmpresa + ";" + dataLancamento + ";"));
		manipuladorArquivo.insert(novoJogo);

		System.out.println("Jogo Inserido Com Sucesso!!!");

	}

	public static void listarJogos() {
		ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();

		List<Jogo> jogos = manipuladorArquivo.list();
		int contadorLinha = 1;

		System.out.println();

		for (Jogo jogo : jogos) {
			System.out.println("Linha: " + contadorLinha + ". Nome: " + jogo.getNome() + ". Criadora: "
					+ jogo.getEmpresa() + ". Data de Lançamento: " + jogo.getDataLancamento().getDayOfMonth() + "/"
					+ jogo.getDataLancamento().getMonthValue() + "/" + jogo.getDataLancamento().getYear());

			contadorLinha++;
		}

		System.out.println("Jogos Listados: " + jogos.size() + " jogos\n");

	}

	public static void listarJogosBuscaOuDelecao() {
		ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();

		List<Jogo> jogos = manipuladorArquivo.list();
		for (int i = 0; i < jogos.size(); i++) {
			System.out.println("Linha: " + (i + 1) + " Nome: " + jogos.get(i).getNome());
		}
	}

	public static void buscarJogo() {
		Scanner entrada = new Scanner(System.in);
		ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();

		listarJogosBuscaOuDelecao();

		System.out.print("\nDigite o Numero da Linha do Jogo que deseja Buscar: ");
		int indexJogo = entrada.nextInt();
		entrada.nextLine();

		try {
			Jogo jogoBuscado = manipuladorArquivo.get(indexJogo);

			System.out.println(
					"\nJogo Encontrado: " + "Nome: " + jogoBuscado.getNome() + ". Criadora: " + jogoBuscado.getEmpresa()
							+ ". Data de Lançamento: " + jogoBuscado.getDataLancamento().getDayOfMonth() + "/"
							+ jogoBuscado.getDataLancamento().getMonthValue() + "/"
							+ jogoBuscado.getDataLancamento().getYear() + "\n");

		} catch (LinhaNaoEncontradaException exception) {
			System.out.println("Linha de Jogo Não Encontrada!!!");
		}
	}

	public static void deletarJogo() {
		Scanner entrada = new Scanner(System.in);
		ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();

		listarJogosBuscaOuDelecao();

		System.out.print("\nDigite o Numero da Linha do Jogo que deseja Deletar: ");
		int indexJogo = entrada.nextInt();
		entrada.nextLine();

		try {
			boolean jogoDeletado = manipuladorArquivo.delete(indexJogo);

			if (!jogoDeletado) {
				System.out.println("Erro ao deletar o jogo desejado!!!");

			} else {
				System.out.println("Jogo deletado com sucesso!!!");

			}

		} catch (LinhaNaoEncontradaException exception) {
			System.out.println("Linha de Jogo Não Encontrada!!!");
		}
	}

	public static void main(String[] args) {

		int opcaoMenuPrincipal = -1;

		while (true) {

			opcaoMenuPrincipal = pegaOpcaoMenu();

			if (opcaoMenuPrincipal == 0) {
				break;

			} else if (opcaoMenuPrincipal == 1) {
				inserirJogo();

			} else if (opcaoMenuPrincipal == 2) {
				listarJogos();

			} else if (opcaoMenuPrincipal == 3) {
				buscarJogo();

			} else if (opcaoMenuPrincipal == 4) {
				deletarJogo();

			} else if (opcaoMenuPrincipal == 5) {
				alterarJogo();

			}

		}

		System.out.println("Até Mais... \\_(0o0)_/");

	}

	private static void alterarJogo() {
		Scanner entrada = new Scanner(System.in);
		ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();

		listarJogosBuscaOuDelecao();

		System.out.print("\nDigite o Numero da Linha do Jogo que deseja Alterar: ");
		int indexJogo = entrada.nextInt();
		entrada.nextLine();

		String nomeJogo;
		String nomeEmpresa;
		String dataLancamento;

		System.out.println("alterando jogo: ");

		System.out.print("Primeiro Digite O Nome do Jogo: ");
		nomeJogo = entrada.nextLine();

		System.out.print("Agora, Digite o Nome da Empresa que fez o Jogo: ");
		nomeEmpresa = entrada.nextLine();

		System.out.print(
					"É necessário que você informe a data de lançamento do jogo conforme o especificado abaixo: ");
			System.out.println("Ex: 31/12/2022");
			System.out.print("Data de Lançamento: ");
			dataLancamento = entrada.nextLine();

		Jogo novoJogo = manipuladorArquivo
				.converteLinhaEmJogo((nomeJogo + ";" + nomeEmpresa + ";" + dataLancamento + ";"));
		manipuladorArquivo.update(novoJogo,indexJogo);

		System.out.println("Jogo Alterado Com Sucesso!!!");

	}
}
