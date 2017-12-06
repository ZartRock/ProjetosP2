package lab_04;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Classe responsáve por testes as funcionalidade da classe ControleSistema
 * 
 * @author Áxel Medeiros
 *
 */
public class ControleSistemaTest {
	
	private ControleSistema controle = new ControleSistema();
	private Aluno alunoExemplo = new Aluno("Exemplo", "111", "CC");
	private GrupoEstudo grupoExemplo = new GrupoEstudo("Teorias Rick e Morthy");
		
	/**
	 * Testar a funcionalidade de Construção
	 */
	
	@Test
	public void criarControleSucesso() {
		new ControleSistema();
	}

	/**
	 * Testar a funcionalidade de cadastrar alunos no sistema.
	 */
	
	@Test
	public void cadastrarAlunoSucesso() {
		assertEquals(true, controle.cadastrarAluno("111", "Exemplo", "CC"));
	}
	
	/**
	 * Testa o caso de cadastrar um aluno ja cadastrado
	 */
	
	@Test()
	public void cadastarAlunoJaCadastrado() {
		cadastrarAlunoExemplo();
		assertEquals(false, controle.cadastrarAluno("111", "Exemplo", "CC"));
	}
	/**
	 * Testa o caso de consultar um aluno com sucesso.
	 */
	@Test
	public void consultarAlunoSucesso() {
		cadastrarAlunoExemplo();
		assertEquals(alunoExemplo.toString(), controle.consultarAluno("111"));
	}
	
	/**
	 * Testa o caso de consultar um aluno inexistente.
	 */
	
	@Test(expected=NullPointerException.class)
	public void cosultarAlunoInexistente() {
		controle.consultarAluno("1000");
	}
	/**
	 * Testa o caso de cadastrar um grupo válido.
	 */
	@Test
	public void cadastrarGrupoSucesso() {
		assertEquals(true, controle.cadastrarGrupo("42"));
	}
	
	/**
	 * Testa o caso de cadastrar um grupo já existente.
	 */
	
	@Test
	public void cadastrarGrupoExistente() {
		controle.cadastrarGrupo("Teorias Rick e Morthy");
		assertEquals(false, controle.cadastrarGrupo("Teorias Rick e Morthy"));
	}
	
	/**
	 * Testa o caso de cadastrar um grupo com um nome inválido.
	 */
	
	@Test(expected=IllegalArgumentException.class)
	public void cadastrarGrupoNomeInvalido() {
		controle.cadastrarGrupo("");
	}
	
	/**
	 * Testa o caso de cadastrar um grupo com o nome nulo.
	 */
	
	@Test(expected=NullPointerException.class)
	public void cadastarGrupoNomeNull() {
		controle.cadastrarGrupo(null);
	}
	
	/**
	 * Testa o caso de alocar um aluno válido em um grupo existente.
	 */
	
	@Test
	public void alocarAlunosSucesso() {
		cadastrarExemploCompleto();
		assertEquals(true, controle.alocarAlunos("111", "Teorias Rick e Morthy"));	
	}
	
	/**
	 * Testa o caso de alocar um aluno válido mais de uma vez em um grupo.
	 */
	
	@Test
	public void alocarAlunosJaAlocado() {
		cadastrarExemploCompleto();
		alocarAlunosSucesso();
		assertEquals(false, controle.alocarAlunos("111", "Teorias Rick e Morthy"));
	}
	
	/**
	 * Testa o caso de alocar um aluno inexistente em um grupo.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void alocarAlunosInexistente() {
		cadastrarGrupoExemplo();
		controle.alocarAlunos("42", "Teorias Rick e Morthy");
	}
	
	/**
	 * Testa o caso de alocar um aluno em um grupo inexistente.
	 */
	
	@Test(expected=IllegalArgumentException.class)
	public void alocarAlunosGrupoInexistente() {
		cadastrarAlunoExemplo();
		controle.alocarAlunos("111", "Matematica");
	}
	
	/**
	 * Testa o caso de alocar um aluno e grupo inexistentes.
	 */
	
	@Test(expected=IllegalArgumentException.class)
	public void alocarAlunosDadosInexistentes() {
		controle.alocarAlunos("666", "Rock and Roll");
	}
	
	/**
	 * testa um caso que deverá imprimir um grupo com seus participantes.
	 */
	
	@Test
	public void imprimirGrupoSucessoParticipantes() throws Exception {
		
		cadastrarExemploCompleto();
		controle.alocarAlunos("111", "Teorias Rick e Morthy");
		
		grupoExemplo.alocarParticipante(alunoExemplo);
		
		assertEquals(grupoExemplo.toString(), controle.imprimirGrupo("Teorias Rick e Morthy"));
	}
	
	/**
	 * Testa o caso de imprimir um grupo sem nenhum cadastros.
	 */
	
	@Test(expected=Exception.class)
	public void imprimirGrupoNaoCadastro() throws Exception{
		controle.imprimirGrupo("Math");
	}
	
	/**
	 * Testa o caso de impressão de um grupo sem participantes.
	 */
	
	@Test(expected=Exception.class)
	public void imprimirGrupoSemParticipantes() throws Exception {
		cadastrarExemploCompleto();
		controle.imprimirGrupo("Teorias Rick e Morthy");
	}
	
	/**
	 * Testa o caso de adicionar um aluno a lista dos alunos que responderam no quadro.
	 */
	
	@Test
	public void adicionarAlunoRespondeuQuadroSucesso() {
		cadastrarAlunoExemplo();
		controle.adicionarAlunoRespondeuQuadro("111");
	}
	
	/**
	 * Testa a funcionalidade de adicionar um aluno inexistente a lista dos alunos que responderam no quadro.
	 */
	
	@Test(expected=IllegalArgumentException.class)
	public void adicionarAlunoRespondeuQuadroAlunoInexistente() {
		controle.adicionarAlunoRespondeuQuadro("111");
	}
	
	
	/**
	 * Adiciona um cadastro de aluno no sistema
	 */
	
	private void cadastrarAlunoExemplo() {
		controle.cadastrarAluno("111", "Exemplo", "CC");
	}
	
	/**
	 * Adiciona um cadastro de grupo no sistema.
	 */
	
	private void cadastrarGrupoExemplo() {
		controle.cadastrarGrupo("Teorias Rick e Morthy");
	}
	
	/**
	 * Adiciona em controle de sistema um cadastrado de aluno e de um grupo.
	 */
	
	private void cadastrarExemploCompleto() {
		cadastrarAlunoExemplo();
		cadastrarGrupoExemplo();
	}
	
	

}
