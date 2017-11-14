import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe responsável por testar as principais funcionalidades da Agenda.
 * 
 * @author Áxel Medeiros
 *
 */

public class AgendaTest {

	private Agenda agendaBasica;

	/**
	 * Criar uma instancia de Agenda com um cadastro inicial para testar as
	 * demais funcionalidades
	 */
	
	@Before
	public void criarAgenda() {
		agendaBasica = new Agenda();
		agendaBasica.cadastrarContato("Ronald", "Medeiro", "(83) 9999", 5);
	}

	/**
	 * Teste no cadatro de contatos que deveriam não retornar nenhum erro
	 */

	@Test
	public void cadastrarContatoSucessoTest() {

		agendaBasica.cadastrarContato("Ronald", "Medeiro", "(83) 9999", 10);
		agendaBasica.cadastrarContato("Ronald", "Medeiro", "(83) 9999", 25);

	}
	
	@Test
	public void cadastrarContatoCasosLimites() {
		agendaBasica.cadastrarContato("Axel", "Medeiros", "(83)", 100);
		agendaBasica.cadastrarContato("Axel", "Medeiros", "(83)", 1);
		
		try {

			agendaBasica.cadastrarContato("Luiz", "Tavares", "Exemplo", 101);

			fail("Não implementado na posição vazia acima de 100");
		} catch (IndexOutOfBoundsException e) {

		}

		try {
			agendaBasica.cadastrarContato("Luiz", "Tavares", "Exemplo", 0);

			fail("Não implementado na posição vazia abaixo de 1");
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
	}

	/**
	 * Teste dos casos limites(0,101) adjacentes ao index contatos.
	 */

	@Test
	public void cadastrarContatoPosicaoVaziaTest() {
		try {

			agendaBasica.cadastrarContato("Luiz", "Tavares", "Exemplo", 101);

			fail("Não implementado na posição vazia acima de 100");
		} catch (IndexOutOfBoundsException e) {

		}

		try {
			agendaBasica.cadastrarContato("Luiz", "Tavares", "Exemplo", 0);

			fail("Não implementado na posição vazia abaixo de 1");
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}

	}

	/**
	 * Teste do cadastro em uma posicao que já foi cadastrada
	 */

	@Test
	public void cadastrarContatoPosicaoExistenteTest() {
		try {
			agendaBasica.cadastrarContato("A", "S", "()", 5);

			fail("Cadastro de um contato em posicao já existente");
		} catch (IllegalArgumentException e) {
			
		}
	}

	/**
	 * Teste referente ao método pesquisarContato da Agenda. Onde testar as
	 * exceções de: - Pesquisar um index que não possui Contato. - Pesquisar um
	 * Index não permitido
	 */

	@Test
	public void pesquisarContatoTest() {
		assertEquals("Ronald Medeiro - (83) 9999",
				agendaBasica.pesquisarContato(5));

		try {
			agendaBasica.pesquisarContato(45);
		} catch (NullPointerException e) {
			// TODO: handle exception
		}

		try {
			agendaBasica.pesquisarContato(-10);
		} catch (ArrayIndexOutOfBoundsException e) {

		}

	}
	/**
	 * Testa a funcionalidade de listarContato da Agenda. Testando os casos:
	 *    - Se nenhum contato já foi cadastrado
	 *    - Cadastro de 1 ou mais contatos cadastrados
	 * 
	 */
	@Test
	public void listarContatoTest() {
		Agenda novaAgenda = new Agenda();
		assertEquals("Nenhum contato cadastrato", novaAgenda.listarContatos());
		
		novaAgenda.cadastrarContato("Exemplo", "Sobrenome", "(xx) xxxxx - xxxx", 1);
		assertEquals("1 -  Exemplo Sobrenome", novaAgenda.listarContatos());
		
		novaAgenda.cadastrarContato("Exemplo2", "Sobrenome2", "(xx) xxxxx - xxxx", 2);
		assertEquals("1 -  Exemplo Sobrenome\n2 -  Exemplo2 Sobrenome2", novaAgenda.listarContatos());
	}

}




