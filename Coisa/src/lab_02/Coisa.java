package lab_02;

import java.util.Scanner;

/**
* Classe principal do projeto, onde seu objetivo é inicar a execução do
* projeto Controle Institucional da Situação Acadêmica (COISA).
* 
* @author Áxel Medeiros
*/

public class Coisa {

	private static Scanner input;

	/**
	   * Metodo principal do programa onde seu objetivo é iniciar
	   * a execução do mesmo.
	   *
	   *@param args String[] representando a entrada de parametros de forma
	   *direta para o programa.
	 */
	
	public static void main(String[] args) {
    	imprimirMenu();
    	
		input = new Scanner(System.in);
    	
    	int x = 1;
        do {
        	String operacao = input.nextLine();
        	
        	switch (operacao) {
			case "CRIAR_ALUNO":
				System.out.println("Digite o nome Aluno:");
				String nome = input.nextLine();
				Aluno fulano = new Aluno(nome);
				System.out.println(fulano);
				break;
			
			case "CANTINA":
				break;
				
			case "MENU":
				imprimirMenu();
				break;
				
			default:
				System.out.println("A opção desejada não está disponível no sistema, " +
						"por favor, digite novamente.");
				imprimirMenu();
				break;
			}
			
		} while (x == 1);
    }
	
	/**
	   * Imprimir as opções disponíveis no menu do programa.
	   *
	 */
	
	private static void imprimirMenu(){
		System.out.println("Opções do Menu:");
		System.out.println("	CANTINA");
		System.out.println("	CRIAR ALUNO");
		System.out.println("	MENU");

	}

}