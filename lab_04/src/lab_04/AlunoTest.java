package lab_04;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlunoTest {

	@Test
	public void criarAlunoSucesso() {
		new Aluno("Exemplo", "111", "Sociologia");
	}

	@Test(expected = NullPointerException.class)
	public void instanciarValoresNulos() {
		new Aluno(null, "111", "Ciência");
		new Aluno("Bob", null, "Computacao");
		new Aluno("Noob", "333", null);
		new Aluno(null, null, null);

	}

	@Test(expected = IllegalArgumentException.class)
	public void instanciarValoresInvalidos() {
		new Aluno("", "222", "Filosofia");
		new Aluno("Bob", "", "Arquitetura");
		new Aluno("Steve", "333", "");
		new Aluno("", "", "");
	}

	@Test
	public void toStringTest() {
		Aluno a = fazerAlunoBasico();
		Aluno b = fazerAlunoBasico();
		assertEquals(a.toString(), b.toString());
		assertEquals("111222333 - Exemplo - Computação", a.toString());

	}

	private Aluno fazerAlunoBasico() {
		return new Aluno("Exemplo", "111222333", "Computação");
	}

}
