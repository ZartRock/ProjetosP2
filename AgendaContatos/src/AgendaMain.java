
import java.util.Scanner;

public class AgendaMain {


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		boolean parar = false;
		do {
			System.out.print("opcao> ");
			String opcao = input.nextLine();
			switch (opcao) {
			case "MENU":
				exibirMenu();
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

}
