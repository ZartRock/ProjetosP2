package sistema.cenarios;

import java.util.ArrayList;

import sistema.apostas.Aposta;
import sistema.seguros.Seguro;

/**
 * Classe que representa um cenário de apostas no sistema.
 * 
 * @author Áxel Medeiros
 * 
 */
public class Cenario implements Comparable<Cenario> {

	protected String descricao;
	protected ArrayList<Aposta> conjuntoApostas;
	protected boolean estaTerminado;
	protected boolean resultadoCenario;

	/**
	 * Responsável pela construção do objeto
	 * 
	 * @param descricao
	 *            Refere-se a descrição geral ou contexto básico da aposta.
	 */
	public Cenario(String descricao) {
		tratarExcecoesConstrutor(descricao);

		this.descricao = descricao;
		this.conjuntoApostas = new ArrayList<Aposta>();
		this.estaTerminado = false;
	}

	/**
	 * Adiciona um o valor de uma aposta ao conjunto
	 * 
	 * @param aposta
	 *            representa uma aposta
	 * @return se a aposta foi realizada ou não
	 */
	public boolean adicionarAposta(Aposta aposta) {
		this.conjuntoApostas.add(aposta);
		return true;
	}

	/**
	 * Alterar o tipo do seguro de uma aposta específica
	 * 
	 * @param numAposta
	 *            representa o índice da aposta
	 * @param seguro
	 *            representa o novo seguro
	 */
	public void alterarSeguro(int numAposta, Seguro seguro) {
		this.conjuntoApostas.get(numAposta).setSeguro(seguro);
	}

	/**
	 * Retorna uma exibição do Cenario em uma String
	 * 
	 * @return uma String que representa o cenário
	 */
	public String exibeApostas() {
		String saida = "";
		for (Aposta aposta : this.conjuntoApostas) {
			saida += aposta.toString() + "\n";
		}

		if (saida.equals("")) {
			saida = "Nenhuma aposta cadastrada";
		}

		return saida;
	}

	/**
	 * Finaliza o cenário setando o resultado dele como um bolean
	 * 
	 * @param resultadoCenario
	 *            representa o bolean a ser passado com novo valor do cenário.
	 * @throws Exception
	 *             Lança uma exceção se o cenário já estiver terminado
	 */
	public void finalizarCenario(boolean resultadoCenario) throws Exception {
		if (this.estaTerminado == true) {
			throw new Exception("Erro ao fechar aposta: Cenario ja esta fechado");
		}
		this.resultadoCenario = resultadoCenario;
		this.estaTerminado = true;
	}

	/**
	 * retona a descrição do cenario.
	 * 
	 * @return
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * Retorna o número de apostas do cenário.
	 * 
	 * @return
	 */
	public int getNumApostas() {
		return this.conjuntoApostas.size();
	}

	/**
	 * Retorna uma váriavel representando se terminou ou não o cenário
	 * 
	 * @return return um boolean que representa essa relação
	 */
	public boolean getEstaTerminado() {
		return this.estaTerminado;
	}

	/**
	 * Retorna o rateio total de um cenário.
	 */
	public int getRateio() {
		return valorRecolhido();
	}

	/**
	 * Retorna o valor todas de todos as aposta desse cenários.
	 * 
	 * @return um double que representa esse somatório
	 */
	public double getValorTotalApostas() {
		double valorTotal = 0;
		for (Aposta aposta : this.conjuntoApostas) {
			valorTotal += aposta.getQtnAposta();
		}

		return valorTotal;
	}

	/**
	 * Colcocar o resltado da operaçao igual a variavel resultado
	 * 
	 * @param resultadoCenario
	 *            representa Boolean que representa esta opeeração
	 */
	public void setResultadoCenario(boolean resultadoCenario) {
		this.resultadoCenario = resultadoCenario;
		this.estaTerminado = true;
	}

	/**
	 * Retorna o valor a ser recolhido com o fim do cenário
	 * 
	 * @return retorna um int que representa a soma de todos as apostas perdedoras;
	 */
	public int valorRecolhido() {
		int valorRecolhidoCentavos = 0;

		for (Aposta aposta : this.conjuntoApostas) {

			if ((this.resultadoCenario == true && aposta.getPrevisao() == false)
					|| (this.resultadoCenario == false && aposta.getPrevisao() == true)) {

				valorRecolhidoCentavos += aposta.getQtnAposta();
			}

		}

		return valorRecolhidoCentavos;
	}

	/**
	 * Retorna o valor total dos seguros a serem pagos no cenário.
	 * 
	 * @return este valor em centavos.
	 */
	public int valorSeguros() {
		int valorSeguros = 0;
		for (Aposta aposta : this.conjuntoApostas) {
			if ((this.resultadoCenario == true && aposta.getPrevisao() == false)
					|| (this.resultadoCenario == false && aposta.getPrevisao() == true)) {

				valorSeguros += aposta.pagarSeguro();

			}
		}

		return valorSeguros;
	}

	/**
	 * Retorna um string que contem a representação do Cenário
	 * 
	 * @param numeracao
	 *            representa a numeração dos cenário
	 * @return uma string que representa o cenário.
	 */
	public String toString(int numeracao) {
		return String.format("%d - %s - %s", numeracao, this.descricao, estadoCenario());
	}

	/**
	 * Lanças todas as exceções referentes ao construtor
	 * 
	 * @param descricao
	 */
	private void tratarExcecoesConstrutor(String descricao) {
		if (descricao.equals(null)) {
			throw new NullPointerException("Descricao nula");
		} else if (descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
	}

	/**
	 * Retorna um string contendo o estado atual do cenário.
	 * 
	 * @return um String contendo o estado atual do cenário.
	 */
	private String estadoCenario() {
		if (this.estaTerminado == false) {
			return "Nao finalizado";
		} else if (this.resultadoCenario == true) {
			return "Finalizado (ocorreu)";
		} else {
			return "Finalizado (n ocorreu)";
		}
	}

	@Override
	public int compareTo(Cenario o) {
		return this.getDescricao().compareTo(o.getDescricao());
	}

}
