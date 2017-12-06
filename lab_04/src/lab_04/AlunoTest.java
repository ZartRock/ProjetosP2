package lab_04;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Classe com o objetivo de testar as funcionalidades de Aluno
 * 
 * @author Áxel Medeiros
 *
 */
public class AlunoTest {

	/**
	 * Testa se a contrução está ocorrendo normalmente
	 */
	@Test
	public void criarAlunoSucesso() {
		new Aluno("Exemplo", "111", "Sociologia");
	}

	/**
	 * Testa a tentativa de instanciar com nome nulo
	 */
	@Test(expected = NullPointerException.class)
	public void instanciarNomeNulo() {
		new Aluno(null, "111", "Ciência");

	}

	/**
	 * Testa a tentativa de instanciar com matrícula nula.
	 */
	@Test(expected = NullPointerException.class)
	public void instanciarMatriculaNula() {
		new Aluno("Bob", null, "Computacao");

	}

	/**
	 * Testa a tentativa de instancia o curso nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void instanciarCursoNulo() {
		new Aluno("Noob", "333", null);

	}

	/**
	 * Testa a tentativa de instancia com todos os parametros nulos.
	 */
	@Test(expected = NullPointerException.class)
	public void instanciarValoresNulos() {
		new Aluno(null, null, null);

	}

	/**
	 * Testa a tentativa de instanciar com nome inválido
	 */
	@Test(expected = IllegalArgumentException.class)
	public void instanciarNomeInvalido() {
		new Aluno("", "222", "Filosofia");

	}

	/**
	 * Testa a tentativa de instanciar com matrícula inválida.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void instanciarMatriculaInvalida() {
		new Aluno("Bob", "", "Arquitetura");

	}

	/**
	 * Testa a tentativa de instancia o curso inválido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void instanciarCursoInvalido() {
		new Aluno("Noob", "555", "");

	}

	/**
	 * Testa a tentativa de instancia todos os valores inválidos
	 */
	@Test(expected = IllegalArgumentException.class)
	public void instanciarValoresInvalidos() {
		new Aluno("", "", "");

	}

	/**
	 * Testa se a representação em String está funcionando.
	 */
	@Test
	public void toStringTest() {
		Aluno a = fazerAlunoBasico();
		Aluno b = fazerAlunoBasico();
		assertEquals(a.toString(), b.toString());
		assertEquals("111222333 - Exemplo - Computação", a.toString());

	}

	/**
	 * Representa a instanciação de um Aluno com determinado parametros, para efeito
	 * de agilizar os testes
	 * 
	 * @return um objeto da classe Aluno
	 */
	private Aluno fazerAlunoBasico() {
		return new Aluno("Exemplo", "111222333", "Computação");
	}

}
