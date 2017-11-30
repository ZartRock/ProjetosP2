package lab_04;

import java.util.ArrayList;

public class QuestoesQuadro {
	ArrayList<Aluno> responderamQuadro;

	public int numAlunosCadastrados() {
		return this.responderamQuadro.size();
	}

	public QuestoesQuadro() {
		this.responderamQuadro = new ArrayList<>();
	}

	public void adicionarAluno(Aluno aluno) {
		this.responderamQuadro.add(aluno);
	}
	
	@Override
	public String toString() {
		String saida = "Alunos:" + "\n";
		for (int i = 0; i < responderamQuadro.size(); i++) {
			saida += i + ". " + responderamQuadro.toString() + "\n";
		}
		
		return saida.trim();
	}
}
