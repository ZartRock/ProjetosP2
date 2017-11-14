import java.util.Scanner;



/**
 * Classe principal do projeto por onde o sistema deverá ser inicializado pela JVM.
 * 
 * @author Áxel Medeiros
 */
/**
* Representação de um estudante matriculado da UFCG, especificamente de
* computação. Todo aluno precisa ter uma matrícula e é identificado unicamente
* por esta matrícula.
*
* @author Áxel Medeiros
*/
public class AgendaMain {

	private static Scanner input = new Scanner(System.in);;

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		boolean parar = false;
		do {
			exibirMenu();
			System.out.print("opcao> ");
			String opcao = input.nextLine();
			switch (opcao) {
			case "C":
				cadastrarContato(agenda);
				break;

			case "L":
				agenda.listarContatos();
				break;

			case "E":
				escolherContato(agenda);
				break;

			case "S":
				parar = true;
				break;

			default:
				System.out.println();
				System.out.println("OPÇÃO INVÁLIDA!");
				break;
			}
		} while (parar == false);

	}

	/**
	 * Exibe o menu do sistema
	 */

	private static void exibirMenu() {
		System.out.println();
		System.out.println("(C)adastrar Contato");
		System.out.println("(L)istar Contatos");
		System.out.println("(E)xibir Contato");
		System.out.println("(S)air");
		System.out.println();
	}

	/**
	 * Representa a ação de receber os dados posicao, nome, sobrenome referentes a um contato
	 * e cadastar na agenda.
	 * 
	 * @param agenda
	 *            representa o objeto instanciado agenda.
	 */
	private static void cadastrarContato(Agenda agenda) {
		String nome, sobrenome, telefone;

		System.out.print("Posição: ");
		int posicao = input.nextInt();
		input.nextLine();

		System.out.print("Nome: ");
		nome = input.nextLine();

		System.out.print("Sobrenome: ");
		sobrenome = input.nextLine();

		System.out.print("Telefone: ");
		telefone = input.nextLine();

		try {
			boolean Cadastrorealizado = agenda.cadastrarContato(telefone, nome,
					sobrenome, posicao);

			if (Cadastrorealizado) {
				System.out.println("CONTATO CADASTRADO!\n");
			}
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (UnsupportedOperationException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Representa a ação de receber a posicao de um contato e exibi-lo na tela
	 * 
	 * @param agenda
	 *            representa o objeto instanciado agenda.
	 */

	private static void escolherContato(Agenda agenda) {
		System.out.print("Contato>");
		int posicao = input.nextInt();
		input.nextLine();
		try {
			System.out.println(agenda.pesquisarContato(posicao));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}
}
