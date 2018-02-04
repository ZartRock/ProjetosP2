package sistema;

import java.util.ArrayList;

import sistema.entidades.Cenario;
import sistema.entidades.CenarioBonus;
import sistema.entidades.Financas;
import sistema.entidades.apostas.ApostaNormal;
import sistema.entidades.apostas.ApostaTipo;


/**
 * Classe responsável por fazer todo o controle do sistema
 */
public class ControleSistema {

	private ArrayList<Cenario> cenarios;
	private Financas financeiro;
	private ExcecoesControle excecoes = new ExcecoesControle();

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
	 * Cadastrar um cenário com bonus no sistema.
	 * @param descricaoCenario
	 * 				representa a string de descrição do cenário.
	 * 		
	 * @param bonusEmReais
	 * 			represetna o valor do bonus em reais
	 */
	public void cadastrarCenarioBonus(String descricaoCenario, int bonusEmReais) {
		int valorCentavos = bonusEmReais * 100;
		
		this.financeiro.retirarValorCaixa(valorCentavos);
		this.cenarios.add(new CenarioBonus(descricaoCenario, valorCentavos));
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

		throw new IndexOutOfBoundsException("Numerador de cenario não existente");
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
	 *            representa a previsao esperado do jogador em determinado cenário
	 * 
	 * @return um boolean que representa se a operação foi realizada ou não
	 */
	public boolean adicionarApostaCenario(int numFornecidoUsuario, String nomeApostador, double qtnAposta,
			String previsaoString) {

		this.excecoes.adicionarApostaCenarioExcecoes(numFornecidoUsuario, this.cenarios.size());

		int numCenario = numFornecidoUsuario - 1;
		ApostaNormal aposta = new ApostaNormal(nomeApostador, qtnAposta, previsaoString);

		this.cenarios.get(numCenario).adicionarAposta(aposta);
		return true;
	}
	
	public void adicionarApostaEspecial(int cenario, String apostador, int valor,
			String previsao, String tipoSeguro, int valorSegurado, int custoOperacional){
		
		this.financeiro.adicionarValorCaixa(custoOperacional);
		
		ApostaTipo aposta = new ApostaTipo(apostador, valor, previsao, tipoSeguro, valorSegurado);
		this.cenarios.get(cenario).adicionarAposta(aposta);
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
		this.excecoes.exibirCenarioExcessoes(numFornecidoUsuario, this.cenarios.size());

		int numCenario = numFornecidoUsuario - 1;
		return this.cenarios.get(numCenario).toString(numFornecidoUsuario);
	}
	
	
	public void alterarSeguro(int cenario, int numAposta, int valor){
		this.cenarios.get(cenario).alterarAposta(numAposta, valor);
	}
	
	

	/**
	 * Metodo responsável por pegar todas as representações de todos os cenários já
	 * cadastrados.
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
		this.excecoes.retornarNumApostaCenarioExcecoes(numFornecidoUsuario, this.cenarios.size());

		int numCenario = numFornecidoUsuario - 1;
		return this.cenarios.get(numCenario).getNumApostas();
	}

	/**
	 * Retorna uma string contendo a representação de todas as aposta em um cenário
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
		this.excecoes.retornarValorTotalApostasExcecoes(numFornecidoUsuario, this.cenarios.size());
		
		return (int) this.cenarios.get(numFornecidoUsuario - 1).getValorTotalApostas();
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
		this.excecoes.getCaixaCenarioExcecoes(numFornecidoUsuario, this.cenarios.size());
		
		int numCenario = numFornecidoUsuario - 1;

		Cenario cenario = this.cenarios.get(numCenario);

		if (!cenario.getEstaTerminado()) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		}

		return cenario.valorRecolhido() / 100;
	}

	/**
	 * Reliza a operação de fechar uma aposta.
	 * 
	 * @param numFornecidoUsuario
	 *            representa o número do index do cenário, de acordo com a visão do
	 *            usuário.
	 * @param ocorreu
	 *            presenta a operação final do cenário
	 */
	public void fecharAposta(int numFornecidoUsuario, boolean ocorreu) {
		this.excecoes.fecharApostaExcecoes(numFornecidoUsuario, this.cenarios.size());
		int numCenario = numFornecidoUsuario - 1;
		Cenario cenario = this.cenarios.get(numCenario);

		if (cenario.getEstaTerminado()) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}

		cenario.setResultadoCenario(ocorreu);
		int valorParaCaixa = (int) (cenario.valorRecolhido() * this.financeiro.getPorcetagemCasa());

		this.financeiro.adicionarValorCaixa(valorParaCaixa);
	}

	/**
	 * Retorna o valor total a ser dividido entre os vencedores em uma cenário de
	 * apostas.
	 * 
	 * @param numFornecidoUsuario
	 *            representa a numeração que o usuário observa nos cenários.
	 * @return o valor total a ser divididos pelos usuários
	 */
	public int getTotalRateioCenario(int numFornecidoUsuario) {
		this.excecoes.getTotalRateioCenarioExcecoes(numFornecidoUsuario, this.cenarios.size());

		int numCenario = numFornecidoUsuario - 1;

		Cenario cenario = this.cenarios.get(numCenario);
		if (!cenario.getEstaTerminado()) {
			throw new IllegalArgumentException(
					"Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}

		double valorCentavos = Math
				.floor((cenario.valorRecolhido() - cenario.valorRecolhido() * financeiro.getPorcetagemCasa()));

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
		this.excecoes.fecharCenarioExcecoes(numFornecidoUsuario, this.cenarios.size());
		
		int numCenario = numFornecidoUsuario - 1;
		Cenario cenarioEscolhido = this.cenarios.get(numCenario);

		cenarioEscolhido.setResultadoCenario(resultadoCenario);
		int valor = (int) (cenarioEscolhido.valorRecolhido() * this.financeiro.getPorcetagemCasa());
		this.financeiro.adicionarValorCaixa(valor);

	}

	
	
	public static void main(String[] args) {
		ControleSistema c = new ControleSistema(0.01, 20000);
		c.cadastrarCenarioBonus("vida", 100);
		c.adicionarApostaEspecial(0, "axel", 1000, "VAI ACONTECER", "TAXA", 5, 10);
		System.out.println(c.exibirCenario(1));
		System.out.println(c.exibirApostas(1));
		c.alterarSeguro(0, 0, 100);
		System.out.println(c.exibirApostas(1));
	}
	
}
