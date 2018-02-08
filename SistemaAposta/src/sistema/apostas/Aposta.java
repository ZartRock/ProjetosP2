package sistema.apostas;

import sistema.seguros.Seguro;

/**
 * Classe que representa uma apsota no sistema.
 * 
 * @author Áxel Medeiros
 * 
 */
public class Aposta {

	protected String nomeApostador;
	protected double qtnAposta;
	protected boolean previsao;
	private Seguro seguro;


	/**
	 * Metodo responsável construção de um objeto do tipo Aposta.
	 * 
	 * @param nomeApostador
	 *            Refere-se ao nome do usuário que realizou a aposta.
	 * @param qtnAposta
	 *            Quantia a ser apostada.
	 * @param previsaoString
	 *            Representação em String da previsão do apostador.
	 */

	public Aposta(String nomeApostador, double qtnAposta, String previsaoString, Seguro seguro) {
		this.nomeApostador = nomeApostador;
		this.qtnAposta = qtnAposta;
		this.previsao = retornarValorPrevisao(previsaoString);
		this.seguro = seguro;
	}
	
	
	public Aposta(String nomeApostador, double qtnAposta, String previsaoString){
		this(nomeApostador, qtnAposta, previsaoString, null);
	}

	/**
	 * Retorna a quantidade apostada pelo jogador.
	 * 
	 * @return Uma variavel que representa esta quantia.
	 */
	public double getQtnAposta() {
		return this.qtnAposta;
	}

	/**
	 * Retorna a previsão do cenário definida pelo jogador.
	 * 
	 * @return Um booelan que representa descrição.
	 */
	public boolean getPrevisao() {
		return this.previsao;
	}
	
	/**
	 * Metodo com a obrigação de transformar previsões em String para Boolean,
	 * além de lança as exceções dessa operação.
	 * 
	 * @param previsaoString
	 * @return
	 */
	protected boolean retornarValorPrevisao(String previsaoString) {
		if (previsaoString.equals("VAI ACONTECER")) {
			return true;
		} else if (previsaoString.equals("N VAI ACONTECER")) {
			return false;
		} else
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta: Previsao invalida");
	}
	
	
	
	/**
	 * Metodo que representa a saída de Boolean para string do resultado da
	 * aposta.
	 * 
	 * @return Uma Boolean representando a antiga string descrita pelo usuário.
	 */
	protected String retornaResultadoEsperadoString() {
		String resultado = "";
		if (this.previsao) {
			resultado = "VAI ACONTECER";
		} else {
			resultado = "N VAI ACONTECER";
		}

		return resultado;
	}
	
	
	
	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}


	/**
	 * Responsável por retorna um representação da aposta em formato de texto.
	 * 
	 * @return uma váriavel String que representa a Aposta.
	 */
	
	@Override
	public String toString() {
		String resultadoEsperado = retornaResultadoEsperadoString();

		return String.format("%s - %f - %s", this.nomeApostador,
				this.qtnAposta, resultadoEsperado);
	}
	
}
