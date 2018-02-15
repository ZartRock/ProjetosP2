package testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import sistema.Facade;

/**
 * Classe responsável por fazer os testes de "Facade".
 * 
 * @author Áxel Medeiros
 */
public class FacadeTest {
	Facade facade = new Facade();
	
	
	@Before
	public void setup() {
		facade.inicializa(10000, 0.01);
		facade.cadastrarCenario("Azul é azul");
		facade.cadastrarAposta(1, "a", 100, "VAI ACONTECER");
		facade.cadastrarApostaSeguraValor(1, "b", 1000, "N VAI ACONTECER", 100, 100);
		facade.cadastrarApostaSeguraTaxa(1, "b", 1000, "N VAI ACONTECER", 0.1, 100);
	}
	
	/**
	 * Realiza a inicialização normal do Facede
	 */
	@Test
	public void inicializaSucesso() {
		facade.inicializa(100, 0.01);
	}
	
	/**
	 * Realiza os testes dos casos limites de inicializa.
	 */
	@Test
	public void inicializaCasosLimitesErros() {
		try {
			facade.inicializa(-1, 0.02);
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na inicializacao: Caixa nao pode ser inferior a 0", 
					     e.getMessage());
		}
		
		try {
			facade.inicializa(100, 0);
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na inicializacao: Taxa nao pode ser inferior a 0", e.getMessage());
		}
		
