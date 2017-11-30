package lab_04;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.text.AbstractDocument.LeafElement;

public class ControleSistema {
	HashMap<String, Aluno> todosAlunos;
	HashMap<String, GrupoEstudo> gruposEstudos;
	QuestoesQuadro quadro;
	


	public ControleSistema() {
		this.todosAlunos = new HashMap<>();
		this.gruposEstudos = new HashMap<>();
		this.quadro = new QuestoesQuadro();
	}

	public boolean cadastrarAluno(String matricula, String nome, String curso) {
		if (this.todosAlunos.containsKey(matricula)) {
			return false;
		}
		this.todosAlunos.put(matricula, new Aluno(nome, matricula, curso));
		return true;
	}

	public String consultarAluno(String matricula) {
		try {
			return todosAlunos.get(matricula).toString();

		} catch (NullPointerException e) {
			throw new NullPointerException("Aluno não cadastrado.");
		}

	}

	public boolean cadastrarGrupo(String nomeGrupo) {
		try {
			if (this.gruposEstudos.containsKey(nomeGrupo)) {
				return false;
			}
			this.gruposEstudos.put(nomeGrupo.toUpperCase(), new GrupoEstudo(nomeGrupo));

			return true;
		} catch (NullPointerException e) {
			throw new NullPointerException(e.getMessage());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	public boolean alocarAlunos(String matriculaAluno, String nomeGrupo) {
		if (!this.todosAlunos.containsKey(matriculaAluno)) {
			throw new IllegalArgumentException("Aluno não cadastrado.");
		} else if (!this.gruposEstudos.containsKey(nomeGrupo)) {
			throw new IllegalArgumentException("Grupo não cadastrado.");
		}

		System.out.println("executou");
		Aluno aluno = this.todosAlunos.get(matriculaAluno);
		return this.gruposEstudos.get(nomeGrupo.toUpperCase()).alocarParticipante(aluno);

	}
	
	public String imprimirGrupo(String nomeGrupo) {
		if (!this.gruposEstudos.containsKey(nomeGrupo)) {
			throw new IllegalArgumentException("Grupo não cadastrado.");
		}
		
		return this.gruposEstudos.get(nomeGrupo).toString();
	}
	
	public void adicionarAlunoRespondeuQuadro(String matriculaAluno) {
		if (!this.todosAlunos.containsKey(matriculaAluno)) {
			throw new IllegalArgumentException("Aluno não cadastrado.");
		}
		
		Aluno aluno = this.todosAlunos.get(matriculaAluno);
		this.quadro.adicionarAluno(aluno);
	}
	
	public String imprimirQuestoesQuadro() {
		if (quadro.numAlunosCadastrados() == 0) {
			//Continuar Daqui
		}
		return quadro.toString();
	}

}
