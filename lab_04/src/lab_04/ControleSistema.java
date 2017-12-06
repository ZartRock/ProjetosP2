package lab_04;

import java.util.HashMap;

/**
 * Representação do Controle de um Sistema academico que interliga todas as
 * funcionalidade do projeto.
 * 
 * @author Áxel Medeiros
 */

public class ControleSistema {
	HashMap<String, Aluno> todosAlunos;
	HashMap<String, GrupoEstudo> gruposEstudos;
	QuestoesQuadro quadro;

	/**
	 * Representa a construção do Controle do Sitema.
	 */

	public ControleSistema() {
		this.todosAlunos = new HashMap<>();
		this.gruposEstudos = new HashMap<>();
		this.quadro = new QuestoesQuadro();
	}

	/**
	 * Representa a operação de cadastrar alunos no sistema.
	 * 
	 * @param matricula
	 *            Representa a matricula de um aluno.
	 * @param nome
	 *            Representa o nome de um aluno.
	 * @param curso
	 *            Representa o curso de um determinado aluno.
	 * 
	 * @return Retorna um boolean representando o sucesso ou não da operação.
	 */

	public boolean cadastrarAluno(String matricula, String nome, String curso) {
		if (this.todosAlunos.containsKey(matricula)) {
			return false;
		}
		this.todosAlunos.put(matricula, new Aluno(nome, matricula, curso));
		return true;
	}

	/**
	 * Representa a operação de consulta das principais informaçẽos do aluno, como
	 * matricula, nome, curso.
	 * 
	 * @param matricula
	 *            representa a matrícula de um aluno.
	 * @return Retronar a representação deste aluno em um String.
	 */

	public String consultarAluno(String matricula) {
		try {
			return todosAlunos.get(matricula).toString();

		} catch (NullPointerException e) {
			throw new NullPointerException("Aluno não cadastrado.");
		}

	}

	/**
	 * Representa a operação de cadastra de um novo grupo de estudo.
	 * 
	 * @param nomeGrupo
	 *            Representa o nome do grupo em questão.
	 * @return Retorna um boolean se a operação foi um sucesso ou não.
	 */

	public boolean cadastrarGrupo(String nomeGrupo) {
		
		if (this.gruposEstudos.containsKey(nomeGrupo.toUpperCase())) {
			return false;
		}

		this.gruposEstudos.put(nomeGrupo.toUpperCase(), new GrupoEstudo(nomeGrupo));
		return true;
	}

	/**
	 * Representa a alocação de um aluno em determinado grupo de estudo.
	 * 
	 * @param matriculaAluno
	 *            Representa a matrícula de um aluno.
	 * @param nomeGrupo
	 *            Representa o nome do grupo em questão.
	 * 
	 * @return Retorna se o aluno pode ser alocado em um grupo ou não. Caso não,
	 *         este pode ser representado por um operação inválida ou o aluno já
	 *         está cadastrado no grupo.
	 */

	public boolean alocarAlunos(String matriculaAluno, String nomeGrupo) {
		nomeGrupo = nomeGrupo.toUpperCase();
		
		if (!this.todosAlunos.containsKey(matriculaAluno)) {
			throw new IllegalArgumentException("Aluno não cadastrado.");
		} else if (!this.gruposEstudos.containsKey(nomeGrupo)) {
			throw new IllegalArgumentException("Grupo não cadastrado.");
		}

		Aluno aluno = this.todosAlunos.get(matriculaAluno);
		return this.gruposEstudos.get(nomeGrupo).alocarParticipante(aluno);

	}

	/**
	 * Retorna a representação de um Grupo em uma string.
	 * 
	 * @param nomeGrupo
	 *            representa o nome do grupo
	 * @return uma String com a representação do grupo
	 * @throws Exception 
	 */

	public String imprimirGrupo(String nomeGrupo) throws Exception {
		nomeGrupo = nomeGrupo.toUpperCase();
		
		if (!this.gruposEstudos.containsKey(nomeGrupo)) {
			throw new Exception("Grupo não cadastrado.");
		} else if(this.gruposEstudos.get(nomeGrupo).getNumParticipantes() == 0) {
			throw new Exception("Grupo sem nenhum participante cadastrado.");
		}

		return this.gruposEstudos.get(nomeGrupo).toString();
	}

	/**
	 * Representa o registro do aluno que respondeu o quadro
	 * 
	 * @param matriculaAluno
	 *            representa a matricula do aluno a ser registrado.
	 */

	public void adicionarAlunoRespondeuQuadro(String matriculaAluno) {
		if (!this.todosAlunos.containsKey(matriculaAluno)) {
			throw new IllegalArgumentException("Aluno não cadastrado.");
		}

		Aluno aluno = this.todosAlunos.get(matriculaAluno);
		this.quadro.adicionarAluno(aluno);
	}

	/**
	 * Retorna um representação dos Alunos que responderam questões no quadro
	 * 
	 * @return uma string com a representação de QuestoesQuadro
	 * @throws Exception
	 *             lança a exceção com um mensagem caso nenhum aluno foi cadastrado.
	 */

	public String imprimirQuestoesQuadro() throws Exception {
		if (quadro.numAlunosCadastrados() == 0) {
			throw new Exception("Nenhum cadastro realizao");
		}

		return quadro.toString();
	}

}
