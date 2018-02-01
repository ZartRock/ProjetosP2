package sistema.entidades;

/**
 * Classe que representa uma apsota no sistema.
 * 
 * @author Áxel Medeiros
 * 
 */
public class Aposta {

	private String nomeApostador;
	private double qtnAposta;
	private boolean previsao; 

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

	public Aposta(String nomeApostador, double qtnAposta, String previsaoString) {
		tratarExcecoesConstrutor(nomeApostador, qtnAposta, previsaoString);

		this.nomeApostador = nomeApostador;
		this.qtnAposta = qtnAposta;
		this.previsao = retornarValorPrevisao(previsaoString);
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

	/**
	 * Função que agrupa todas as exceções contidas na construção os objetos do
	 * tipo Aposta.
	 * 
	 * @param nome
	 *            Representa o nome do apostador
	 * @param qtn
	 *            Representa a quantidade a ser apostada pelo jogador
	 * @param previsaoString
	 *            Representa o resultado do cenário que o apostador previu.
	 */
	private void tratarExcecoesConstrutor(String nome, double qtn,
			String previsaoString) {
		if (nome.equals(null)) {
			throw new NullPointerException("Nome nulo");
		}

		if (nome.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		} else if (qtn <= 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}

		if (previsaoString.trim().equals("") || previsaoString.equals(null)) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		}

	}

	/**
	 * Metodo com a obrigação de transformar previsões em String para Boolean,
	 * além de lança as exceções dessa operação.
	 * 
	 * @param previsaoString
	 * @return
	 */
	private boolean retornarValorPrevisao(String previsaoString) {
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
	private String retornaResultadoEsperadoString() {
		String resultado = "";
		if (this.previsao) {
			resultado = "VAI ACONTECER";
		} else {
			resultado = "N VAI ACONTECER";
		}

		return resultado;
	}

}
