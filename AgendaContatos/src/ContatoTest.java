import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ContatoTest {

	private Contato contatoBasico;

	@Before
	public void criaContato() {
		contatoBasico = new Contato("Axel", "Medeiros", "(xx) xxxx - xxxx");

	}
	
	/**
	 * Realiza testes referente a tentativa de instanciar um objeto Contato com valores nulos
	 */
	
	@Test
	public void construcaoValoresNulos() {
		try {
			Contato a = new Contato(null, "3", "2");

			fail("Nome Nulo");
		} catch (NullPointerException e) {
			// TODO: handle exception
		}

		try {
			Contato a = new Contato("vida", null, "2");

			fail("Sobrenome nulo");
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			Contato a = new Contato("Nome", "Sobrenome", null);

			fail("Ambos nulos");
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void construcaoInformacoesInvaldas(){
		try {
			Contato a = new Contato("", "Sobrenome", "(00) 99090-4080");
		} catch (IllegalArgumentException e) {
			
		}
		
		try {
			Contato a = new Contato("Nome", "", "(00) 99090-4080");
		} catch (IllegalArgumentException e) {
			
		}
		
		try {
			Contato a = new Contato("Nome", "Sobrenome", "");
		} catch (IllegalArgumentException e) {
			
		}
		
		try {
			Contato a = new Contato("", "", "");
		} catch (IllegalArgumentException e) {
			
		}
		
		
		
	}
	/**
	 * Realiza a verificação da saida do metodo verContato
	 */
	@Test
	public void verContatoTest() {
		assertEquals("Axel Medeiros", contatoBasico.verContato());

	}
	/**
	 * Realizar a verificação da saida mais detalhada da exibição de um Contato.
	 */
	@Test
	public void verDetalhesContatoTest(){
		assertEquals("Axel Medeiros - (xx) xxxx - xxxx", 
					contatoBasico.verDetalhesContato());
	}
	
	/**
	 * Testa se dois contato diferentes mais com o mesmos atributos são iguais.
	 */
	@Test
	public void contatosIguais() {
		Contato a = new Contato("1","1","1");
		Contato b = new Contato("1","1","1");
		assertEquals(true, a.equals(b));
	}

}
