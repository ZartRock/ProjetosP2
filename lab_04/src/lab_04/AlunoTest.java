package lab_04;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlunoTest {

	@Test
	public void criarAlunoSucesso() {
		new Aluno("Exemplo", "111", "Sociologia");
	}

	@Test(expected = NullPointerException.class)
	public void instanciarNomeNulo() {
		new Aluno(null, "111", "Ciência");
	
	}
	
	@Test(expected = NullPointerException.class)
	public void instanciarMatriculaNula() {
		new Aluno("Bob", null, "Computacao");

	}
	
	@Test(expected = NullPointerException.class)
	public void instanciarCursoNulo() {
		new Aluno("Noob", "333", null);

	}
	
	@Test(expected = NullPointerException.class)
	public void instanciarValoresNulos() {
		new Aluno(null, null, null);

	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void instanciarNomeInvalido() {
		new Aluno("", "222", "Filosofia");
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void instanciarMatriculaInvalida() {
		new Aluno("Bob", "", "Arquitetura");
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void instanciarCursoInvalido() {
		new Aluno("Noob", "555", "");

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void instanciarValoresInvalidos() {
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
