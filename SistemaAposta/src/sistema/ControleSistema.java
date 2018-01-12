package sistema;

import java.util.ArrayList;

/**
 * Classe responsável por fazer todo o controle do sistema
 */
public class ControleSistema {

	private ArrayList<Cenario> cenarios;
	private Financas financeiro;

	/**
	 * Contrutor do controle do sistema
	 * 
	 * @param porcetagemCasa
	 *            Indica a porcentagem em float da caxa
	 * @param caixaAtual
	 *            Representa a quantidade de caixa inicial do sistema.
	 */
	public ControleSistema(double porcetagemCasa, int caixaAtual) {
		this.cenarios = new ArrayList<Cenario>();
		this.financeiro = new Financas(porcetagemCasa, caixaAtual);
	}

	/**
	 * Retorna o valor atual do caixa
	 * 
	 * @return um int que representa o caixa
	 */
	public int getCaixaAtual() {
		return (int) (this.financeiro.getCaixaAtualCentavos());
	}

	/**
	 * Cadastra um cenário no sistema.
	 * 
	 * @param descricaoCenario
	 *            representa a string de descrição do cenário.
	 */
	public void cadastrarCenario(String descricaoCenario) {
		this.cenarios.add(new Cenario(descricaoCenario));
	}

	/**
	 * Retorna um número espeficico de um cenário com base na sua descrição
	 * 
	 * @param descricaoCenario
	 *            representa a string de descrição do cenário.
	 * @return o index do cenário.
	 */
	public int getNumCenario(String descricaoCenario) {
		for (int i = 0; i < this.cenarios.size(); i++) {
			if (this.cenarios.get(i).getDescricao().equals(descricaoCenario)) {
				return i;
			}
		}

		throw new IndexOutOfBoundsException(
				"Numerador de cenario não existente");
	}

	/**
	 * Representa a operação de adicionar uma aposta em um cenário espeficico.
	 * 
	 * @param numFornecidoUsuario
	 *            representa a numeração que o usuário observa no cadastro dos
	 *            cenários.
	 * @param nomeApostador
	 *            representa o nome do apostador
	 * @param qtnAposta
	 *            representa a quantia a ser apostada.
	 * @param previsaoString
	 *            representa a previsao esperado do jogador em determinado
	 *            cenário
	 * 
	 * @return um boolean que representa se a operação foi realizada ou não
	 */
	public boolean adicionarApostaCenario(int numFornecidoUsuario,
			String nomeApostador, double qtnAposta, String previsaoString) {
		String[] mensagensExcecoes = {
				"Erro no cadastro de aposta: Cenario invalido",
				"Erro no cadastro de aposta: Cenario nao cadastrado" };

		tratarErroSelecionarCenario(numFornecidoUsuario, mensagensExcecoes);

		int numCenario = numFornecidoUsuario - 1;
		Aposta aposta = new Aposta(nomeApostador, qtnAposta, previsaoString);

		this.cenarios.get(numCenario).adicionarAposta(aposta);
		return true;
	}

	/**
	 * Retorna a representação de um cenário em String.
	 * 
	 * @param numFornecidoUsuario
	 *            representa a numeração que o usuário observa no cadastro dos
	 *            cenários.
	 * 
	 * @return um String contena esta representação.
	 */
	public String exibirCenario(int numFornecidoUsuario) {
		String[] mensagensExcecoes = {
				"Erro na consulta de cenario: Cenario invalido",
				"Erro na consulta de cenario: Cenario nao cadastrado" };

		tratarErroSelecionarCenario(numFornecidoUsuario, mensagensExcecoes);

		int numCenario = numFornecidoUsuario - 1;
		return this.cenarios.get(numCenario).toString(numFornecidoUsuario);
	}

	/**
	 * Metodo responsável por pegar todas as representações de todos os cenários
	 * já cadastrados.
	 * 
	 * @return um string que representa está saída.
	 */
	public String exibirTodosCenarios() {
		String saida = "";
		for (int i = 0; i < this.cenarios.size(); i++) {
			saida += this.cenarios.get(i).toString(i);
		}

		return saida;
	}

	/**
	 * Metodo que retorna um número de apostas feitas em um cenário
	 * 
	 * @param numFornecidoUsuario
	 *            representa a numeração que o usuário observa no cadastro dos
	 *            cenários.
	 * @return um int que representa o número de apostas nesse cenário.
	 */
	public int retornarNumApostaCenario(int numFornecidoUsuario) {
		String[] mensagensExcecoes = {
				"Erro na consulta do total de apostas: Cenario invalido",
				"Erro na consulta do total de apostas: Cenario nao cadastrado" };

		tratarErroSelecionarCenario(numFornecidoUsuario, mensagensExcecoes);

		int numCenario = numFornecidoUsuario - 1;
		return this.cenarios.get(numCenario).getNumApostas();
	}

	/**
	 * Retorna uma string contendo a representação de todas as aposta em um
	 * cenário
	 * 
	 * @param numFornecidoUsuario
	 *            representa a numeração que o usuário observa nos cenários.
	 * 
	 * @return um string contendo essas representações
	 */
	public String exibirApostas(int numFornecidoUsuario) {
		return this.cenarios.get(numFornecidoUsuario - 1).exibeApostas();
	}

	/**
	 * Retorna o valor total de todas as aposta em um cenário
	 * 
	 * @param numFornecidoUsuario
	 *            representa a numeração que o usuário observa nos cenários.
	 * 
	 * @return um int que é o somatório de todos as quantias das apostas.
	 */
	public int retornarValorTotalApostas(int numFornecidoUsuario) {
		String[] mensagensExcecoes = {
				"Erro na consulta do valor total de apostas: Cenario invalido",
				"Erro na consulta do valor total de apostas: Cenario nao cadastrado" };

		tratarErroSelecionarCenario(numFornecidoUsuario, mensagensExcecoes);

		return (int) this.cenarios.get(numFornecidoUsuario - 1)
				.getValorTotalApostas();
	}

