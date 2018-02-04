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
	private void tratarErroSelecionarCenario(int numFornecidoUsuario, int numCenarios,
			String[] mensagens) {
		cenarioInvalido(numFornecidoUsuario, mensagens[0]);
		cenarioNaoCadastrado(numFornecidoUsuario, numCenarios, mensagens[1]);
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
	private void cenarioInvalido(int numFornecidoUsuario, String mensagem) {
		if (numFornecidoUsuario < 1) {
			throw new IllegalArgumentException(mensagem);
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
			throw new IllegalArgumentException(mensagem);
		}
	}
	
	
	
	public void adicionarApostaCenarioExcecoes(int numFornecidoUsuario, int numCenarios){
		String[] mensagensExcecoes = { 
				"Erro no cadastro de aposta: Cenario invalido",
				"Erro no cadastro de aposta: Cenario nao cadastrado" };
		
		tratarErroSelecionarCenario(numFornecidoUsuario, numCenarios, mensagensExcecoes);

	}
	
	
	public void exibirCenarioExcessoes(int numFornecidoUsuario, int numCenarios){
		String[] mensagensExcecoes = { 
				"Erro na consulta de cenario: Cenario invalido",
				"Erro na consulta de cenario: Cenario nao cadastrado" };
		
		tratarErroSelecionarCenario(numFornecidoUsuario, numCenarios, mensagensExcecoes);
		
	}
	
	
	public void retornarNumApostaCenarioExcecoes(int numFornecidoUsuario, int numCenarios){
		String[] mensagensExcecoes = { 
				"Erro na consulta do total de apostas: Cenario invalido",
				"Erro na consulta do total de apostas: Cenario nao cadastrado" };
		
		tratarErroSelecionarCenario(numFornecidoUsuario, numCenarios, mensagensExcecoes);
	}
	
	public void retornarValorTotalApostasExcecoes(int numFornecidoUsuario, int numCenarios){
		String[] mensagensExcecoes = { 
				"Erro na consulta do valor total de apostas: Cenario invalido",
				"Erro na consulta do valor total de apostas: Cenario nao cadastrado" };

		tratarErroSelecionarCenario(numFornecidoUsuario, numCenarios, mensagensExcecoes);

	}
	
	
	public void getCaixaCenarioExcecoes(int numFornecidoUsuario, int numCenarios){
		String[] mensagensExcecoes = { 
				"Erro na consulta do caixa do cenario: Cenario invalido",
				"Erro na consulta do caixa do cenario: Cenario nao cadastrado" };
		
		tratarErroSelecionarCenario(numFornecidoUsuario, numCenarios, mensagensExcecoes);
	}
	
	
	public void fecharApostaExcecoes(int numFornecidoUsuario, int numCenarios){
		String[] mensagensExcecoes = { 
				"Erro ao fechar aposta: Cenario invalido",
				"Erro ao fechar aposta: Cenario nao cadastrado" };
		
		tratarErroSelecionarCenario(numFornecidoUsuario, numCenarios, mensagensExcecoes);
	}
	
	public void fecharCenarioExcecoes(int numFornecidoUsuario, int numCenarios){
		String[] mensagensExcecoes = { 
				"Erro ao fechar aposta: Cenario invalido",
				"Erro ao fechar aposta: Cenario nao cadastrado" };
		
		tratarErroSelecionarCenario(numFornecidoUsuario, numCenarios, mensagensExcecoes);
	}
	
	public void getTotalRateioCenarioExcecoes(int numFornecidoUsuario, int numCenarios){
		String[] mensagensExcecoes = { 
				"Erro na consulta do total de rateio do cenario: Cenario invalido",
				"Erro na consulta do total de rateio do cenario: Cenario nao cadastrado" };
		
		tratarErroSelecionarCenario(numFornecidoUsuario, numCenarios, mensagensExcecoes);
	}
}
