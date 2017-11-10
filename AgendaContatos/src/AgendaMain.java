import java.util.Scanner;

public class AgendaMain {

	private static Scanner input = new Scanner(System.in);;

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		boolean parar = false;
		do {
			System.out.print("opcao> ");
			String opcao = input.nextLine();
			switch (opcao) {
			case "MENU":
				exibirMenu();
				break;

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
				exibirMenu();
				break;
			}
		} while (parar == false);

	}

	private static void exibirMenu() {
		System.out.println();
		System.out.println("(C)adastrar Contato");
		System.out.println("(L)istar Contatos");
		System.out.println("(E)xibir Contato");
		System.out.println("(S)air");
		System.out.println();
	}

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

		agenda.cadastrarContato(nome, sobrenome, telefone, posicao);
	}
	
	private static void escolherContato(Agenda agenda){
		System.out.print("Contato>");
		int posicao = input.nextInt();
		input.nextLine();

		agenda.pesquisarContato(posicao);
	}
}
