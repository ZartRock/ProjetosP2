package sistema.entidades.apostas;

public class ApostaNormal extends Aposta{
	
	/**
	 * Metodo responsável construção de um objeto do tipo ApostaNormal.
	 * 
	 * @param nomeApostador
	 *            Refere-se ao nome do usuário que realizou a aposta.
	 * @param qtnAposta
	 *            Quantia a ser apostada.
	 * @param previsaoString
	 *            Representação em String da previsão do apostador.
	 */
	public ApostaNormal(String nomeApostador, double qtnAposta, String previsaoString) {
		super(nomeApostador, qtnAposta, previsaoString);
		tratarExcecoesConstrutor(nomeApostador, qtnAposta, previsaoString);
	}

	/**
	 * Responsável por retorna um representação da aposta em formato de texto.
	 * 
	 * @return uma váriavel String que representa a Aposta.
	 */
	
	
	@Override
	public String toString() {
		String resultadoEsperado = super.retornaResultadoEsperadoString();

		return String.format("%s - %f - %s", this.nomeApostador,
				this.qtnAposta, resultadoEsperado);
	}
	
	
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
	
}
