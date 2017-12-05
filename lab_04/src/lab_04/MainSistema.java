package lab_04;

import java.util.Scanner;

public class MainSistema {

	private static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);

		ControleSistema sistema = new ControleSistema();
		imprimirMenu();
		
		boolean continuar = true;
		while (continuar) {
			System.out.print("Opcao> ");
			String opcao = input.nextLine();
			switch (opcao) {
			case "C":
				cadastrarAlunos(sistema);
				break;

			case "E":
				consultarAluno(sistema);
				break;

			case "N":
				cadastrarGrupos(sistema);
				break;

			case "A":
				System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
				String escolha = input.nextLine();
				if (escolha.equals("A")) {
					alocarAlunos(sistema);
				} else if (escolha.equals("I")) {
					imprimirGrupo(sistema);
				}
				break;

			case "R":
				adicionarAlunoRespondeuQuadro(sistema);
				break;

			case "I":
				imprimirQuestoesQuadro(sistema);
				break;

			case "O":
				continuar = false;
				break;

			default:
				System.out.println("Opção inválida, por favor, digite novamente");
				System.out.println();
				imprimirMenu();
				break;

			}

			System.out.println();
		}

	}

	private static void imprimirMenu() {
		System.out.println("(C)adastrar Aluno");
		System.out.println("(E)xibir Aluno");
		System.out.println("(N)ovo Grupo");
		System.out.println("(A)locar Aluno no Grupo e Imprimir Grupos");
		System.out.println("(R)egistrar Resposta de Aluno");
		System.out.println("(I)mprimir Alunos que Responderam");
		System.out.println("(O)ra, vamos fechar o programa!");
		System.out.println();
	}

	private static void consultarAluno(ControleSistema sistema) {
		System.out.print("Matrícula: ");
		String matricula = input.nextLine();

		try {
			System.out.println(sistema.consultarAluno(matricula));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void cadastrarAlunos(ControleSistema sistema) {
		System.out.print("Matrícula: ");
		String matricula = input.nextLine();

		System.out.print("Nome: ");
		String nome = input.nextLine();

		System.out.print("Curso: ");
		String curso = input.nextLine();

		try {
			boolean resultado = sistema.cadastrarAluno(matricula, nome, curso);

			if (resultado) {
				System.out.println("CADASTRO REALIZADO!");
			} else {
				System.out.println("MATRÍCULA JÁ CADASTRADA!");
			}
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void cadastrarGrupos(ControleSistema sistema) {
		System.out.print("Grupo: ");
		String nomeGrupo = input.nextLine();

		try {
			boolean resultado = sistema.cadastrarGrupo(nomeGrupo);

			if (resultado) {
				System.out.println("CADASTRO REALIZADO!");
			} else {
				System.out.println("GRUPO JÁ CADASTRADO!");
			}
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void alocarAlunos(ControleSistema sistema) {
		System.out.print("Matrícula: ");
		String matriculaAluno = input.nextLine();

		System.out.print("Grupo: ");
		String nomeGrupo = input.nextLine();

		try {
			boolean resultado = sistema.alocarAlunos(matriculaAluno, nomeGrupo);

			if (resultado) {
				System.out.println("ALUNO ALOCADO!");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void adicionarAlunoRespondeuQuadro(ControleSistema sistema) {
		System.out.print("Matrícula: ");
		String matriculaAluno = input.nextLine();
		
		try {
			sistema.adicionarAlunoRespondeuQuadro(matriculaAluno);
			
			System.out.println("ALUNO REGISTRADO!");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void imprimirQuestoesQuadro(ControleSistema sistema) {
		try {
			System.out.println(sistema.imprimirQuestoesQuadro());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void imprimirGrupo(ControleSistema sistema) {
		System.out.print("Grupo: ");
		String nomeGrupo = input.nextLine();
		try {
			String saida = sistema.imprimirGrupo(nomeGrupo);
			
			System.out.println(saida);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}



}




