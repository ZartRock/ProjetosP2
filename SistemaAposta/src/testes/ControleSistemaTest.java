package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import sistema.ControleSistema;

/**
 * Classe reponsável por fazer os testes de "ControleSistema".
 * 
 * @author Áxel Medeiros
 */
public class ControleSistemaTest {

	private ControleSistema exemplo;

	public void setUp() {
		this.exemplo = new ControleSistema(0.01, 100);
		this.exemplo.cadastrarCenario("Vai chover hoje");
		this.exemplo.adicionarApostaCenario(1, "Áxel", 10, "VAI ACONTECER");
	}
	/**
	 * Realiza um teste de inicialização normal do sistema
	 */
	@Test
	public void inicializarSucesso() {
		new ControleSistema(0.01, 100);
	}
	/**
	 * Testa uma inicialização do sistema com uma porcentagem abusiva(>=100%).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void inicializarPorcentagemAbusiva() {
		new ControleSistema(1, 100);
	}
	/**
	 * Testa uma inicialização com a porcentagem negativa
	 */
	@Test(expected = IllegalArgumentException.class)
	public void inicializarPorcentagemNegativa() {
		new ControleSistema(-0.1, 100);
	}
	
	
	



}
