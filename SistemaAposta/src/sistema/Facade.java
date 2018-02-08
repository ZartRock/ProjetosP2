package sistema;

import easyaccept.EasyAccept;

/**
 * Classe responsável de ser a fachada por onde acesso os controladores desse
 * sistema.
 * 
 * @author Áxel Medeiros.
 */
public class Facade {
	private ControleSistema controle;

	public static void main(String[] args) {

		args = new String[] { "sistema.Facade", 
				"teste_aceitacao/us1_test.txt",
				"teste_aceitacao/us2_test.txt", 
				"teste_aceitacao/us3_test.txt",
				"teste_aceitacao/us4_test.txt",
				"teste_aceitacao/us5_test.txt",
				"teste_aceitacao/us6_test.txt"};
		EasyAccept.main(args);
	}

	/**
	 * Realiza a construção do objeto
	 */
	public Facade() {
	}

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
	 * Realiza o cadastro de um cenário com bónus.
	 * 
	 * @param descricaoCenario
	 *            é a descrição(contexto) do cenário para ocorrer as apostas.
	 * @param bonus
	 *            valor para estimular
	 */
	public void cadastrarCenario(String descricaoCenario, int bonus) {
		this.controle.cadastrarCenarioBonus(descricaoCenario, bonus);
	}

	/**
	 * Exibe um cenário espeficico
	 * 
	 * @param numCenario
	 *            representa indice de um cenário.
	 * 
	 * @return Retorna a representação em String desses cenário escolhido
	 */
	public String exibirCenario(int numCenario) {
		return this.controle.exibirCenario(numCenario);
	}

	/**
	 * Retorna uma representação de todos os cenários.
	 * 
	 * @return Uma String com essa represeção.
	 */
	public String exibirCenarios() {
		return this.controle.exibirTodosCenarios();
	}

	/**
	 * Cadastra uma aposta espeficia em um cenário.
	 * 
	 * @param cenario
	 *            representa o indice de um cenário
	 * @param apostador
	 *            representa o nome do apostador.
	 * @param valor
	 *            representa o valor a ser apostado
	 * @param previsao
	 *            representa a previsão feita pelo usuário.
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor,
			String previsao) {
		this.controle.adicionarApostaCenario(cenario, apostador, valor,
				previsao);
	}

//	public void cadastrarApostaSeguraValor(int cenario, String apostador, 
//			int valor, String previsao, int valor, int custo){
//		
//		
//	}

	/**
	 * Retorna o valor total das apostas feitas em um cenário.
	 * 
	 * @param numCenario
	 *            representa o indice de um cenário.
	 * 
	 * @return o valor total das apostas.
	 */
	public int valorTotalDeApostas(int numCenario) {
		return this.controle.retornarValorTotalApostas(numCenario);
	}

	/**
	 * Retorna o número total de apostas em um cenário.
	 * 
	 * @param numCenario
	 *            representa o indice de um cenário.
	 * @return
	 */
	public int totalDeApostas(int numCenario) {
		return this.controle.retornarNumApostaCenario(numCenario);
	}

	/**
	 * Retorna uma representação de todas as apostas de um cenário.
	 * 
	 * @param numCenario
	 *            representa o indice de um cenário.
	 * @return
	 */
	public String exibeApostas(int numCenario) {
		return this.controle.exibirApostas(numCenario);
	}

	/**
	 * Fecha todas as apostas em um determinado cenário.
	 * 
	 * @param numCenario
	 *            representa o indice de um cenário.
	 * @param resultadoCenario
	 *            bolean que representa se o cenário ocorreu ou não.
	 */
	public void fecharAposta(int numCenario, boolean resultadoCenario) {
		this.controle.fecharAposta(numCenario, resultadoCenario);
	}

	/**
	 * Retorna a quantidade de caixa gerado por um cenário específico.
	 * 
	 * @param numCenario
	 *            representa o indice de um cenário.
	 * 
	 * @return o valor total de caixa.
	 */
	public int getCaixaCenario(int numCenario) {
		return this.controle.getCaixaCenario(numCenario);
	}

	/**
	 * Retorna o valor a ser distribuido pelo resultado de um cenário.
	 * 
	 * @param numCenario
	 *            representa o indice de um cenário.
	 * @return retorna o valor total de rateio de um cenário.
	 */
	public int getTotalRateioCenario(int numCenario) {
		return this.controle.getTotalRateioCenario(numCenario);
	}
	
    public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao,int valorSegurado, int custo){ 
    	return this.controle.adicionarApostaValor(cenario, apostador, valor, previsao, valorSegurado, custo);
    }
    
    public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa, int custo){
    	return this.controle.adicionarApostaTaxa(cenario, apostador, valor, previsao, taxa, custo);
    }
    public void alterarSeguroValor(int cenario, int apostaAssegurada, int valor){
    	this.controle.alterarSeguroValor(cenario, apostaAssegurada, valor);
    }
    
    public void alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa){
    	this.controle.alterarSeguroTaxa(cenario, apostaAssegurada, taxa);
    }

}
