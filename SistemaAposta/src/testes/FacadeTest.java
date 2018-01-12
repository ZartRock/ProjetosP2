package testes;

import org.junit.Test;
import sistema.Facade;

/**
 * Classe responsável por fazer os testes de "Facade".
 * 
 * @author Áxel Medeiros
 */
public class FacadeTest {
	/**
	 * Realiza a inicialização normal do Facede
	 */
	@Test
	public void inicializarSucesso() {
		new Facade();
	}
}