		try {
			facade.inicializa(100, 1); //TODO: Deveria dar outra mensagem
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na inicializacao: Taxa nao pode ser inferior a 0", e.getMessage());
		}
		
		
	}

	/**
	 *  Realiza os testes de cadastrarCenario.
	 */
	@Test
	public void cadastrarCenario() {
		
		
		try {
			facade.cadastrarCenario("");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de cenario: Descricao nao pode ser vazia", e.getMessage());
		}
		
		try {
			facade.cadastrarCenario("   ");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de cenario: Descricao nao pode ser vazia", e.getMessage());
		}
		
	}
	
	/**
	 * Realiza os testes de cadastrarCenarioBonus
	 */
	@Test
	public void cadastrarCenarioBonus() {
	
		try {
			facade.cadastrarCenario("jogar moeda", 0);
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de cenario: Bonus invalido", e.getMessage());
		}
		
	}
	
	/**
	 * Realiza os testes de cadastrarAposta
	 */
	@Test
	public void cadastrarAposta() {
		facade.cadastrarAposta(1, "axel", 100, "VAI ACONTECER");
		
		try {
			facade.cadastrarAposta(0, "axel", 100, "VAI ACONTECER");
		} catch (Exception e) {
			assertEquals("Erro no cadastro de aposta: Cenario invalido", e.getMessage());
		}
		
		try { //TODO: colocar caso limite
			facade.cadastrarAposta(100, "axel", 100, "VAI ACONTECER");
		} catch (Exception e) {
			assertEquals("Erro no cadastro de aposta: Cenario nao cadastrado", e.getMessage());
		}
		
		try {
			facade.cadastrarAposta(1, "", 100, "VAI ACONTECER");
		} catch (Exception e) {
			assertEquals("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo", e.getMessage());
		}
		
		try {
			facade.cadastrarAposta(1, "   ", 100, "");
		} catch (Exception e) {
			assertEquals("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo", e.getMessage());
		}
		
		try {
			facade.cadastrarAposta(1, "axel", 0, "");
		} catch (Exception e) {
			assertEquals("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero", e.getMessage());
		}
		
		try {
			facade.cadastrarAposta(1, "axel", 100, "");
		} catch (Exception e) {
			assertEquals("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula", e.getMessage());
		}
		
	}
	
	/**
	 * Realiza os testes de cadastrarApostaSeguraValor.
	 */
	@Test
	public void cadastrarApostaSeguraValor() {
		facade.cadastrarApostaSeguraValor(1, "a", 100, "VAI ACONTECER", 10, 20);
		
		try {
			facade.cadastrarApostaSeguraValor(0, "a", 100, "VAI ACONTECER", 10, 20);
		} catch (Exception e) {
			assertEquals("Erro no cadastro de aposta assegurada por valor: Cenario invalido", e.getMessage());
		}
		
		try {
			facade.cadastrarApostaSeguraValor(100, "a", 100, "VAI ACONTECER", 10, 20);
		} catch (Exception e) {
			assertEquals("Erro no cadastro de aposta assegurada por valor: Cenario invalido", e.getMessage());
		}
		
		try {
			facade.cadastrarApostaSeguraValor(1, "", 100, "VAI ACONTECER", 10, 20);
		} catch (Exception e) {
			assertEquals("Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo", e.getMessage());
		}
		
		try {
			facade.cadastrarApostaSeguraValor(1, "   ", 100, "VAI ACONTECER", 10, 20);
		} catch (Exception e) {
			assertEquals("Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo", e.getMessage());
		}
		
		try {
			facade.cadastrarApostaSeguraValor(1, "a", 0, "VAI ACONTECER", 10, 20);
		} catch (Exception e) {
			assertEquals("Erro no cadastro de aposta assegurada por valor: Valor nao pode ser menor ou igual a zero", e.getMessage());
		}
		
		try {
			facade.cadastrarApostaSeguraValor(1, "a", 100, "  ", 10, 20);
		} catch (Exception e) {
			assertEquals("Erro no cadastro de aposta assegurada por valor: Previsao nao pode ser vazia ou nula", e.getMessage());
		}
		
		
		try {
			facade.cadastrarApostaSeguraValor(1, "a", 100, "VAI ACONTECER", 0, 20);
		} catch (Exception e) {
			assertEquals("Valor não pode ser negativa ou nula", e.getMessage());
		}
		
		try {
			facade.cadastrarApostaSeguraValor(1, "a", 100, "VAI ACONTECER", 10, 0);
		} catch (Exception e) {
			assertEquals("Valor de custo não pode ser zero ou negativo", e.getMessage());
		}
		
	}
	
	/**
	 * Realiza os testes de adicionarApostaTaxa
	 */
	@Test
	public void adicionarApostaTaxa() {
		facade.cadastrarApostaSeguraTaxa(1, "a", 100, "VAI ACONTECER", 0.1, 100);
		
		try {
			facade.cadastrarApostaSeguraTaxa(0, "a", 100, "VAI ACONTECER", 0.1, 100);
		} catch (Exception e) {
			assertEquals("Erro no cadastro de aposta assegurada por taxa: Cenario invalido",e.getMessage());
		}
		
		try {
			facade.cadastrarApostaSeguraTaxa(100, "a", 100, "VAI ACONTECER", 0.1, 100);
		} catch (Exception e) {
			assertEquals("Erro no cadastro de aposta assegurada por taxa: Cenario invalido",e.getMessage());
		}
		
		try {
			facade.cadastrarApostaSeguraTaxa(1, "", 100, "VAI ACONTECER", 0.1, 100);
		} catch (Exception e) {
			assertEquals("Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo",e.getMessage());
		}
		
		try {
			facade.cadastrarApostaSeguraTaxa(1, " ", 100, "VAI ACONTECER", 0.1, 100);
		} catch (Exception e) {
			assertEquals("Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo",e.getMessage());
		}
		
		try {
			facade.cadastrarApostaSeguraTaxa(1, "a", 0, "VAI ACONTECER", 0.1, 100);
		} catch (Exception e) {
			assertEquals("Erro no cadastro de aposta assegurada por taxa: Valor nao pode ser menor ou igual a zero",e.getMessage());
		}
		
		try {
			facade.cadastrarApostaSeguraTaxa(1, "a", 100, "VAI ", 0.1, 100);
		} catch (Exception e) {
			assertEquals("Erro no cadastro de aposta assegurada por taxa: Previsao invalida",e.getMessage());
		}
		
		try {
			facade.cadastrarApostaSeguraTaxa(1, "a", 100, "VAI ACONTECER", 0, 100);
		} catch (Exception e) {
			assertEquals("Taxa não pode ser negativa ou nula",e.getMessage());
		}
		
		//TODO: falta adicionar quando a taxa é 100 ou maior.
		
		
		try {
			facade.cadastrarApostaSeguraTaxa(1, "a", 100, "VAI ACONTECER", 0.1, 0);
		} catch (Exception e) {
			assertEquals("Valor de custo não pode ser zero ou negativo",e.getMessage());
		}
	}
	
	/**
	 * Realiza os teste de cadastrarApostaSeguraValor.
	 */
	@Test
	public void alterarSeguroValor() {
		facade.alterarSeguroValor(1, 1, 10);
		
		try {
			facade.alterarSeguroValor(-112312, 1, 0);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
