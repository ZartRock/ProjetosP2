package lab_04;

import java.util.Scanner;

/**
 * Classe reponsável por iniciar o sistema de Controle de Alunos.
 * 
 * @author Áxel Crispim e Medeiros
 *
 */
public class MainSistema {

	private static Scanner input;
	private static ControleSistema sistema = new ControleSistema();
	
	
	public static void main(String[] args) {
		input = new Scanner(System.in);

		imprimirMenu();

		boolean continuar = true;
		while (continuar) {
			System.out.print("Opcao> ");
			String opcao = input.nextLine();
			switch (opcao) {
			case "C":
				cadastrarAlunos();
				break;

			case "E":
				consultarAluno();
				break;

			case "N":
				cadastrarGrupos();
				break;

			case "A":
				System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
				String escolha = input.nextLine();
				if (escolha.equals("A")) {
					alocarAlunos();
				} else if (escolha.equals("I")) {
					imprimirGrupo();
				}
				break;

			case "R":
				adicionarAlunoRespondeuQuadro();
				break;

			case "I":
				imprimirQuestoesQuadro();
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

	/**
	 * Realizaçao a impressão do MENU
	 */
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

	/**
	 * Representa a consulta de um aluno no sistema
	 */
	private static void consultarAluno() {
		System.out.print("Matrícula: ");
		String matricula = input.nextLine();

		try {
			System.out.println(sistema.consultarAluno(matricula));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}

	}

	/*
	 * Representa o cadastro do Aluno no sistema
	 */
	private static void cadastrarAlunos() {
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

	/*
	 * Representa o cadastro do grupo no sistema atual.
	 */
	private static void cadastrarGrupos() {
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

	/*
	 * Representa a alocação de um aluno em um sistema.
	 */
	private static void alocarAlunos() {
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

	/*
	 * Representa a operação de registrar que um aluno respondeu no quadro no
	 * sistema.
	 */
	private static void adicionarAlunoRespondeuQuadro() {
		System.out.print("Matrícula: ");
		String matriculaAluno = input.nextLine();

		try {
			sistema.adicionarAlunoRespondeuQuadro(matriculaAluno);

			System.out.println("ALUNO REGISTRADO!");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Representa a impressão dos alunos que responderam no quadro.
	 */
	private static void imprimirQuestoesQuadro() {
		try {
			System.out.println(sistema.imprimirQuestoesQuadro());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Representa a impressão da representação de um grupo específico no sistema.
	 */
	private static void imprimirGrupo() {
		System.out.print("Grupo: ");
		String nomeGrupo = input.nextLine();
		try {
			String saida = sistema.imprimirGrupo(nomeGrupo);

			System.out.println(saida);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
