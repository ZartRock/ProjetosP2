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
	public void cenarioInvalido(int numFornecidoUsuario, String mensagem) {
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
	public void cenarioNaoCadastrado(int numFornecidoUsuario, int numCenario,
			String mensagem) {
		if (numFornecidoUsuario > numCenario) {
			throw new IllegalArgumentException(mensagem);
		}
	}
}
