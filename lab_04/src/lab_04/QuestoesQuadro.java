package lab_04;

import java.util.ArrayList;

/**
 * Representa uma classe que contém a ordem de todos os alunos que foram ao
 * quadro responder questões.
 * 
 * @author Áxel Medeiros
 * 
 */

public class QuestoesQuadro {
	ArrayList<Aluno> responderamQuadro;

	/**
	 * Constroi um objeto do tipo QuestoesQuadro com uma lista vazia dos alunos que responderam no quadro.
	 */
	
	public QuestoesQuadro() {
		this.responderamQuadro = new ArrayList<>();
	}
	
	/**
	 * Retorna o número de alunos já foram ao quadro.
	 * @return um int que representa o número de alunos já responderam questões no quadro.
	 */
	public int numAlunosCadastrados() {
		return this.responderamQuadro.size();
	}
	
	/**
	 * Representa a operação de adicionar uma novo aluno a lista dos que responderam questões.
	 * @param aluno Representa o aluno a ser adicionado no sistema
	 */
	
	public void adicionarAluno(Aluno aluno) {
		this.responderamQuadro.add(aluno);
	}
	
	/**
	 * Retorna uma representçaão em String de todos alunos que foram responder no quadro.
	 * 
	 * @return um String no formato:
	 * 			"Alunos:"
	 * 			"1. aluno1"
	 * 			"2. aluno2"
	 */
	
	@Override
	public String toString() {
		String saida = "Alunos:" + "\n";
		for (int i = 0; i < responderamQuadro.size(); i++) {
			saida += (i + 1) + ". " + responderamQuadro.get(i).toString()
					+ "\n";
		}

		return saida.trim();
	}
}