	/**
	 * Retorna o caixa adquirido do sistema pela concretização de um cenário de
	 * apostas.
	 * 
	 * @param numFornecidoUsuario
	 *            representa a numeração que o usuário observa nos cenários.
	 * @return o valor que o sistema adicionou ao caixa com um cenário.
	 */
	public int getCaixaCenario(int numFornecidoUsuario) {
		String[] mensagensExcecoes = {
				"Erro na consulta do caixa do cenario: Cenario invalido",
				"Erro na consulta do caixa do cenario: Cenario nao cadastrado" };

		tratarErroSelecionarCenario(numFornecidoUsuario, mensagensExcecoes);
		int numCenario = numFornecidoUsuario - 1;

		Cenario cenario = this.cenarios.get(numCenario);

		if (!cenario.getEstaTerminado()) {
			throw new IllegalArgumentException(
					"Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		}

		return cenario.valorRecolhido() / 100;
	}

	/**
	 * Reliza a operação de fechar uma aposta.
	 * 
	 * @param numFornecidoUsuario
	 *            representa o número do index do cenário, de acordo com a visão
	 *            do usuário.
	 * @param ocorreu
	 *            presenta a operação final do cenário
	 */
	public void fecharAposta(int numFornecidoUsuario, boolean ocorreu) {
		String[] mensagensExcecoes = {
				"Erro ao fechar aposta: Cenario invalido",
				"Erro ao fechar aposta: Cenario nao cadastrado" };

		tratarErroSelecionarCenario(numFornecidoUsuario, mensagensExcecoes);

		int numCenario = numFornecidoUsuario - 1;
		Cenario cenario = this.cenarios.get(numCenario);

		if (cenario.getEstaTerminado()) {
			throw new IllegalArgumentException(
					"Erro ao fechar aposta: Cenario ja esta fechado");
		}

		cenario.setResultadoCenario(ocorreu);
		int valorParaCaixa = (int) (cenario.valorRecolhido() * this.financeiro
				.getPorcetagemCasa());

		this.financeiro.adicionarValorCaixa(valorParaCaixa);
	}

	/**
	 * Retorna o valor total a ser dividido entre os vencedores em uma cenário
	 * de apostas.
	 * 
	 * @param numFornecidoUsuario
	 *            representa a numeração que o usuário observa nos cenários.
	 * @return o valor total a ser divididos pelos usuários
	 */
	public int getTotalRateioCenario(int numFornecidoUsuario) {
		String[] mensagensExcecoes = {
				"Erro na consulta do total de rateio do cenario: Cenario invalido",
				"Erro na consulta do total de rateio do cenario: Cenario nao cadastrado" };

		tratarErroSelecionarCenario(numFornecidoUsuario, mensagensExcecoes);

		int numCenario = numFornecidoUsuario - 1;

		Cenario cenario = this.cenarios.get(numCenario);
		if (!cenario.getEstaTerminado()) {
			throw new IllegalArgumentException(
					"Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}

		double valorCentavos = Math.floor((cenario.valorRecolhido() - cenario
				.valorRecolhido() * financeiro.getPorcetagemCasa()));

		return (int) valorCentavos;
	}

	/**
	 * Representa a operação de fechar um cenário
	 * 
	 * @param numFornecidoUsuario
	 *            representa a numeração que o usuário observa nos cenários.
	 * @param resultadoCenario
	 *            valor a ser atribuido ao cenário
	 */
	public void fecharCenario(int numFornecidoUsuario, boolean resultadoCenario) {
		String[] mensagensExcecoes = {
				"Erro ao fechar aposta: Cenario invalido",
				"Erro ao fechar aposta: Cenario nao cadastrado" };

		tratarErroSelecionarCenario(numFornecidoUsuario, mensagensExcecoes);
		int numCenario = numFornecidoUsuario - 1;
		Cenario cenarioEscolhido = this.cenarios.get(numCenario);

		cenarioEscolhido.setResultadoCenario(resultadoCenario);
		int valor = (int) (cenarioEscolhido.valorRecolhido() * this.financeiro
				.getPorcetagemCasa());
		this.financeiro.adicionarValorCaixa(valor);

	}

	/**
	 * Realiza o redirencionamento de um erro para algum metodo outro metodo
	 * auxiliar
	 * 
	 * @param numFornecidoUsuario
	 *            representa a numeração que o usuário observa nos cenários.
	 * @param mensagens
	 *            representa uma array de string que contém mensagens
	 *            espeficicas para cada exceção.
	 */
	private void tratarErroSelecionarCenario(int numFornecidoUsuario,
			String[] mensagens) {
		tratarErrosCenarioInvalido(numFornecidoUsuario, mensagens[0]);
		tratarErrosCenarioNaoCadastrado(numFornecidoUsuario, mensagens[1]);
	}

	/**
	 * Realiza o lançamento des erros onde numero fornecido pelo usuário é
	 * negativo
	 * 
	 * @param numFornecidoUsuario
	 *            representa a numeração que o usuário observa nos cenários.
	 * @param mensagem
	 *            representa a mensagem a ser exibida pelo lançamento do erro
	 */
	private void tratarErrosCenarioInvalido(int numFornecidoUsuario,
			String mensagem) {
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
	 * @param mensagem
	 *            representa a mensagem a ser exibida pelo lançamento do erro
	 */
	private void tratarErrosCenarioNaoCadastrado(int numFornecidoUsuario,
			String mensagem) {
		if (numFornecidoUsuario > this.cenarios.size()) {
			throw new IllegalArgumentException(mensagem);
		}
	}

}
