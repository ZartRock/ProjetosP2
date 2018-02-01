package sistema;

import easyaccept.EasyAccept;

/**
 * Classe responsável de ser a fachada por onde acesso os controladores desse
 * sistema.
 * 
 * @author Áxel Medeiros
 */
public class Facade {
	ControleSistema controle;

	public static void main(String[] args) {

		args = new String[] { "sistema.Facade", 
							"teste_aceitacao/us1_test.txt",
							"teste_aceitacao/us2_test.txt", 
							"teste_aceitacao/us3_test.txt",
							"teste_aceitacao/us4_test.txt" };
		EasyAccept.main(args);
	}

	/**
	 * Realiza a construção do objeto
	 */
	public Facade() { }

	/**
	 * Realiza a operação de iniciar de inicial sistema
	 * 
	 * @param caixaAtual
	 *            caixa inicial do sistema
	 *            
	 * @param porcetagemCasa
	 *            porcentagem cobrada nas aposta pela casa.
	 */
	public void inicializa(int caixaAtual, double porcetagemCasa) {
		this.controle = new ControleSistema(porcetagemCasa, caixaAtual);

	}

	/**
	 * Retorna o valor atual do caixa
	 * 
	 * @return int represenando o caixa.
	 */
	public int getCaixa() {
		return this.controle.getCaixaAtual();
	}

	/**
	 * Realiza o cadastro de um cenário no sistema
	 * 
	 * @param descricaoCenario
	 *            é a descrição(contexto) do cenário para ocorrer as apostas.
	 */
	public void cadastrarCenario(String descricaoCenario) {
		this.controle.cadastrarCenario(descricaoCenario);
	}

	/**
	 * Exibe um cenário espeficico
	 * 
	 * @param numCenario
	 *            representan um
	 * @return Retorna a representação em String desses cenário escolhido
	 */
	public String exibirCenario(int numCenario) {
		return this.controle.exibirCenario(numCenario);
	}
	
	public String exibirCenarios() {
		return this.controle.exibirTodosCenarios();
	}

	public void cadastrarAposta(int cenario, String apostador, int valor,
			String previsao) {
		this.controle.adicionarApostaCenario(cenario, apostador, valor,
				previsao);
	}

	public int valorTotalDeApostas(int numCenario) {
		return this.controle.retornarValorTotalApostas(numCenario);
	}

	public int totalDeApostas(int numCenario) {
		return this.controle.retornarNumApostaCenario(numCenario);
	}

	public String exibeApostas(int numCenario) {
		return this.controle.exibirApostas(numCenario);
	}

	public void fecharAposta(int numCenario, boolean resultadoCenario) {
		this.controle.fecharAposta(numCenario, resultadoCenario);
	}

	public int getCaixaCenario(int numCenario) {
		return this.controle.getCaixaCenario(numCenario);
	}

	public int getTotalRateioCenario(int numCenario) {
		return this.controle.getTotalRateioCenario(numCenario);
	}

}
