package lab_04;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QuestoesQuadroTest {

	@Test
	public void test() {
		new QuestoesQuadro();
	}
	
	@Test
	public void numAlunosCadastradosZero() {
		QuestoesQuadro q1 = new QuestoesQuadro();
		assertEquals(0, q1.numAlunosCadastrados());
	}
	
	@Test
	public void numAlunosCadastradosAleatorio() {
		QuestoesQuadro q2 = new QuestoesQuadro();
		int numAleatorio = (int) (100 * Math.random());
		adicionarAlunoExemplo(q2, numAleatorio);
		
		assertEquals(numAleatorio, q2.numAlunosCadastrados());
	}
	
	@Test
	public void toStringTestVazio() {
		QuestoesQuadro q3 = new QuestoesQuadro();
		QuestoesQuadro q4 = new QuestoesQuadro();
		adicionarAlunoExemplo(q3,2);
		adicionarAlunoExemplo(q4,2);
		
		assertEquals(q3.toString(), q4.toString());
	}
	
	
	
	private void adicionarAlunoExemplo(QuestoesQuadro q, int numVezes) {
		for (int i = 0; i < numVezes; i++) {
			q.adicionarAluno(new Aluno("Exemplo", "1", "CC"));
		}
		
	}
	
}
