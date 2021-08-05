package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author nazareno andrade
 * @author Alfredo Vasconcelos
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo.
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 *
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.print(
				"\n(C)adastrar Contato\n" +
						"(L)istar Contatos\n" +
						"(E)xibir Contato\n" +
						"(F)avoritos\n" +
						"(A)dicionar Favorito\n" +
						"(T)ags\n" +
						"(M)uda Telefone\n" +
						"(R)emove Tag\n" +
						"(D)esfavoritar\n" +
						"(Z)erar Conato\n" +
						"(P)esquisar por nome\n" +
						"(B)uscar por sobrenome\n" +
						"(V)asculha por tag\n" +
						"(S)air\n" +
						"\n" +
						"Opção> ");
		return scanner.nextLine().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 *
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
			case "C" -> cadastraContato(agenda, scanner);
			case "L" -> listaContatos(agenda);
			case "E" -> exibeContato(agenda, scanner);
			case "F" -> listaFavoritos(agenda);
			case "A" -> favoritar(agenda, scanner);
			case "T" -> adicionaTag(agenda, scanner);
			case "M" -> editaTelefone(agenda, scanner);
			case "R" -> removeTag(agenda, scanner);
			case "D" -> desfavoritar(agenda, scanner);
			case "Z" -> zerarContato(agenda, scanner);
			case "P" -> pesquisarNome(agenda, scanner);
			case "B" -> buscarSobrenome(agenda, scanner);
			case "V" -> vasculhaTag(agenda, scanner);
			case "S" -> System.exit(0);
			default -> System.out.println("Opção inválida!");
		}
	}

	/**
	 * Cadastra um contato como favorito na agenda.
	 *
	 * @param agenda  A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void favoritar(Agenda agenda, Scanner scanner) {
		System.out.print("Contato> ");
		int contato = Integer.parseInt(scanner.nextLine());

		System.out.print("Posição> ");
		int posicao = Integer.parseInt(scanner.nextLine());
		System.out.println(agenda.favoritar(contato, posicao));
	}

	/**
	 * Remover um contato da lista de favoritos.
	 *
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void desfavoritar(Agenda agenda, Scanner scanner) {
		System.out.print("Posição favoritada> ");
		int posicaoFav = Integer.parseInt(scanner.nextLine());
		System.out.println(agenda.desfavorita(posicaoFav));
	}

	/**
	 * Imprime lista de contatos da agenda.
	 *
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		System.out.print(agenda.getContatos());
	}

	/**
	 * Imprime lista de contatos favoritos da agenda.
	 *
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaFavoritos(Agenda agenda) {
		System.out.print(agenda.getFavoritos());
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda.
	 *
	 * @param agenda  A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("Contato> ");
		int posicaoContato = Integer.parseInt(scanner.nextLine());
		String contato = agenda.getContato(posicaoContato);
		System.out.println("\n" + contato);
	}

	/**
	 * Cadastra um contato na agenda.
	 *
	 * @param agenda  A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição> ");
		int posicao = Integer.parseInt(scanner.nextLine());

		if (posicao > 0 && posicao <= 100) {
			System.out.print("Nome> ");
			String nome = scanner.nextLine().trim();

			if (!nome.equals("")) {
				System.out.print("Sobrenome> ");
				String sobrenome = scanner.nextLine().trim();

				System.out.print("Telefone> ");
				String telefone = scanner.nextLine().trim();

				if (!telefone.equals(" ")){
					System.out.println(agenda.cadastraContato(posicao, nome, sobrenome, telefone));
				} else {
					System.out.println("CONTATO INVALIDO");
				}

			} else {
				System.out.println("CONTATO INVALIDO");
			}
		} else {
			System.out.println("POSIÇÃO INVÁLIDA");
		}
	}

	/**
	 * Cadastra uma tag a um contato da agenda.
	 *
	 * @param agenda  A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void adicionaTag(Agenda agenda, Scanner scanner) {
		System.out.print("Contato(s)> ");
		String[] contatos = scanner.nextLine().split(" ");

		System.out.print("Tag> ");
		String tag = scanner.nextLine().trim();

		System.out.print("Posicao> ");
		int posicao = Integer.parseInt(scanner.nextLine());

		agenda.setTag(contatos, tag, posicao);
	}

	/**
	 * Remove uma tag de uma posição de um contato.
	 * @param agenda  A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void removeTag(Agenda agenda, Scanner scanner) {
		System.out.print("Contato> ");
		int posicaoContato = Integer.parseInt(scanner.nextLine());

		System.out.print("Posição da tag> ");
		int posicaoTag = Integer.parseInt(scanner.nextLine());
		System.out.print(agenda.rmTag(posicaoContato,posicaoTag));
	}

	/**
	 * Edita o telefone de um contato
	 * @param agenda  A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void editaTelefone(Agenda agenda, Scanner scanner) {
		System.out.print("Contato> ");
		int posicaoContato = Integer.parseInt(scanner.nextLine());

		System.out.print("Telefone> ");
		String telefone = scanner.nextLine().trim();
		agenda.editaTelefone(posicaoContato,telefone);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados.
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}

	/**
	 * Remove um contato da agenda.
	 * @param agenda  A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void zerarContato(Agenda agenda, Scanner scanner) {
		System.out.print("Contato> ");
		int contato = Integer.parseInt(scanner.nextLine());
		System.out.println(agenda.zerarContato(contato));
	}

	/**
	 * Imprime lista de contatos da agenda com mesmo sobrenome.
	 *
	 * @param agenda A agenda sendo manipulada.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void buscarSobrenome(Agenda agenda, Scanner scanner) {
		System.out.print("Nome> ");
		String sobrenome = scanner.nextLine().trim();

		System.out.println(agenda.pesquisaSobrenome(sobrenome));
	}

	/**
	 * Imprime lista de contatos da agenda com mesmo nome.
	 *
	 * @param agenda A agenda sendo manipulada.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void pesquisarNome(Agenda agenda, Scanner scanner) {
		System.out.print("Sobrenome> ");
		String nome = scanner.nextLine().trim();

		System.out.println(agenda.pesquisaNome(nome));
	}

	/**
	 * Imprime lista de contatos da agenda com a mesma tag.
	 *
	 * @param agenda A agenda sendo manipulada.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void vasculhaTag(Agenda agenda, Scanner scanner) {
		System.out.print("Tag> ");
		String tag = scanner.nextLine().trim();

		System.out.println(agenda.pesquisaTag(tag));
	}
}