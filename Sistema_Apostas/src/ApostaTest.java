import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ApostaTest {

	/**
	 * Iniciar uma objeto Aposta para ser ultilizado de exemplo para outros arquivos do sistema
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		Aposta apostaExemplo = new Aposta("Coisinha", 100, 1);
	}

	@Test
	public void inicializarSucesso() {
		new Aposta("Axel", 1, 0);
	}
	
	@Test(expected=NullPointerException.class)
	public void inicializarNomeNulo() {
		new Aposta(null, 1, 1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void inicializarNomeInvalido(){
		new Aposta("", 1, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void inicializarQuantidadeNegativa(){
		new Aposta("A", -1, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void inicializarQuantidadeLimite(){
		new Aposta("A", 0, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void inicializarPrevisaoLimite1(){
		new Aposta("A", 0, 2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void inicializarPrevisaoLimite2(){
		new Aposta("A", 0, -1);
	}
	
	//Falta os teste de exibição
	
}
