package lab_04;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * Classe responsável por testar as funcionalidade de GrupoEstudo
 * 
 * @author Áxel Medeiros
 *
 */

public class GrupoEstudoTest {

	/**
	 * Testa um caso de sucesos na criação de um objeto de Grupo de Estudo
	 */
	
	@Test
	public void criarGrupoEstudoSucesso() {
		new GrupoEstudo("Matemática Discreta");
	}

	/**
	 * Testa o caso da tentativa de instancia um objeto com valores nulos
	 */
	
	@Test(expected = NullPointerException.class)
	public void instanciarValoresNulos() {
		new GrupoEstudo(null);

	}

	/**
	 * Testa o caso de instaciar um objeto com valores inválidos
	 */
	
	@Test(expected = IllegalArgumentException.class)
	public void instanciarValoresInvalidos() {
		new GrupoEstudo("");
	}

	/**
	 * Testa o caso de exibir um grupo de Estudos vazio.
	 */
	
	@Test
	public void toStringTestVazio() {
		GrupoEstudo g1 = fazerGrupoEstudoBasico();
		GrupoEstudo g2 = fazerGrupoEstudoBasico();
		assertEquals(g2.toString(), g1.toString());
		assertEquals("Grupo: Teoria dos Grafos\n" + "\n" + "Alunos do grupo Teoria dos Grafos:", g1.toString());
	}

	/**
	 * Testa o caso de exibir um GrupoEstudo com cadastros
	 */
	
	public void toStringTestComCadastros() {
		GrupoEstudo grupo1 = new GrupoEstudo("Calculo II");
		GrupoEstudo grupo2 = new GrupoEstudo("Calculo II");
		alocarParticipantes(grupo1);
		alocarParticipantes(grupo2);
		assertEquals(grupo1.toString(), grupo2.toString());

	}

	/**
	 * Testa o caso de verficar se dois grupos com nomes iguais sao iguais
	 */
	
	public void equalsTest() {
		GrupoEstudo exemplo1 = new GrupoEstudo("Exemplo");
		GrupoEstudo exemplo2 = new GrupoEstudo("Exemplo");
		alocarParticipantes(exemplo2);

		assertEquals(exemplo1, exemplo2);
	}

	/**
	 * Metódo responsável por criar um objeto básico GrupoEstudo
	 * 
	 * @return um objeto tipo GrupoEstudo.
	 */
	
	private GrupoEstudo fazerGrupoEstudoBasico() {
		return new GrupoEstudo("Teoria dos Grafos");
	}

	/**
	 * Metodo responsável por alocar participantes no grupo de estudo.
	 * 
	 * @param g
	 *            representa a referencia a um objeto GrupoEstudo.
	 */
	
	private void alocarParticipantes(GrupoEstudo g) {
		g.alocarParticipante(new Aluno("A", "1", "CC"));
		g.alocarParticipante(new Aluno("B", "2", "EE"));
	}

}
