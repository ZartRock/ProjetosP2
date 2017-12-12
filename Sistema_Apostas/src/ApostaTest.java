import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ApostaTest {
	
	static Aposta apostaExemplo;
	
	/**
	 * Iniciar uma objeto Aposta para ser ultilizado de exemplo para outros arquivos do sistema
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		apostaExemplo = new Aposta("Coisinha", 100, 1);
	}
	
	/**
	 * Testa a inicialização com todos os parametros corretos
	 */
	@Test
	public void inicializarSucesso() {
		new Aposta("Axel", 1, 0);
	}
	
	/**
	 * Testa a inicialização com o nome nulo.
	 */
	@Test(expected=NullPointerException.class)
	public void inicializarNomeNulo() {
		new Aposta(null, 1, 1);
	}
	
	/**
	 * Testa a inicialização com o nome inválido
	 */
	@Test(expected=IllegalArgumentException.class)
	public void inicializarNomeInvalido(){
		new Aposta("", 1, 0);
	}
	
	/**
	 * Testa a construção com o argumento "Quantidade" sendo negativa
	 */
	@Test(expected=IllegalArgumentException.class)
	public void inicializarQuantidadeNegativa(){
		new Aposta("A", -1, 0);
	}
	
	/**
	 * Testa o caso limite onde a quantia é 0.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void inicializarQuantidadeLimite(){
		new Aposta("A", 0, 0);
	}
	
	/**
	 * Testa o caso limite onde a previsão é 2, acima do limite.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void inicializarPrevisaoLimite1(){
		new Aposta("A", 0, 2);
	}
	/**
	 * Testa o caso limite onde a previsão é -1, abaixo do limite;
	 */
	@Test(expected=IllegalArgumentException.class)
	public void inicializarPrevisaoLimite2(){
		new Aposta("A", 0, -1);
	}
	
	/**
	 * Testa a saída da classe está correta
	 */
	@Test
	public void toStringTestAutomatico() {
		Aposta aposta2 = new Aposta("Coisinha", 100, 1);
		assertEquals(aposta2.toString(), apostaExemplo.toString());
	}
	
	
}
