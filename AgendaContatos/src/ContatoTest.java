import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ContatoTest {

	private Contato contatoBasico;

	@Before
	public void criaContato() {
		contatoBasico = new Contato("Axel", "Medeiros", "(xx) xxxx - xxxx");

	}

	@Test
	public void inicializacaoNula() {
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
			Contato a = new Contato(null, null, "2");

			fail("Ambos nulos");
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
	}

	@Test
	public void verContatoTest() {
		assertEquals("Axel Medeiros", contatoBasico.verContato());

	}
	
	@Test
	public void verDetalhesContato(){
		assertEquals("Axel Medeiros -> (xx) xxxx - xxxx", 
					contatoBasico.verDetalhesContato());
	}
	
	@Test
	public void verDetalhesTelefoneVazio(){
		// Posso verificar com a inicializacao null tbm
		
		Contato exemplo = new Contato("Killua","Zoldyck","");
		
		assertEquals("Killua Zoldyck -> Não registado", exemplo.verDetalhesContato());
	}
	
	@Test
	public void contatosIguais() {
		Contato a = new Contato("1","1","1");
		Contato b = new Contato("1","1","1");
		assertEquals(true, a.equals(b));
	}

}
