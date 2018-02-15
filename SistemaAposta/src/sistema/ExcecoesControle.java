package sistema;

/**
 * Classe responsável por lançar as exeções do ControleSistema
 * 
 * @author Áxel Medeiros.
 *
 */
public class ExcecoesControle {
	
	
	/**
	 * Realiza o redirencionamento de um erro para algum outro metodo
	 * auxiliar.
	 * 
	 * @param numFornecidoUsuario
	 *            representa a numeração que o usuário observa nos cenários.
	 *            
	 * @param numCenarios
	 * 			  representa o número de cenários já cadastrados no sistema.
	 * 
	 * @param mensagens
	 *            representa uma array de string que contém mensagens
	 *            espeficicas para cada exceção.
	 */
	public void tratarErroSelecionarCenario(int numFornecidoUsuario, int numCenarios,
			String nomeErro) {
		cenarioInvalido(numFornecidoUsuario, nomeErro);
		cenarioNaoCadastrado(numFornecidoUsuario, numCenarios, nomeErro);
	}
	
	
	/**
	 * Realiza o lançamento des erros onde numero fornecido pelo usuário é
	 * negativo
	 * 
	 * @param numFornecidoUsuario
	 *            representa a numeração que o usuário observa nos cenários.
	 * 
	 * @param mensagem
	 *            representa a mensagem a ser exibida pelo lançamento do erro
	 */
	private void cenarioInvalido(int numFornecidoUsuario, String nome) {
		if (numFornecidoUsuario < 1) {
			throw new IllegalArgumentException(nome + ": Cenario invalido");
		}
	}


	/**
	 * Realiza o lançamento des erros onde numero fornecido pelo usuário ainda
	 * não foi cadastrado.
	 * 
	 * @param numFornecidoUsuario
	 *            representa a numeração que o usuário observa nos cenários.
	 * 
	 * @param numCenarios
	 * 			  representa o número de cenários já cadastrados no sistema.
	 * 
	 * @param mensagem
	 *            representa a mensagem a ser exibida pelo lançamento do erro
	 */
	private void cenarioNaoCadastrado(int numFornecidoUsuario, int numCenario,
			String mensagem) {
		if (numFornecidoUsuario > numCenario) {
			throw new IllegalArgumentException(mensagem + ": Cenario nao cadastrado");
		}
	}
	
	/**
	 * Responsável por direcionar o erro de adicionar aposta cenario
	 * @param numFornecidoUsuario
	 * 		número aparente do cenário
	 * @param numCenarios
	 * 		numero total de cenário cadastrados
	 */
	public void adicionarApostaCenarioExcecoes(int numFornecidoUsuario, int numCenarios){
		tratarErroSelecionarCenario(numFornecidoUsuario, numCenarios, "Erro no cadastro de aposta");
	}
	
	/**
	 * Responsável por direcionar o erro de exibir cenário.
	 * @param numFornecidoUsuario
	 * 		número aparente do cenário
	 * @param numCenarios
	 * 		numero total de cenário cadastrados
	 */
	public void exibirCenarioExcessoes(int numFornecidoUsuario, int numCenarios){
		tratarErroSelecionarCenario(numFornecidoUsuario, numCenarios, "Erro na consulta de cenario");
		
	}
	/**
	 * Responsável por direcionar o erro de adicionar aposta cenario
	 * @param numFornecidoUsuario
	 * 		número aparente do cenário
	 * @param numCenarios
	 * 		numero total de cenário cadastrados
	 */
	public void retornarNumApostaCenarioExcecoes(int numFornecidoUsuario, int numCenarios){
		tratarErroSelecionarCenario(numFornecidoUsuario, numCenarios, "Erro na consulta do total de apostas");
	}
	
	/**
	 * Responsável por direcionar o erro de retornarValorTotalApostas.
	 * @param numFornecidoUsuario
	 * 		número aparente do cenário
	 * @param numCenarios
	 * 		numero total de cenário cadastrados
	 */
	public void retornarValorTotalApostasExcecoes(int numFornecidoUsuario, int numCenarios){
		tratarErroSelecionarCenario(numFornecidoUsuario, numCenarios, "Erro na consulta do valor total de apostas");
	}
	
	/**
	 * Responsável por direcionar o erro de getCaixaCenario.
	 * @param numFornecidoUsuario
	 * 		número aparente do cenário
	 * @param numCenarios
	 * 		numero total de cenário cadastrados
	 */
	public void getCaixaCenarioExcecoes(int numFornecidoUsuario, int numCenarios){
		tratarErroSelecionarCenario(numFornecidoUsuario, numCenarios, "Erro na consulta do caixa do cenario");
	}
	
	/**
	 * Responsável por direcionar o erro de facharAposta.
	 * @param numFornecidoUsuario
	 * 		número aparente do cenário
	 * @param numCenarios
	 * 		numero total de cenário cadastrados
	 */
	public void fecharApostaExcecoes(int numFornecidoUsuario, int numCenarios){
		tratarErroSelecionarCenario(numFornecidoUsuario, numCenarios, "Erro ao fechar aposta");
	}
	
	/**
	 * Responsável por direcionar o erro de fecharCenario.
	 * @param numFornecidoUsuario
	 * 		número aparente do cenário
	 * @param numCenarios
	 * 		numero total de cenário cadastrados
	 */
	public void fecharCenarioExcecoes(int numFornecidoUsuario, int numCenarios){
		tratarErroSelecionarCenario(numFornecidoUsuario, numCenarios, "Erro ao fechar aposta");
	}
	
	/**
	 * Responsável por direcionar o erro de getTotalRateioCenario.
	 * @param numFornecidoUsuario
	 * 		número aparente do cenário
	 * @param numCenarios
	 * 		numero total de cenário cadastrados
	 */
	public void getTotalRateioCenarioExcecoes(int numFornecidoUsuario, int numCenarios){
		tratarErroSelecionarCenario(numFornecidoUsuario, numCenarios, "Erro na consulta do total de rateio do cenario");
	}
	
	
	
	/**
	 * Responsável por tratar erros comuns na construção de uma aposta.
	 * @param nome
	 * 		representa o nome do apsotador.
	 * @param qtn
	 * 		representa a quantidade a ser apostada.
	 * @param previsaoString
	 * 		representa o resultado esperado do cenário
	 * @param nomeErro
	 * 		representa o nome do metodo onde ocorrer o erro.
	 * @param numCenarios
	 * 		representa a quantidade de cenários atuais.
	 * @param cenario
	 * 		representa o número aparente do cenário
	 */
	public void apostaExcecoes(String nome, double qtn,
			String previsaoString, String nomeErro, int numCenarios, int cenario) {
		
		if (nome.equals(null)) {
			throw new NullPointerException("Nome nulo");
		}

		if (nome.trim().isEmpty()) {
			throw new IllegalArgumentException(
					nomeErro + ": Apostador nao pode ser vazio ou nulo");
		} else if (qtn <= 0) {
			throw new IllegalArgumentException(
					nomeErro + ": Valor nao pode ser menor ou igual a zero");
		}

		if (previsaoString.trim().equals("")) {
			throw new IllegalArgumentException(
					nomeErro + ": Previsao nao pode ser vazia ou nula");
		} else if (!(previsaoString.equals("VAI ACONTECER") 
					|| previsaoString.equals("N VAI ACONTECER"))) {
			
			throw new IllegalArgumentException(
					 nomeErro + ": Previsao invalida");
		}
		
		if (cenario < 1 || cenario > numCenarios) {
			throw new IllegalArgumentException(
					nomeErro + ": Cenario invalido");
		}		
	}	
}
