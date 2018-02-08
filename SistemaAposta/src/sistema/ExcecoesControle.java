package sistema;

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
	
	
	public void adicionarApostaCenarioExcecoes(int numFornecidoUsuario, int numCenarios){
		tratarErroSelecionarCenario(numFornecidoUsuario, numCenarios, "Erro no cadastro de aposta");
	}
	
	
	public void exibirCenarioExcessoes(int numFornecidoUsuario, int numCenarios){
		tratarErroSelecionarCenario(numFornecidoUsuario, numCenarios, "Erro na consulta de cenario");
		
	}
	
	public void retornarNumApostaCenarioExcecoes(int numFornecidoUsuario, int numCenarios){
		tratarErroSelecionarCenario(numFornecidoUsuario, numCenarios, "Erro na consulta do total de apostas");
	}
	
	public void retornarValorTotalApostasExcecoes(int numFornecidoUsuario, int numCenarios){
		tratarErroSelecionarCenario(numFornecidoUsuario, numCenarios, "Erro na consulta do valor total de apostas");
	}
	
	public void getCaixaCenarioExcecoes(int numFornecidoUsuario, int numCenarios){
		tratarErroSelecionarCenario(numFornecidoUsuario, numCenarios, "Erro na consulta do caixa do cenario");
	}
	
	
	public void fecharApostaExcecoes(int numFornecidoUsuario, int numCenarios){
		tratarErroSelecionarCenario(numFornecidoUsuario, numCenarios, "Erro ao fechar aposta");
	}
	
	public void fecharCenarioExcecoes(int numFornecidoUsuario, int numCenarios){
		tratarErroSelecionarCenario(numFornecidoUsuario, numCenarios, "Erro ao fechar aposta");
	}
	
	public void getTotalRateioCenarioExcecoes(int numFornecidoUsuario, int numCenarios){
		tratarErroSelecionarCenario(numFornecidoUsuario, numCenarios, "Erro na consulta do total de rateio do cenario");
	}
	
	// ------------------------------------ ---------------------------------------------------------//
	public void apostaExcecoes(String nome, double qtn,
			String previsaoString, String nomeErro) {
		
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

		if (previsaoString.trim().equals("") || previsaoString.equals(null)) {
			throw new IllegalArgumentException(
					nomeErro + ": Previsao nao pode ser vazia ou nula");
		}
	}
	
	
}
