package lab_04;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Classe responsável por testar todas as funcionalidades de QuestoesQuadro
 * 
 * @author Áxel Medeiros
 *
 */
public class QuestoesQuadroTest {

	/**
	 * Testa se classe está podende ser instanciada
	 */
	@Test
	public void questoesQuadroTest() {
		new QuestoesQuadro();
	}

	/**
	 * Testa se a numAlunosCadastrados é zero.
	 */

	@Test
	public void numAlunosCadastradosZero() {
		QuestoesQuadro q1 = new QuestoesQuadro();
		assertEquals(0, q1.numAlunosCadastrados());
	}

	/**
	 * Testa se o numAlunoCadastrados é igual a um número aleatório entre 0 e 100.
	 */

	@Test
	public void numAlunosCadastradosAleatorio() {
		QuestoesQuadro q2 = new QuestoesQuadro();
		int numAleatorio = (int) (100 * Math.random());
		adicionarAlunoExemplo(q2, numAleatorio);

		assertEquals(numAleatorio, q2.numAlunosCadastrados());
	}

	/**
	 * Testa se a representaço do classe QuestoesQuadro é correta.
	 */

	@Test
	public void toStringTestVazio() {
		QuestoesQuadro q3 = new QuestoesQuadro();
		QuestoesQuadro q4 = new QuestoesQuadro();
		adicionarAlunoExemplo(q3, 2);
		adicionarAlunoExemplo(q4, 2);

		assertEquals(q3.toString(), q4.toString());
	}

	/**
	 * Metodo responsável por adicionar um número determinados de alunos na lista de
	 * Alunos da classe QuestoesQuadro
	 * 
	 * @param q representa o quadro onde será cadastrado os alunos
	 * @param numVezes representa o número de alunos a ser cadastrado 
	 */
	private void adicionarAlunoExemplo(QuestoesQuadro q, int numVezes) {
		for (int i = 0; i < numVezes; i++) {
			q.adicionarAluno(new Aluno("Exemplo", "1", "CC"));
		}

	}

}
